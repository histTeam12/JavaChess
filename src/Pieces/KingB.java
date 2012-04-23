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
    public boolean move() {
        return move;
    }

    /**
     * 
     */
    public void setMove() {
        move = true;
    }
    //Setting the legal moves of the piece.
    /**
     * 
     * @param y
     * @param x
     * @param start
     * @param piece
     * @param team2
     * @return
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
