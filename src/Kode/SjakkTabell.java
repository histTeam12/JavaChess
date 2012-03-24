/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Henrik
 */
public class SjakkTabell {
    private BrikkeLabel[] tabell;
    
    public SjakkTabell(){
        this.tabell = new BrikkeLabel[64];
    }
    public void oppdaterTabell(BrikkeLabel brikke, int indeks){
        tabell[indeks] = brikke;        
    }
    public Component hentFraTabell(int indeks){
        if(tabell[indeks] instanceof BrikkeLabel){            
               return tabell[indeks];
        }else{
            JPanel square = new JPanel(new BorderLayout());
            square.setOpaque(false);
            return square;
        }
    }
    
}
