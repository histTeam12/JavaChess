package Pieces;


import java.awt.Point;
import java.io.Serializable;
import javax.swing.Icon;

abstract public class Piece implements Serializable {

    public Icon icon;
    public int maxX;
    public int maxY;
    public int team;
    public String name;

    public Piece(Icon icon) {
        this.icon = icon;
    }
    public String getName(){
        return name;
    }
    
    public void setIcon(Icon icon){
        this.icon = icon;
    }

    public abstract boolean legalMove(int y, int x, Point start, Object piece, int team2);
    
    public abstract Icon getIcon();
    
    public abstract int getTeam();
}
