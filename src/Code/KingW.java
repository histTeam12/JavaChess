package Code;

import java.awt.Point;
import javax.swing.Icon;

public class KingW extends Piece {
    private boolean move = false;

    public KingW(Icon icon) {
        super(icon);
        maxY = 75;
        maxX = 75;
        team = 1;
        name = "King";
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

    @Override
    public boolean legalMove(int y, int x, Point start, Object brikke, int team2) {
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
