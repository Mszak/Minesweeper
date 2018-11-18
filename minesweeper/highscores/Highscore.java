package minesweeper.highscores;
import minesweeper.game.Minesweeper;

/**
 *
 * @author Maniek
 */
public class Highscore implements Comparable {
    private Long startTime;
    private Long endTime;
    private String name;
    
    public Highscore(Long startTime, long endTime, String name){
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public Long getStartTime(){
        return this.startTime;
    }
    public Long getEndTime(){
        return this.endTime;
    }
    public String getTime(){
        return Minesweeper.gameTime(this.startTime, this.endTime);
    }
    public String toString(){
        return this.name + " " + this.getTime();
    }

    @Override
    public int compareTo(Object o) {
        if (this.getClass() != o.getClass()){
            throw new Error("Object is not the same class!");
        }
        Highscore compared = (Highscore) o;
        if ((this.endTime - this.startTime) == (compared.endTime - compared.startTime)){
            return 0;
        }
        if ((this.endTime - this.startTime) > (compared.endTime - compared.startTime)){
            return 1;
        }
        else{
            return -1;
        }
    }
}
