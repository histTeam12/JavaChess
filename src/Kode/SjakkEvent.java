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
    private int _lag;
    
    public SjakkEvent( Object source, int lag ) {
        super( source );
        _lag = lag;
    }
    public int lag() {
        return _lag;
    }
    
}