package Kode;

import java.awt.Point;
import javax.swing.Icon;

public class KongeH extends Brikke {

    private boolean flyttet = false;

    public KongeH(Icon ikon) {
        super(ikon);
        maksY = 75;
        maksX = 75;
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
        if (Math.abs(y - start.getY()) <= maksY && Math.abs(x - start.getX()) <= maksX) {
            return true;
        }
        return false;
    }
}
