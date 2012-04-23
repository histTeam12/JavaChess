package Accessories;

import Logic.PieceLabel;
import java.awt.Component;
import java.io.Serializable;
import Pieces.Piece;
import java.awt.Point;

/**
 * 
 * @author andreaskalstad
 */
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

    /**
     * 
     * @param title
     * @param turn
     * @param timerW
     * @param timerB
     * @param counterW
     * @param counterB
     * @param logW
     * @param logB
     * @param table
     * @param pieces
     * @param passanten
     * @param enPassantB
     * @param enPassantW
     * @param enPassantPW
     * @param enPassantPB
     * @param meme
     */
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
    /**
     * 
     * @param title
     * @param turn
     * @param counterW
     * @param counterB
     * @param logW
     * @param logB
     * @param table
     * @param pieces
     * @param passanten
     * @param enPassantB
     * @param enPassantW
     * @param enPassantPW
     * @param enPassantPB
     * @param meme
     */
    public SaveGame(String title, int turn, int[] counterW, int[] counterB, String logW, String logB, PieceLabel[] table, Piece[] pieces,
            boolean passanten, int enPassantB, int enPassantW, Point enPassantPW, Point enPassantPB, boolean meme) {
        
        this.title = title;
        this.turn = turn;
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

    //Constructor
    /**
     * 
     * @param turn
     * @param table
     * @param pieces
     */
    public SaveGame(int turn, PieceLabel[] table, Piece[] pieces) {
        this.turn = turn;
        this.table = table;
        this.pieces = pieces;
    }

    /*
     * Several get methods
     */
    
    /**
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @return
     */
    public int getTurn() {
        return turn;
    }

    /**
     * 
     */
    public void testTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }
    }

    /**
     * 
     * @return
     */
    public int[] getCounterB() {
        return counterB;
    }

    /**
     * 
     * @return
     */
    public int[] getCounterW() {
        return counterW;
    }

    /**
     * 
     * @return
     */
    public String getLogB() {
        return logB;
    }

    /**
     * 
     * @return
     */
    public String getLogW() {
        return logW;
    }

    /**
     * 
     * @return
     */
    public PieceLabel[] getTable() {
        return table;
    }

    /**
     * 
     * @return
     */
    public int[] getTimerB() {
        return timerB;
    }

    /**
     * 
     * @return
     */
    public Piece[] getPieces() {
        return pieces;
    }

    /**
     * 
     * @return
     */
    public int[] getTimerW() {
        return timerW;
    }
    /**
     * 
     * @return
     */
    public boolean getPassanten(){
        return passanten;
    }

    /**
     * 
     * @return
     */
    public int getEnPassantB() {
        return enPassantB;
    }

    /**
     * 
     * @return
     */
    public Point getEnPassantPB() {
        return enPassantPB;
    }

    /**
     * 
     * @return
     */
    public Point getEnPassantPW() {
        return enPassantPW;
    }

    /**
     * 
     * @return
     */
    public int getEnPassantW() {
        return enPassantW;
    }
    /**
     * 
     * @return
     */
    public boolean getMeme(){
        return meme;
    }
}