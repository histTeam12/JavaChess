package Pieces;

import Logic.PieceLabel;
import java.awt.Point;
import javax.swing.Icon;

/**
 * Specifies the piece as a white pawn
 * @author andreaskalstad
 */
public class PawnW extends Piece {
    
    private boolean enPassant = false;
    
    /**
     * Constructs a white pawn
     * @param icon
     * Sets icon as label
     */
    public PawnW(Icon icon) {
        super(icon);
        maxY = -75;
        maxX = 0;
        team = 1;
        name = "Pawn";
    }
    /**
     * Returns if the pawn can be the victim of a en passant 
     * @return
     * Boolean
     */
    public boolean getPassant(){
        return enPassant;
    }
    
    /**
     * Sets if the pawn can be the victim of a en passant 
     * @param b
     * Boolean
     */
    public void setPassant(boolean b){
        enPassant = b;
    }
    
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
            if (y == (int) start.getY() + maxY && x == (int) start.getX() -75 || y == (int) start.getY() + maxY && x == (int) start.getX() +75 ) {
                return true;
            }
        }
        return false;
    }
}
