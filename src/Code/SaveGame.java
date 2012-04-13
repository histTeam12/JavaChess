package Code;

import java.awt.Component;
import java.io.Serializable;

public class SaveGame implements Serializable {

    private String title;
    private int turn;
    private int[] timerW;
    private int[] timerB;
    private int[] counterW;
    private int[] counterB;
    private String logW;
    private String logB;
    private PieceLabel[] table;
    Piece[] pieces;

    public SaveGame(String title, int turn, int[] timerW, int[] timerB, int[] counterW, int[] counterB, String logW, String logB, PieceLabel[] table, Piece[] pieces) {
        this.title = title;
        this.turn = turn;
        this.timerW = timerW;
        this.timerB = timerB;
        int[] tab = {counterW[0], counterW[1], counterW[2], counterW[3], counterW[4], counterW[5]};
        this.counterW = tab;
        int[] tab2 = {counterB[0], counterB[1], counterB[2], counterB[3], counterB[4], counterB[5]};
        this.counterB = tab2;
        this.logW = logW;
        this.logB = logB;
        this.table = table;
        this.pieces = pieces;
    }
    public String getTitle(){
        return title;
    }
    
    public int getTurn(){
        return turn;
    }
    public void testTable(){
        for(int i = 0; i<table.length;i++){
            System.out.println(table[i]);
        }
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

    public PieceLabel[] getTable() {
        return table;
    }

    public int[] getTimerB() {
        return timerB;
    }
    public Piece[] getPieces(){
            return pieces;
    }
    public int[] getTimerW() {
        return timerW;
    }
    
}
