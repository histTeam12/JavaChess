package Logic;

import Pieces.*;
import java.util.EventObject;

/**
 * Creates events that enables the chess class to be able to talk with other classes
 * @author andreaskalstad
 */
public class ChessEvent extends EventObject {

    private boolean passant = false;
    private int team;
    private Piece piece;

    /**
     * Constructs a new chess event
     * @param source
     * Source of the event
     * @param team
     * Indication of which team made the event
     * @param piece
     * Indication of which piece made the event
     */
    public ChessEvent(Object source, int team, Piece piece) {
        super(source);
        this.team = team;
        this.piece = piece;
    }
    /**
     * Constructs a new chess event
     * @param source
     * Source of the event
     * @param team
     * Indication of which team made the event
     */
    public ChessEvent(Object source, int team) {
        super(source);
        this.team = team;
    }

    /**
     * Returns integer value which indicates the team of the piece
     * @return Team of the piece
     */
    public int team() {
        return team;
    }
    
    /**
     * Sets instance variable passant to given boolean parameter
     * @param a
     * True if a passant move is legal
     */
    public void setPassant(boolean a){
        passant = a;
    }

    /**
     * Method for checking which piece who gets taken and returning integers as indication of which piece it is
     * @return Integer value which indicate which piece has been taken of the table
     */
    public int piece() {
        if (piece instanceof PawnW || piece instanceof PawnB || passant == true) {
            return 0;
        }
        if (piece instanceof KnightW || piece instanceof KnightB) {
            return 1;
        }
        if (piece instanceof RookW || piece instanceof RookB) {
            return 2;
        }
        if (piece instanceof QueenW || piece instanceof QueenB) {
            return 3;
        }
        if (piece instanceof BishopW || piece instanceof BishopB) {
            return 4;
        }
        if (piece instanceof KingW || piece instanceof KingB) {
            return 5;
        }        
        return -1;
    }
}