package Kode;

import java.awt.Point;
import javax.swing.Icon;

public class LoperS extends Brikke {

    public LoperS(Icon ikon) {
        super(ikon);
        maksY = -75;
        maksX = 0;
        lag = 2;
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
        if (Math.abs((int)start.getX() - x) == (Math.abs((int)start.getY()-y))){
                return true;
        }
        return false;
    }
}
