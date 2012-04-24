package Pieces;

import java.awt.Point;
import javax.swing.Icon;

/**
 * 
 * @author andreaskalstad
 */
public class KingB extends Piece {

    private boolean move = false;

    /**
     * 
     * @param icon
     */
    public KingB(Icon icon) {
        super(icon);
        maxY = 75;
        maxX = 75;
        team = 2;
        name = "King";
    }


    /**
     * 
     * @return
     */
    public boolean move() {
        return move;
    }

    /**
     * 
     */
    public void setMove() {
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
        if (Math.abs(y - start.getY()) == maxY && Math.abs(x - start.getX()) == maxX) {
            return true;
        }
        if (Math.abs(y - start.getY()) == maxY && Math.abs(x - start.getX()) == 0) {
            return true;
        }
        if (Math.abs(y - start.getY()) == 0 && Math.abs(x - start.getX()) == maxX) {
            return true;
        }
        return false;
    }
}
