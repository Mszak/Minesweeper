package minesweeper.domain;
import minesweeper.Status;

/**
 *
 * @author Maniek
 */
public class Field {
    private int x;
    private int y;
    private boolean bomb;
    private Status status;
    
    public Field(int x, int y){
        this.x = x;
        this.y = y;
        this.bomb = false;
        this.status = Status.CLEAN;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean isBomb(){
        return this.bomb;
    }
    public Status getStatus(){
        return this.status;
    }
    public void setBomb(){
        this.bomb = true;
    }
    public void setStatus(Status s){
        this.status = s;
    }
    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.bomb + ")";
    }
}
