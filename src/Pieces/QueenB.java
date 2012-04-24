package Pieces;

import Pieces.Piece;
import java.awt.Point;
import javax.swing.Icon;

/**
 * Specifies the piece as a black queen
 * @author andreaskalstad
 */
public class QueenB extends Piece {


    /**
     * Constructs a black queen
     * @param icon
     * Sets icon as label
     */
    public QueenB(Icon icon) {
        super(icon);
        maxY = -75;
        maxX = 0;
        team = 2;
        name = "Queen";
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
        if ((Math.abs((int)start.getX() - x) == (Math.abs((int)start.getY()-y))) && (Math.abs((int)start.getY()-y) >= 75)){
                return true;
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
