package Pieces;

import Logic.PieceLabel;
import java.awt.Point;
import javax.swing.Icon;

/**
 * 
 * @author andreaskalstad
 */
public class PawnW extends Piece {
    private final int slope = -75;
    private boolean enPassant = false;
    
    /**
     * 
     * @param ikon
     */
    public PawnW(Icon ikon) {
        super(ikon);
        maxY = -75;
        maxX = 0;
        team = 1;
        name = "Pawn";
    }

    /**
     * 
     * @return
     */
    @Override
    public Icon getIcon() {
        return icon;
    }

    /**
     * 
     * @return
     */
    @Override
    public int getTeam() {
        return team;
    }
    
    /**
     * 
     * @return
     */
    public boolean getPassant(){
        return enPassant;
    }
    
    /**
     * 
     * @param b
     */
    public void setPassant(boolean b){
        enPassant = b;
    }
    
    //Setting the legal moves of the piece.
    /**
     * 
     * @param y
     * @param x
     * @param start
     * @param piece
     * @param lag2
     * @return
     */
    @Override
    public boolean legalMove(int y, int x, Point start, Object piece, int lag2) {
        if (lag2 == team) return false;
        if (start.getY() == 450) {if (y == (int) start.getY() + maxY * 2 && x == (int) start.getX()) {
                enPassant = true;
                setPassant(true);
                return true;
            }
        }
        if (!(piece instanceof PieceLabel) && y == (int) start.getY() + maxY && x == (int) start.getX()) {
            return true;
        }
        if (piece instanceof PieceLabel) {
            if (y == (int) start.getY() + maxY && x == (int) start.getX() + slope || y == (int) start.getY() + maxY && x == (int) start.getX() - slope ) {
                return true;
            }
        }
        return false;
    }
}
