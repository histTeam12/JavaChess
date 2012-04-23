package Pieces;

import Pieces.Piece;
import java.awt.Point;
import javax.swing.Icon;

/**
 * 
 * @author andreaskalstad
 */
public class QueenW extends Piece {

    private final int slope = -75;

    /**
     * 
     * @param ikon
     */
    public QueenW(Icon ikon) {
        super(ikon);
        maxY = -75;
        maxX = 0;
        team = 1;
        name = "Queen";
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
