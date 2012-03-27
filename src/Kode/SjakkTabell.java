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
    private String[] logg;
    
    public SjakkTabell(){
        this.tabell = new BrikkeLabel[64];
        this.logg = new String[2];
    }
    public void oppdaterTabell(BrikkeLabel brikke, int indeks){
        tabell[indeks] = brikke;        
    }
    public void oppdaterLogg(String logg2, int indeks){
        logg[indeks] = logg2;
    }
    public String getLogg(int indeks){
        return logg[indeks];
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
