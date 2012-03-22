package Kode;

import java.awt.Point;
import javax.swing.Icon;

public class TarnS extends Brikke {
    private boolean flyttet = false;
    

    public TarnS(Icon ikon) {
        super(ikon);
        lag = 2;
        navn = "Tårn";
    }

    @Override
    public Icon getIcon() {
        return ikon;
    }

    @Override
    public int getLag() {
        return lag;
    }
    public boolean flyttet() {
        return flyttet;
    }

    public void setFlyttet() {
        flyttet = true;
    }

    @Override
    public boolean lovligMove(int y, int x, Point start, Object brikke, int lag2) {
        if (lag2 == lag) {
            return false;        
        }
        if (y != (int) start.getY() && x == (int) start.getX()){
            return true;
        }
        if (y == (int) start.getY() && x != (int) start.getX()){
            return true;
        }
        return false;
    }
}
