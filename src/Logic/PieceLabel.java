package Logic;


import Pieces.Piece;
import javax.swing.Icon;
import javax.swing.JLabel;

public class PieceLabel extends JLabel {

    Icon icon;
    Piece piece;
    

    public PieceLabel(Icon icon, Piece piece) {
        this.icon = icon;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }
    @Override
    public void setIcon(Icon icon2){
        icon = icon2;
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }
    
    
}
