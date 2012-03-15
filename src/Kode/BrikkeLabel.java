package Kode;


import javax.swing.Icon;
import javax.swing.JLabel;

public class BrikkeLabel extends JLabel {

    Icon ikon;
    Brikke brikke;
    

    public BrikkeLabel(Icon ikon, Brikke brikke) {
        this.ikon = ikon;
        this.brikke = brikke;
    }

    public Brikke getBrikke() {
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
