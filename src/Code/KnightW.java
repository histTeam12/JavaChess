package Code;

import java.awt.Point;
import javax.swing.Icon;

public class KnightW extends Piece {

    public KnightW(Icon icon) {
        super(icon);
        maxY = 75;
        maxX = 75;
        team = 1;
        name = "Knight";
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
    public boolean legalMove(int y, int x, Point start, Object brikke, int team2) {
        if (team2 == team) {
            return false;
        }
        if ((Math.abs(y-start.getY())== maxY*2 && Math.abs(x-start.getX())== maxX)||(Math.abs(x-start.getX())== maxX*2 && Math.abs(y-start.getY())== maxY)){
            return true;
        }
        return false;
    }
}
