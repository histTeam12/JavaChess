package Logic;

import Pieces.QueenW;
import Pieces.RookB;
import Pieces.RookW;
import Pieces.QueenB;
import Pieces.Piece;
import Pieces.PawnW;
import Pieces.PawnB;
import Pieces.KingW;
import Pieces.KnightW;
import Pieces.KnightB;
import Pieces.KingB;
import Pieces.BishopB;
import Pieces.BishopW;
import java.util.EventObject;

/**
 * 
 * @author andreaskalstad
 */
public class ChessEvent extends EventObject {

    private boolean passant = false;
    private int team;
    private Piece piece;

    /*
     * Constructors
     */
    
    /**
     * 
     * @param source
     * @param team
     * @param piece
     */
    public ChessEvent(Object source, int team, Piece piece) {
        super(source);
        this.team = team;
        this.piece = piece;
    }
    /**
     * 
     * @param source
     * @param team
     */
    public ChessEvent(Object source, int team) {
        super(source);
        this.team = team;
    }

    /**
     * 
     * @return
     */
    public int team() {
        return team;
    }
    
    /**
     * 
     * @param a
     */
    public void setPassant(boolean a){
        passant = a;
    }

    //Method for checking which piece who gets taken and returning integers as indication of which piece it is
    /**
     * 
     * @return
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