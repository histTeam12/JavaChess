package Kode;

import java.awt.Point;
import javax.swing.Icon;

public class HestS extends Brikke {

    public HestS(Icon ikon) {
        super(ikon);
        maksY = 75;
        maksX = 75;
        lag = 2;
        navn = "Hest";
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
        if (lag2 == lag) {
            return false;
        }
        if ((Math.abs(y-start.getY())== maksY*2 && Math.abs(x-start.getX())== maksX)||(Math.abs(x-start.getX())== maksX*2 && Math.abs(y-start.getY())== maksY)){
            return true;
        }
        return false;
    }
}
