package minesweeper.bombanimation;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Maniek
 */
public class BombAnimation extends JPanel{

    private int height;
    private int width;
    private int sequence;
    
    public BombAnimation(){
        this.height = 500;
        this.width = 500;
        this.sequence = 0;
    }
  
    public void paintComponent(Graphics g){
        if (this.sequence == 0){
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.fillOval(245, 165, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 1){
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.setColor(Color.red);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 2){
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.setColor(Color.red);
            g.fillOval(245, 170, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 3){
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.setColor(Color.red);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 4){
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.setColor(Color.red);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 5){
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.setColor(Color.red);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 6){
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.setColor(Color.red);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 7){
            g.fillOval(200, 200, 100, 100);
            g.setColor(Color.red);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 8){
            g.setColor(Color.red);
            g.fillOval(200, 200, 100, 100);
            g.fillOval(245, 195, 10, 10);
            g.fillOval(245, 190, 10, 10);
            g.fillOval(245, 185, 10, 10);
            g.fillOval(245, 180, 10, 10);
            g.fillOval(245, 175, 10, 10);
            g.fillOval(245, 170, 10, 10);
            g.fillArc(245, 165, 10, 10, 90, -90);
        }
        if (this.sequence == 9){
            g.setColor(Color.black);
            Font font = new Font("Serif", Font.BOLD, 50);
            g.setFont(font);
            g.drawString("BOOM!", 150, 225);
        }
        if (this.sequence == 10){
            g.setColor(Color.black);
            Font font = new Font("Serif", Font.BOLD, 50);
            g.setFont(font);
            g.drawString("BOOM!", 150, 225);
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString("You Lost!", 150, 275);
        }
    }
    public void setSequence(int sequence){
        this.sequence = sequence;
    }
    
}
