package minesweeper.gui;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import minesweeper.Status;
import minesweeper.domain.Field;
import minesweeper.game.Minesweeper;
import static minesweeper.gui.UserInterface.SIDE_LENGTH;

/**
 *
 * @author Maniek
 */
public class ClickListener implements MouseListener{

    private JButton button;
    private Minesweeper game;
    private JFrame frame;
    
    public ClickListener(JButton button, Minesweeper game, JFrame frame){
        this.button = button;
        this.game = game;
        this.frame = frame;
    }
    public Set<Field> emptySpaces(int x, int y){
        Set<Field> anotherEmptyFields = new HashSet<Field>();
        Map<Field, JButton> map = this.game.getFieldButtons();
        List<Field> helpList = new ArrayList<Field>();
        helpList.add(this.game.getField(x+1, y));
        helpList.add(this.game.getField(x-1, y));
        helpList.add(this.game.getField(x, y+1));
        helpList.add(this.game.getField(x, y-1));
        helpList.add(this.game.getField(x-1, y+1));
        helpList.add(this.game.getField(x-1, y-1));
        helpList.add(this.game.getField(x+1, y+1));
        helpList.add(this.game.getField(x+1, y-1));
        
        for (Field field : helpList){
            if ((field != null) && (field.getStatus() != Status.PRESSED)){
                field.setStatus(Status.PRESSED);
                if (this.game.howManyBombsAround(field.getX(), field.getY()) != 0){
                    map.get(field).setText(Integer.toString(this.game.howManyBombsAround(field.getX(), field.getY())));
                }
                if (this.game.howManyBombsAround(field.getX(), field.getY()) == 0){
                    anotherEmptyFields.add(field);
                }
                map.get(field).setEnabled(false);
            }
        }
        return anotherEmptyFields;
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {
        int click = e.getButton();
        if (click == MouseEvent.BUTTON1){
            int x = this.button.getBounds().x/SIDE_LENGTH;
            int y = this.button.getBounds().y/SIDE_LENGTH;
            Field field = this.game.getField(x, y);
            if (field.getStatus() == Status.CLEAN){
                if (field.isBomb()){
                    this.game.setStillPlaying(false);                  
                }
                if (!field.isBomb()){
                    field.setStatus(Status.PRESSED);
                    int bombs = this.game.howManyBombsAround(x, y);
                    this.button.setEnabled(false);
                    if (bombs == 0){
                        Set<Field> empty = this.emptySpaces(x, y);
                        Set<Field> help = this.emptySpaces(x, y);
                        help.removeAll(help);
                        while(!empty.isEmpty()){
                        for (Field f : empty){
                            int xi = f.getX();
                            int yi = f.getY();
                            help.addAll(this.emptySpaces(xi, yi));
                        }
                        empty.removeAll(empty);
                        empty.addAll(help);
                        help.removeAll(help);
                        }             
                    }
                    else{
                        this.button.setText(Integer.toString(bombs));
                    }
                }
                if (!this.game.isStillPlaying()){
                    this.frame.setEnabled(false);
                } 
            }     
        }
        if (click == MouseEvent.BUTTON3){
            int x = this.button.getBounds().x/SIDE_LENGTH;
            int y = this.button.getBounds().y/SIDE_LENGTH;
            Field field = this.game.getField(x, y);
            Status status = field.getStatus();
            if (status != Status.PRESSED){
                field.setStatus(status.getNext());
                status = field.getStatus();
                if (status == Status.BOMB){
                    this.button.setText("X");
                    this.button.setEnabled(false);
                    this.button.setBackground(Color.red);
                }
                if (status == Status.QUESTION){
                    this.button.setText("?");
                    this.button.setEnabled(false);
                    this.button.setBackground(Color.gray);
                }
                if (status == Status.CLEAN){
                    this.button.setText("");
                    this.button.setEnabled(true);
                    this.button.setBackground(new JButton().getBackground());
                }
            }
            if (status == Status.PRESSED){
                int bombsNumber = this.game.howManyBombsAround(x, y);
                if (bombsNumber == 0){
                    this.button.setText("");
                }
                else{
                    this.button.setText(Integer.toString(bombsNumber));
                }               
                this.button.setBackground(new JButton().getBackground());
            }
            if (!this.game.isStillPlaying()){
                this.frame.setEnabled(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
