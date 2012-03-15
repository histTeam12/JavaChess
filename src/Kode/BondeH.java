package Kode;

import java.awt.Point;
import javax.swing.Icon;

public class BondeH extends Brikke {
    private final int skrå = -75;
    
    public BondeH(Icon ikon) {
        super(ikon);
        maksY = -75;
        maksX = 0;
        lag = 1;
    }

    @Override
    public Icon getIcon() {
        return ikon;
    }

    @Override
    public int getLag() {
        return lag;
    }
    

    @Override
    public boolean lovligMove(int y, int x, Point start, Object brikke, int lag2) {
        if (lag2 == lag) return false;
        if (start.getY() == 450) {if (y == (int) start.getY() + maksY * 2 && x == (int) start.getX()) {
                return true;
            }
        }
        if (!(brikke instanceof BrikkeLabel) && y == (int) start.getY() + maksY && x == (int) start.getX()) {
            return true;
        }
        if (brikke instanceof BrikkeLabel) {
            if (y == (int) start.getY() + maksY && x == (int) start.getX() + skrå || y == (int) start.getY() + maksY && x == (int) start.getX() - skrå ) {
                return true;
            }
        }
        return false;
    }
}
