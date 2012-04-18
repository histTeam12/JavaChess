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

public class ChessEvent extends EventObject {

    private boolean passant = false;
    private int team;
    private Piece piece;

    public ChessEvent(Object source, int team, Piece piece) {
        super(source);
        this.team = team;
        this.piece = piece;
    }
    public ChessEvent(Object source, int team) {
        super(source);
        this.team = team;
    }

    public int team() {
        return team;
    }
    
    public void setPassant(boolean a){
        passant = a;
    }

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