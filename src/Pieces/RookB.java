package Pieces;

import Pieces.Piece;
import java.awt.Point;
import javax.swing.Icon;

public class RookB extends Piece {
    private boolean move = false;
    

    public RookB(Icon icon) {
        super(icon);
        team = 2;
        name = "Rook";
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public int getTeam() {
        return team;
    }
    public boolean move() {
        return move;
    }

    public void setMove() {
        move = true;
    }
    //Setting the legal moves of the piece.
    @Override
    public boolean legalMove(int y, int x, Point start, Object brikke, int team2) {
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
