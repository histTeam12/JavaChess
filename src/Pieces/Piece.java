package Pieces;


import java.awt.Point;
import java.io.Serializable;
import javax.swing.Icon;

/**
 * Super class for all the pieces 
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

    
    /**
     * Creates a new piece with the following icon
     * @param icon
     */
    public Piece(Icon icon) {
        this.icon = icon;
    }
    
    /**
     * Returns a String value of the name of this piece
     * @return
     * Name of the piece
     */
    public String getName(){
        return name;
    }
    
    /**
     * Changes the icon representing this piece
     * @param icon
     * the new icon
     */
    public void setIcon(Icon icon){
        this.icon = icon;
    }

    
    /**
     * Method for checking the legal moves of a piece which is taken in as parameter
     * @param y
     * distance moved on the y axis in pixels
     * @param x
     * distance moved on the x axis in pixels
     * @param start
     * the pieces starting point
     * @param piece
     * the piece being moved
     * @param team2
     * the team this piece belongs to
     * @return
     * true if legal move, else false
     */
    public abstract boolean legalMove(int y, int x, Point start, Object piece, int team2);
    
    /**
     * Grabs the icon representing this piece
     * @return
     * Icon for this piece
     */
    public abstract Icon getIcon();
    
    /**
     * Returns the int value indicating wich team the piece belongs to
     * @return
     * the value of this pieces team
     */
    public abstract int getTeam();
}
