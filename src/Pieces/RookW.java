package Pieces;

import Pieces.Piece;
import java.awt.Point;
import javax.swing.Icon;

/**
 * Specifies the piece as a white rook
 * @author andreaskalstad
 */
public class RookW extends Piece {
    private boolean move = false;

    /**
     * Constructs a white rook
     * @param icon
     * Sets icon as label
     */
    public RookW(Icon icon) {
        super(icon);
        team = 1;
        name = "Rook";
    }
    /**
     * Registers if the rook has moved for the castling
     * @return
     * if the rook has moved
     */
    public boolean move(){
        return move;
    }
    /**
     * Sets if the rook has moved
     */
    public void setMove(){
        move = true;
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
        if (team2 == team) {
            return false;        
        }
        if (y != (int) start.getY() && x == (int) start.getX()){
            return true;
        }
        if (y == (int) start.getY() && x != (int) start.getX()){
            return true;
        }
        return false;
    }
}
