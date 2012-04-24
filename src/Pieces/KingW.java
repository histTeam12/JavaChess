package Pieces;

import java.awt.Point;
import javax.swing.Icon;

/**
 * Specifies the piece as a white king
 * @author andreaskalstad
 */
public class KingW extends Piece {
    private boolean move = false;

    /**
     * Constructs a white king
     * @param icon
     * Sets icon as label
     */
    public KingW(Icon icon) {
        super(icon);
        maxY = 75;
        maxX = 75;
        team = 1;
        name = "King";
    }

    /**
     * Returns if the king has moved for the castling method
     * @return
     * Boolean
     */
    public boolean move() {
        return move;
    }

    /**
     * Sets if the king has moved for the castling method
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
