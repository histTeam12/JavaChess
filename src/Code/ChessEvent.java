/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Henrik
 */
import java.util.EventObject;

public class ChessEvent extends EventObject {

    private int lag;
    private Piece brikke;

    public ChessEvent(Object source, int lag, Piece brikke) {
        super(source);
        this.lag = lag;
        this.brikke = brikke;
    }
    public ChessEvent(Object source, int lag) {
        super(source);
        this.lag = lag;
    }

    public int lag() {
        return lag;
    }

    public int brikke() {
        if (brikke instanceof KnightW || brikke instanceof KnightB) {
            return 1;
        }
        if (brikke instanceof BishopW || brikke instanceof BishopB) {
            return 2;
        }
        if (brikke instanceof RookW || brikke instanceof RookB) {
            return 3;
        }
        if (brikke instanceof QueenW || brikke instanceof QueenB) {
            return 4;
        }
        if (brikke instanceof KingW || brikke instanceof KingB) {
            return 5;
        }
        if (brikke instanceof PawnW || brikke instanceof PawnB) {
            return 0;
        }
        return -1;
    }
}