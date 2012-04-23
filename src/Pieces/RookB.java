package Pieces;

import Pieces.Piece;
import java.awt.Point;
import javax.swing.Icon;

/**
 * 
 * @author andreaskalstad
 */
public class RookB extends Piece {
    private boolean move = false;
    

    /**
     * 
     * @param icon
     */
    public RookB(Icon icon) {
        super(icon);
        team = 2;
        name = "Rook";
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
        if (y != (int) start.getY() && x == (int) start.getX()){
            return true;
        }
        if (y == (int) start.getY() && x != (int) start.getX()){
            return true;
        }
        return false;
    }
}
