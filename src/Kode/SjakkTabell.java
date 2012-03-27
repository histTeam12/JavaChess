/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Henrik
 */
public class SjakkTabell {

    private BrikkeLabel[] tabell;
    private String[] logg;

    public SjakkTabell() {
        this.tabell = new BrikkeLabel[64];
        this.logg = new String[2];
    }

    public void oppdaterTabell(BrikkeLabel brikke, int indeks) {
        tabell[indeks] = brikke;
    }

    public void oppdaterLogg(String logg2, int indeks) {
        logg[indeks] = logg2;
    }

    public String getLogg(int indeks) {
        return logg[indeks];
    }

    public Component hentFraTabell(int indeks) {
        if (tabell[indeks] instanceof BrikkeLabel) {
            return tabell[indeks];
        } else {
            JPanel square = new JPanel(new BorderLayout());
            square.setOpaque(false);
            return square;
        }
    }
    
    public void nullstill(){
        for(int i = 0; i<tabell.length; i++){
            tabell[i] = null;
        }
    }

    public void endreUI(int a) {
        switch (a) {
            case 1:
                for (int i = 0; i < 64; i++) {
                    if (tabell[i] instanceof BrikkeLabel) {
                        if (tabell[i].getBrikke() instanceof BondeH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/okayguyW.png"));
                        }
                        if (tabell[i].getBrikke() instanceof BondeS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/okayguyB.png"));
                        }
                        if (tabell[i].getBrikke() instanceof DronningH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/fmercuryW.png"));
                        }
                        if (tabell[i].getBrikke() instanceof DronningS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/FmercuryB.png"));
                        }
                        if (tabell[i].getBrikke() instanceof HestH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/trollfaceW.png"));
                        }
                        if (tabell[i].getBrikke() instanceof HestS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/trollfaceB.png"));
                        }
                        if (tabell[i].getBrikke() instanceof KongeH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/yaomingW.png"));
                        }
                        if (tabell[i].getBrikke() instanceof KongeS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/yaomingB.png"));
                        }
                        if (tabell[i].getBrikke() instanceof LoperH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/badassW.png"));
                        }
                        if (tabell[i].getBrikke() instanceof LoperS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/badassB.png"));
                        }
                        if (tabell[i].getBrikke() instanceof TarnH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/MegustaW.png"));
                        }
                        if (tabell[i].getBrikke() instanceof TarnS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/MegustaB.png"));
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 64; i++) {
                    if (tabell[i] instanceof BrikkeLabel) {
                        if (tabell[i].getBrikke() instanceof BondeH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/BondeH.png"));
                        }
                        if (tabell[i].getBrikke() instanceof BondeS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/BondeS.png"));
                        }
                        if (tabell[i].getBrikke() instanceof DronningH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/DronningH.png"));
                        }
                        if (tabell[i].getBrikke() instanceof DronningS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/DronningS.png"));
                        }
                        if (tabell[i].getBrikke() instanceof HestH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/HestH.png"));
                        }
                        if (tabell[i].getBrikke() instanceof HestS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/HestS.png"));
                        }
                        if (tabell[i].getBrikke() instanceof KongeH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/KongeH.png"));
                        }
                        if (tabell[i].getBrikke() instanceof KongeS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/KongeS.png"));
                        }
                        if (tabell[i].getBrikke() instanceof LoperH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/LoperH.png"));
                        }
                        if (tabell[i].getBrikke() instanceof LoperS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/LoperS.png"));
                        }
                        if (tabell[i].getBrikke() instanceof TarnH) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/TarnH.png"));
                        }
                        if (tabell[i].getBrikke() instanceof TarnS) {
                            tabell[i].setIcon(new ImageIcon("src/Kode/Bilder/TarnS.png"));
                        }
                    }
                }
                break;
        }
    }
}
