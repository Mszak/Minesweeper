package minesweeper.highscores;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Maniek
 */
public class SubmitHighscore {
    private JFrame frame;
    private Highscores h;
    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;
    private JOptionPane pane;
    
    public SubmitHighscore(){
        this.frame = new JFrame("Highscores");
        this.h = h;
        this.pane = new JOptionPane();
    }
    public void display(){
        this.frame = new JFrame("Congratulations!");
        this.frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        String name = this.pane.showInputDialog("please enter value");
        this.frame.add(this.pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
