package minesweeper.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import minesweeper.Status;
import minesweeper.bombanimation.BombAnimationExecution;
import minesweeper.domain.Field;
import minesweeper.highscores.*;

/**
 *
 * @author Maniek
 */
public class Minesweeper{
    private List<Field> fields;
    private int width;
    private int height;
    private int bombs;
    private Random random;
    private Boolean stillPlaying;
    private Map<Field, JButton> fieldButtons;
    private BombAnimationExecution execution;
    private JLabel bombCounter;
    private JLabel time;
    
    public Minesweeper(){
        this.width = 16;
        this.height = 16;
        this.bombs = 40;
        this.fields = new ArrayList<Field>();
        this.random = new Random();
        this.stillPlaying = true;
        this.fieldButtons = new HashMap<Field, JButton>();
        this.execution = new BombAnimationExecution();
        this.initialize();
    }
    public void initialize(){
        List<Integer> help = new ArrayList<Integer>();
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                this.fields.add(new Field(i, j));
            }
        }
        for (int i = 0; i < this.width * this.height; i++){
            help.add(i);
        }
        for (int i = 0; i < this.bombs; i++){
            int index = this.random.nextInt(help.size());
            int index2 = help.get(index);
            help.remove(index);
            this.fields.get(index2).setBomb();
        }
    }
    public void setFieldButtons(Map<Field, JButton> map){
        this.fieldButtons = map;
    }
    public Map<Field, JButton> getFieldButtons(){
        return this.fieldButtons;
    }
    public List<Field> getFields(){
        return this.fields;
    }
    public boolean isStillPlaying(){
        return this.stillPlaying;
    }
    public void setStillPlaying(boolean b){
        this.stillPlaying = b;
    }
    public void setBombCounter(JLabel bombCounter){
        this.bombCounter = bombCounter;
    }
    public void setTime(JLabel time){
        this.time = time;
    }
    public Field getField(int x, int y){
        for (Field field : this.fields){
            if ((field.getX() == x) && (field.getY() == y)){
                return field;
            }
        }
        return null;
    }
    public int getFieldIndex(int x, int y){
        for (int i = 0; i < this.fields.size() - 1; i++){
            if ((this.fields.get(i).getX() == x) && (this.fields.get(i).getY() == y)){
                return i;
            }
        }
        return 0;
    }
    public int howManyBombsAround(int x, int y){
        int counter = 0;
        List<Field> helpList = new ArrayList<Field>();
        helpList.add(this.getField(x+1, y));
        helpList.add(this.getField(x-1, y));
        helpList.add(this.getField(x, y+1));
        helpList.add(this.getField(x, y-1));
        helpList.add(this.getField(x-1, y+1));
        helpList.add(this.getField(x-1, y-1));
        helpList.add(this.getField(x+1, y+1));
        helpList.add(this.getField(x+1, y-1));

        for (Field field : helpList){
            if (field != null){
                if (field.isBomb()){
                    counter++;
                }   
            }  
        }  
        return counter;
    }
    public void start(){
        long startTime = System.nanoTime();
        long elapsedTime = 0;
        long endTime = 0;
        boolean win = false;
        while (this.stillPlaying){   
            int pressedFields = 0;
            int bombsCounted = 0;
            for (Field field : this.fields){
                if (field.getStatus() == Status.PRESSED){
                    pressedFields++;
                }
            }
            if (pressedFields == this.fields.size() - this.bombs){
                this.stillPlaying = false;
                win = true;
            }
            pressedFields = 0;
            for (Field field : this.fields){
                if (field.getStatus() == Status.BOMB){
                    bombsCounted++;
                }
            }
            String helpText = Integer.toString(bombsCounted);
            helpText += "/";
            helpText += Integer.toString(this.bombs);
            this.bombCounter.setText(helpText);
            bombsCounted = 0;
            elapsedTime = System.nanoTime();
            this.time.setText(this.gameTime(startTime, elapsedTime));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Minesweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(win){
           System.out.println("end"); 
           endTime = System.nanoTime();
           String nameOfPlayer = JOptionPane.showInputDialog("Type your name, winner!");
           Highscores h = new Highscores();
           h.addHighscore(new Highscore(startTime, endTime, nameOfPlayer));
           HighscoresDisplay hd = new HighscoresDisplay(h);
           hd.display();
        }
        else{
            endTime = System.nanoTime();
            this.execution.execute();
        }
        
    }
    public static String gameTime(long start, long elapsed){
        long time = (elapsed - start)/1000000000;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        boolean n = true;
        while(n){
            while (time > 3599 ){
                hours++;
                time -= 3600;
            }
            while (time > 59){
                minutes++;
                time -= 60;
            }
            seconds = (int)time;
            n = false;
        }
        String game = "";
        if (hours >= 10){
            game += Integer.toString(hours);
        }
        else{
            game += "0";
            game += Integer.toString(hours);
        }
        game += ":";
        if (minutes >= 10){
            game += Integer.toString(minutes);
        }
        else{
            game += "0";
            game += Integer.toString(minutes);
        }
        game += ":";
        if (seconds >= 10){
            game += Integer.toString(seconds);
        }
        else{
            game += "0";
            game += Integer.toString(seconds);
        }
        return game;
    }  
}
