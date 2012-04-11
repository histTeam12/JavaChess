package Code;

import java.io.Serializable;

public class SaveGame implements Serializable {

    private String title;
    private Timer timerW;
    private Timer timerB;
    private int[] counterW;
    private int[] counterB;
    private String logW;
    private String logB;
    private ChessTable table;

    public SaveGame(String title, Timer timerW, Timer timerB, int[] counterW, int[] counterB, String logW, String logB, ChessTable table) {
        this.title = title;
        this.timerW = timerW;
        this.timerB = timerB;
        this.counterW = counterW;
        this.counterB = counterB;
        this.logW = logW;
        this.logB = logB;
        this.table = table;
    }
    public String getTitle(){
        return title;
    }

    public int[] getCounterB() {
        return counterB;
    }

    public int[] getCounterW() {
        return counterW;
    }

    public String getLogB() {
        return logB;
    }

    public String getLogW() {
        return logW;
    }

    public ChessTable getTable() {
        return table;
    }

    public Timer getTimerB() {
        return timerB;
    }

    public Timer getTimerW() {
        return timerW;
    }
    
}
