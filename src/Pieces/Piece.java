package Pieces;


import java.awt.Point;
import java.io.Serializable;
import javax.swing.Icon;

//Super class for all the pieces 
/**
 * 
 * @author andreaskalstad
 */
abstract public class Piece implements Serializable {

    /**
     * 
     */
    public Icon icon;
    /**
     * 
     */
    public int maxX;
    /**
     * 
     */
    public int maxY;
    /**
     * 
     */
    public int team;
    /**
     * 
     */
    public String name;

    //Constructor
    /**
     * 
     * @param icon
     */
    public Piece(Icon icon) {
        this.icon = icon;
    }
    
    /**
     * 
     * @return
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @param icon
     */
    public void setIcon(Icon icon){
        this.icon = icon;
    }

    //Method for checking the legal moves of a piece which is taken in as parameter
    /**
     * 
     * @param y
     * @param x
     * @param start
     * @param piece
     * @param team2
     * @return
     */
    public abstract boolean legalMove(int y, int x, Point start, Object piece, int team2);
    
    /**
     * 
     * @return
     */
    public abstract Icon getIcon();
    
    /**
     * 
     * @return
     */
    public abstract int getTeam();
}
