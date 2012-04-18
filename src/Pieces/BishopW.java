package Pieces;

import java.awt.Point;
import javax.swing.Icon;

public class BishopW extends Piece {

    public BishopW(Icon icon) {
        super(icon);
        team = 1;
        name = "Bishop";
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public int getTeam() {
        return team;
    }
    //Setting the legal moves of the piece.
    @Override
    public boolean legalMove(int y, int x, Point start, Object piece, int team2) {
        if (team2 == team) return false;
        if ((Math.abs((int)start.getX() - x) == (Math.abs((int)start.getY()-y))) && (Math.abs((int)start.getY()-y) >= 75)){
                return true;
        }
        return false;
    }
}
