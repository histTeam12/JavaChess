package Accessories;

import Logic.PieceLabel;
import java.awt.Component;
import java.io.Serializable;
import Pieces.Piece;
import java.awt.Point;

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
    boolean passanten;
    int enPassantB;
    int enPassantW;
    Point enPassantPW;
    Point enPassantPB;
    boolean meme;

    public SaveGame(String title, int turn, int[] timerW, int[] timerB, int[] counterW, int[] counterB, String logW, String logB, PieceLabel[] table, Piece[] pieces,
            boolean passanten, int enPassantB, int enPassantW, Point enPassantPW, Point enPassantPB, boolean meme) {
        
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
        this.passanten = passanten;
        this.enPassantB = enPassantB;
        this.enPassantW = enPassantW;
        this.enPassantPW = enPassantPW;
        this.enPassantPB = enPassantPB;
        this.meme = meme;

    }

    public SaveGame(int turn, PieceLabel[] table, Piece[] pieces) {
        this.turn = turn;
        this.table = table;
        this.pieces = pieces;
    }

    public String getTitle() {
        return title;
    }

    public int getTurn() {
        return turn;
    }

    public void testTable() {
        for (int i = 0; i < table.length; i++) {
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

    public Piece[] getPieces() {
        return pieces;
    }

    public int[] getTimerW() {
        return timerW;
    }
    public boolean getPassanten(){
        return passanten;
    }

    public int getEnPassantB() {
        return enPassantB;
    }

    public Point getEnPassantPB() {
        return enPassantPB;
    }

    public Point getEnPassantPW() {
        return enPassantPW;
    }

    public int getEnPassantW() {
        return enPassantW;
    }
    public boolean getMeme(){
        return meme;
    }
}