package Kode;

import java.awt.Point;
import javax.swing.Icon;

public class PawnH extends Piece {
    private final int slope = -75;
    
    public PawnH(Icon ikon) {
        super(ikon);
        maxY = -75;
        maxX = 0;
        team = 1;
        name = "Pawn";
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public int getTeam() {
        return team;
    }
    

    @Override
    public boolean legalMove(int y, int x, Point start, Object brikke, int lag2) {
        if (lag2 == team) return false;
        if (start.getY() == 450) {if (y == (int) start.getY() + maxY * 2 && x == (int) start.getX()) {
                return true;
            }
        }
        if (!(brikke instanceof PieceLabel) && y == (int) start.getY() + maxY && x == (int) start.getX()) {
            return true;
        }
        if (brikke instanceof PieceLabel) {
            if (y == (int) start.getY() + maxY && x == (int) start.getX() + slope || y == (int) start.getY() + maxY && x == (int) start.getX() - slope ) {
                return true;
            }
        }
        return false;
    }
}
