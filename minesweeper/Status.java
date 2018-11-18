package minesweeper;

/**
 *
 * @author Maniek
 */
public enum Status {
    CLEAN, QUESTION, BOMB, PRESSED;
    
    private Status next;
    static {
        CLEAN.next = QUESTION;
        QUESTION.next = BOMB;
        BOMB.next = CLEAN;
    }
    public Status getNext(){
        return next;
    }
}

