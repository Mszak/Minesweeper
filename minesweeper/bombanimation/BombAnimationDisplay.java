package minesweeper.bombanimation;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Maniek
 */
public class BombAnimationDisplay implements Runnable {

    private JFrame frame;
    private int width;
    private int height;
    private BombAnimation animation;
    
    public BombAnimationDisplay(){
        this.width = 500;
        this.height = 500;
    }
    
    
    @Override
    public void run() {
        frame = new JFrame("You lost!");
        frame.setPreferredSize(new Dimension(this.width, this.height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void createComponents(Container container){
        this.animation = new BombAnimation();
        container.add(animation);
    }
    public BombAnimation getAnimation(){
        return this.animation;
    }
    public JFrame getFrame(){
        return this.frame;
    }
}
