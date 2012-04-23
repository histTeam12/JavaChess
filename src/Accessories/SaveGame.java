package Accessories;

import Logic.PieceLabel;
import java.awt.Component;
import java.io.Serializable;
import Pieces.Piece;
import java.awt.Point;

/**
 * Creates a saved chess game
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
     * Constructor which creates a saved chess game
     * @param title
     * String - title of the saved game
     * @param turn
     * Integer - who`s turn it is
     * @param timerW
     * Integer array - the white players timer of the saved game
     * @param timerB
     * Integer array - the black players timer of the saved game
     * @param counterW
     * Integer array - the white players dead pieces
     * @param counterB
     * Integer array - the black players dead pieces
     * @param logW
     * String - the white players log of moves
     * @param logB
     * String - the black players log of moves
     * @param table
     * Piece label array - the chess table
     * @param pieces
     * Piece array - the chess pieces
     * @param passanten
     * Boolean - if a passant move is possible
     * @param enPassantB
     * Integer - index of the passant possibility on the white
     * @param enPassantW
     * Integer - index of the passant possibility on the black side
     * @param enPassantPW
     * Point - position of the passant possibility on the white side
     * @param enPassantPB
     * Point - position of the passant possibility on the black side
     * @param meme
     * Boolean - if meme pieces is on or off
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
     * Constructor which creates a saved chess game without timers
     * @param title
     * String - title of the saved game
     * @param turn
     * Integer - who`s turn it is
     * @param counterW
     * Integer array - the white players dead pieces
     * @param counterB
     * Integer array - the black players dead pieces
     * @param logW
     * String - the white players log of moves
     * @param logB
     * String - the black players log of moves
     * @param table
     * Piece label array - the chess table
     * @param pieces
     * Piece array - the chess pieces
     * @param passanten
     * Boolean - if a passant move is possible
     * @param enPassantB
     * Integer - index of the passant possibility on the white
     * @param enPassantW
     * Integer - index of the passant possibility on the black side
     * @param enPassantPW
     * Point - position of the passant possibility on the white side
     * @param enPassantPB
     * Point - position of the passant possibility on the black side
     * @param meme
     * Boolean - if meme pieces is on or off
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

    /**
     * Constructs a save game
     * @param turn
     * Integer - who`s turn it is
     * @param table
     * Piece label array
     * @param pieces
     * Pieces array
     */
    public SaveGame(int turn, PieceLabel[] table, Piece[] pieces) {
        this.turn = turn;
        this.table = table;
        this.pieces = pieces;
    }
    
    /**
     * Returns the title of the save game
     * @return
     * String with title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns an integer which indicates who`s turn it is
     * @return
     * Integer
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Returns an array of the black sides lost pieces
     * @return
     * Integer array
     */
    public int[] getCounterB() {
        return counterB;
    }

    /**
     * Returns an array of the white sides lost pieces
     * @return
     * Integer array
     */
    public int[] getCounterW() {
        return counterW;
    }

    /**
     * Returns a string of text with a log of the movements of the black side
     * @return
     * String with movements
     */
    public String getLogB() {
        return logB;
    }

    /**
     * Returns a string of text with a log of the movements of the white side
     * @return
     * String with movements
     */
    public String getLogW() {
        return logW;
    }

    /**
     * Returns an array with the piece labels
     * @return
     * Piece label array
     */
    public PieceLabel[] getTable() {
        return table;
    }

    /**
     * Returns the black sides timer
     * @return
     * Integer array
     */
    public int[] getTimerB() {
        return timerB;
    }

    /**
     * Returns an array of pieces
     * @return
     * Array of pieces
     */
    public Piece[] getPieces() {
        return pieces;
    }

    /**
     * Returns the white sides timer
     * @return
     * Integer array
     */
    public int[] getTimerW() {
        return timerW;
    }
    /**
     * Returns if a en passant move is possible
     * @return
     * Boolean
     */
    public boolean getPassanten(){
        return passanten;
    }

    /**
     * Returns index of where an en passant move is legal
     * @return
     * Integer
     */
    public int getEnPassantB() {
        return enPassantB;
    }

    /**
     * Returns a point of where an en passant move is legal - black side
     * @return
     * Point object
     */
    public Point getEnPassantPB() {
        return enPassantPB;
    }

    /**
     * Returns a point of where an en passant move is legal - white side
     * @return
     * Point object
     */
    public Point getEnPassantPW() {
        return enPassantPW;
    }

    /**
     * Returns index of where an en passant move is legal - white side
     * @return
     * Integer
     */
    public int getEnPassantW() {
        return enPassantW;
    }
    /**
     * Returns true if meme option is selected
     * @return
     * Boolean
     */
    public boolean getMeme(){
        return meme;
    }
}