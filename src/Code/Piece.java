package Code;


import java.awt.Point;
import javax.swing.Icon;

abstract class Piece {

    Icon icon;
    int maxX;
    int maxY;
    int team;
    String name;

    public Piece(Icon icon) {
        this.icon = icon;
    }
    public String getName(){
        return name;
    }
    
    public void setIcon(Icon icon){
        this.icon = icon;
    }

    abstract boolean legalMove(int y, int x, Point start, Object piece, int team2);
    
    abstract Icon getIcon();
    
    abstract int getTeam();
}
