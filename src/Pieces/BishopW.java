package Pieces;

import java.awt.Point;
import javax.swing.Icon;

/**
 * 
 * @author andreaskalstad
 */
public class BishopW extends Piece {

    /**
     * 
     * @param icon
     */
    public BishopW(Icon icon) {
        super(icon);
        team = 1;
        name = "Bishop";
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
        if (team2 == team) return false;
        if ((Math.abs((int)start.getX() - x) == (Math.abs((int)start.getY()-y))) && (Math.abs((int)start.getY()-y) >= 75)){
                return true;
        }
        return false;
    }
}
