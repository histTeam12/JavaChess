package Logic;


import Pieces.Piece;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Extends the JLabel class and makes it possible to make chess pieces
 * @author andreaskalstad
 */
public class PieceLabel extends JLabel {

    Icon icon;
    Piece piece;
    

    /**
     * Constructs a chess piece 
     * @param icon
     * Icon object - the icon of the piece label
     * @param piece
     * Piece object - which piece the label should be
     */
    public PieceLabel(Icon icon, Piece piece) {
        this.icon = icon;
        this.piece = piece;
    }

    /**
     * Returns a piece object
     * @return
     * A piece object
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Returns the icon that the piece label displays
     * @return
     * an Icon
     */
    @Override
    public Icon getIcon() {
        return icon;
    }
    /**
     * Sets an icon to the piece label
     * @param icon2
     * Icon object
     */
    @Override
    public void setIcon(Icon icon2){
        icon = icon2;
    }

    /**
     * Sets if the piece label should be visible or not
     * @param aFlag
     * Boolean
     */
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }
}
