package Pieces;

import Logic.PieceLabel;
import java.awt.Point;
import javax.swing.Icon;

/**
 * 
 * @author andreaskalstad
 */
public class PawnB extends Piece {
    
    private boolean enPassant = false;
    
    /**
     * 
     * @param icon
     */
    public PawnB(Icon icon) {
        super(icon);
        maxY = 75;
        maxX = 0;
        team = 2;
        name = "Pawn";
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
     * Method for checking the legal moves of a piece which is taken in as parameter
     * @param y
     * distance moved on the y axis in pixels
     * @param x
     * distance moved on the x axis in pixels
     * @param start
     * the pieces starting point
     * @param piece
     * the piece being moved
     * @param team2
     * the team this piece belongs to
     * @return
     * true if legal move, else false
     */
    @Override
    public boolean legalMove(int y, int x, Point start, Object piece, int team2) {
        if (team2 == team) return false;
        if (start.getY() == 75) {
            if (!(piece instanceof PieceLabel) && y == (int) start.getY() + maxY * 2 && x == (int) start.getX()) {
                setPassant(true);
                return true;
            }
        }
        if (!(piece instanceof PieceLabel) && y == (int) start.getY() + maxY && x == (int) start.getX()) {
            return true;
        }
        if (piece instanceof PieceLabel) {
            if (y == (int) start.getY() + maxY && x == (int) start.getX() + 75 || y == (int) start.getY() + maxY && x == (int) start.getX() - 75 ) {
                return true;
            }
        }
        return false;
    }
}
