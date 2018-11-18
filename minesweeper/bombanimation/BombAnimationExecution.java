package minesweeper.bombanimation;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maniek
 */
public class BombAnimationExecution{
    private BombAnimationDisplay display;
    
    public BombAnimationExecution(){
        this.display = new BombAnimationDisplay();
    }

    public void execute() {
        try {
            Thread.sleep(100);
            this.display.run();
            this.display.getFrame().repaint();
            this.display.getAnimation().setSequence(1);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(2);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(3);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(4);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(5);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(6);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(7);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(8);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(9);
            this.display.getFrame().repaint();
            Thread.sleep(500);
            this.display.getAnimation().setSequence(10);
            this.display.getFrame().repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(BombAnimationExecution.class.getName()).log(Level.SEVERE, null, ex);
        }       
    } 
}
