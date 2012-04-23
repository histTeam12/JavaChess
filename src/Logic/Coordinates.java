package Logic;

import java.awt.Point;

/**
 * Calculates and organizes the points on the board
 * @author andreaskalstad
 */
public class Coordinates {

    private Point[] coords = {new Point(0, 0), new Point(75, 0), new Point(150, 0), new Point(225, 0), new Point(300, 0), new Point(375, 0), new Point(450, 0), new Point(525, 0),
        new Point(0, 75), new Point(75, 75), new Point(150, 75), new Point(225, 75), new Point(300, 75), new Point(375, 75), new Point(450, 75), new Point(525, 75),
        new Point(0, 150), new Point(75, 150), new Point(150, 150), new Point(225, 150), new Point(300, 150), new Point(375, 150), new Point(450, 150), new Point(525, 150),
        new Point(0, 225), new Point(75, 225), new Point(150, 225), new Point(225, 225), new Point(300, 225), new Point(375, 225), new Point(450, 225), new Point(525, 225),
        new Point(0, 300), new Point(75, 300), new Point(150, 300), new Point(225, 300), new Point(300, 300), new Point(375, 300), new Point(450, 300), new Point(525, 300),
        new Point(0, 375), new Point(75, 375), new Point(150, 375), new Point(225, 375), new Point(300, 375), new Point(375, 375), new Point(450, 375), new Point(525, 375),
        new Point(0, 450), new Point(75, 450), new Point(150, 450), new Point(225, 450), new Point(300, 450), new Point(375, 450), new Point(450, 450), new Point(525, 450),
        new Point(0, 525), new Point(75, 525), new Point(150, 525), new Point(225, 525), new Point(300, 525), new Point(375, 525), new Point(450, 525), new Point(525, 525)};

    private String[] letters = {"A8", "B8", "C8", "D8", "E8","F8","G8","H8",
        "A7", "B7", "C7", "D7", "E7","F7","G7","H7",
        "A6", "B6", "C6", "D6", "E6","F6","G6","H6",
        "A5", "B5", "C5", "D5", "E5","F5","G5","H5",
        "A4", "B4", "C4", "D4", "E4","F4","G4","H4",
        "A3", "B3", "C3", "D3", "E3","F3","G3","H3",
        "A2", "B2", "C2", "D2", "E2","F2","G2","H2",
        "A1", "B1", "C1", "D1", "E1","F1","G1","H1"};

    /**
     * Returns a string with rank and file
     * @param x
     * X-coordinate
     * @param y
     * Y-coordinate
     * @return 
     * Rank and file, or null
     */
    public String getCoord(int x, int y) {
        Point punkt = new Point(x, y);
        for (int i = 0; i < 64; i++) {
            if (punkt.equals(coords[i])) {
                return letters[i];
            }
        }
        return null;
    }
    /**
     * Returns a string with rank and file
     * @param point
     * Point object
     * @return
     * Rank and file, or null
     */
    public String getCoord(Point point) {
        for (int i = 0; i < 64; i++) {
            if (point.equals(coords[i])) {
                return letters[i];
            }
        }
        return null;
    }
    
    /**
     * Returns the point object in given index
     * @param a
     * An index in the table
     * @return
     * Returns a point object
     */
    public Point getPoint(int a){
        return coords[a];
    }
    
    /**
     * Returns the index of the table where the given point object is found
     * @param point
     * A point object
     * @return
     * Returns an index
     */
    public int getIndex(Point point){
        for(int i=0;i<64;i++){
            if (coords[i].equals(point)){
                return i;
            }
        }
        return -1;
    }
}
