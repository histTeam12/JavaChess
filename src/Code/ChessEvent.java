package Code;

import java.util.EventObject;

public class ChessEvent extends EventObject {

    private boolean passanten = false;
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
        passanten = a;
    }

    public int piece() {
        if (piece instanceof PawnW || piece instanceof PawnB || passanten == true) {
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