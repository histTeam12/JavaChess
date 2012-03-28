package Code;

import java.awt.Point;
import javax.swing.Icon;

public class RookW extends Piece {
    private boolean move = false;

    public RookW(Icon icon) {
        super(icon);
        team = 1;
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
    public boolean move(){
        return move;
    }
    public void setMove(){
        move = true;
    }

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
