package minesweeper.gui;


import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import minesweeper.domain.Field;
import minesweeper.game.Minesweeper;

/**
 *
 * @author Maniek
 */
public class UserInterface implements Runnable {
    private int width;
    private int height;
    private Minesweeper game;
    private JFrame frame;
    private ClickListener clickListener;
    private Map<Field, JButton> fieldButtons;
    public static final int SIDE_LENGTH = 50;
    private JLabel bombCounter;
    private JLabel time;
    
    
    public UserInterface(){
        this.width = 16;
        this.height = 16;
        this.game = new Minesweeper();
        this.fieldButtons = new HashMap<Field, JButton>();
    }
    public void giveFieldButtons(){
        this.game.setFieldButtons(this.fieldButtons);
    }
    public void giveBombCounter(){
        this.game.setBombCounter(this.bombCounter);
    }
    public void giveTime(){
        this.game.setTime(this.time);
    }

    @Override
    public void run() {
        this.frame = new JFrame("Minesweeper");
        int width = (this.width + 1) * SIDE_LENGTH + 10;
        int height = (this.height + 2) * SIDE_LENGTH + 10;
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        this.giveFieldButtons();
        this.giveBombCounter();
        this.giveTime();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.game.start();
    }
    
    public void createComponents(Container container){
        this.frame.setLayout(null);
        for (Field field : this.game.getFields()){
            JButton button = new JButton("");
            this.clickListener = new ClickListener(button, this.game, this.frame);
            button.setBounds(field.getX() * SIDE_LENGTH, field.getY() * SIDE_LENGTH, SIDE_LENGTH, SIDE_LENGTH);
            button.addMouseListener(this.clickListener);
            container.add(button);
            this.fieldButtons.put(field, button);
        }
        JLabel bomb = new JLabel();
        bomb.setBounds(1 * SIDE_LENGTH, this.height * SIDE_LENGTH, SIDE_LENGTH, SIDE_LENGTH);
        bomb.setText("Bombs: ");
        this.bombCounter = new JLabel();
        bombCounter.setBounds(2 * SIDE_LENGTH, this.height * SIDE_LENGTH, SIDE_LENGTH, SIDE_LENGTH);
        this.time = new JLabel();
        this.time.setBounds(3 * SIDE_LENGTH, this.height * SIDE_LENGTH, SIDE_LENGTH, SIDE_LENGTH);
        this.time.setText("00:00:00");
        container.add(bomb);
        container.add(bombCounter);
        container.add(time);    
    }   
}
