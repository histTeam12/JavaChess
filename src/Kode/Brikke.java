package Kode;


import java.awt.Point;
import javax.swing.Icon;

abstract class Brikke {

    Icon ikon;
    int maksX;
    int maksY;
    int lag;
    String navn;

    public Brikke(Icon ikon) {
        this.ikon = ikon;
    }
    public String getNavn(){
        return navn;
    }
    
    public void setIcon(Icon ikon){
        this.ikon = ikon;
    }

    abstract boolean lovligMove(int y, int x, Point start, Object brikke, int lag2);
    
    abstract Icon getIcon();
    
    abstract int getLag();
}
