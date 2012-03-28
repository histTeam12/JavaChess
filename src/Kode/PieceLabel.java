package Kode;


import javax.swing.Icon;
import javax.swing.JLabel;

public class PieceLabel extends JLabel {

    Icon ikon;
    Piece brikke;
    

    public PieceLabel(Icon ikon, Piece brikke) {
        this.ikon = ikon;
        this.brikke = brikke;
    }

    public Piece getPiece() {
        return brikke;
    }

    @Override
    public Icon getIcon() {
        return ikon;
    }
    @Override
    public void setIcon(Icon ikon2){
        ikon = ikon2;
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }
    
    
}
