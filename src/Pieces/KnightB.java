package Pieces;

import java.awt.Point;
import javax.swing.Icon;

/**
 * Specifies the piece as a black knight
 * @author andreaskalstad
 */
public class KnightB extends Piece {

    /**
     * Constructs a black knight
     * @param icon
     * Sets icon as label
     */
    public KnightB(Icon icon) {
        super(icon);
        maxY = 75;
        maxX = 75;
        team = 2;
        name = "Knight";
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
        if ((Math.abs(y-start.getY())== maxY*2 && Math.abs(x-start.getX())== maxX)||(Math.abs(x-start.getX())== maxX*2 && Math.abs(y-start.getY())== maxY)){
            return true;
        }
        return false;
    }
}
