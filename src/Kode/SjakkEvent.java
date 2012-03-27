/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;

/**
 *
 * @author Henrik
 */
import java.util.EventObject;

public class SjakkEvent extends EventObject {

    private int lag;
    private Brikke brikke;

    public SjakkEvent(Object source, int lag, Brikke brikke) {
        super(source);
        this.lag = lag;
        this.brikke = brikke;
    }
    public SjakkEvent(Object source, int lag) {
        super(source);
        this.lag = lag;
    }

    public int lag() {
        return lag;
    }

    public int brikke() {
        if (brikke instanceof HestH || brikke instanceof HestS) {
            return 1;
        }
        if (brikke instanceof LoperH || brikke instanceof LoperS) {
            return 2;
        }
        if (brikke instanceof TarnH || brikke instanceof TarnS) {
            return 3;
        }
        if (brikke instanceof DronningH || brikke instanceof DronningS) {
            return 4;
        }
        if (brikke instanceof KongeH || brikke instanceof KongeS) {
            return 5;
        }
        if (brikke instanceof BondeH || brikke instanceof BondeS) {
            return 0;
        }
        return -1;
    }
}