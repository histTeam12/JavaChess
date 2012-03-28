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
public class ChessTable {

    private PieceLabel[] table;
    private String[] log;

    public ChessTable() {
        this.table = new PieceLabel[64];
        this.log = new String[2];
    }

    public void updateTable(PieceLabel brikke, int indeks) {
        table[indeks] = brikke;
    }

    public void updateLog(String logg2, int indeks) {
        log[indeks] = logg2;
    }

    public String getLog(int index) {
        return log[index];
    }

    public Component getTable(int index) {
        if (table[index] instanceof PieceLabel) {
            return table[index];
        } else {
            JPanel square = new JPanel(new BorderLayout());
            square.setOpaque(false);
            return square;
        }
    }
    
    public void reset(){
        for(int i = 0; i<table.length; i++){
            table[i] = null;
        }
    }

    public void changeUI(int a) {
        switch (a) {
            case 1:
                for (int i = 0; i < 64; i++) {
                    if (table[i] instanceof PieceLabel) {
                        if (table[i].getPiece() instanceof PawnH) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/okayguyW.png"));
                        }
                        if (table[i].getPiece() instanceof PawnB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/okayguyB.png"));
                        }
                        if (table[i].getPiece() instanceof QueenW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/fmercuryW.png"));
                        }
                        if (table[i].getPiece() instanceof QueenB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/FmercuryB.png"));
                        }
                        if (table[i].getPiece() instanceof KnightW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/trollfaceW.png"));
                        }
                        if (table[i].getPiece() instanceof KnightB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/trollfaceB.png"));
                        }
                        if (table[i].getPiece() instanceof KingW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/yaomingW.png"));
                        }
                        if (table[i].getPiece() instanceof KingB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/yaomingB.png"));
                        }
                        if (table[i].getPiece() instanceof BishopW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/badassW.png"));
                        }
                        if (table[i].getPiece() instanceof BishopB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/badassB.png"));
                        }
                        if (table[i].getPiece() instanceof RookW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/MegustaW.png"));
                        }
                        if (table[i].getPiece() instanceof RookB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/MegustaB.png"));
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 64; i++) {
                    if (table[i] instanceof PieceLabel) {
                        if (table[i].getPiece() instanceof PawnH) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/BondeH.png"));
                        }
                        if (table[i].getPiece() instanceof PawnB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/BondeS.png"));
                        }
                        if (table[i].getPiece() instanceof QueenW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/DronningH.png"));
                        }
                        if (table[i].getPiece() instanceof QueenB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/DronningS.png"));
                        }
                        if (table[i].getPiece() instanceof KnightW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/HestH.png"));
                        }
                        if (table[i].getPiece() instanceof KnightB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/HestS.png"));
                        }
                        if (table[i].getPiece() instanceof KingW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/KongeH.png"));
                        }
                        if (table[i].getPiece() instanceof KingB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/KongeS.png"));
                        }
                        if (table[i].getPiece() instanceof BishopW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/LoperH.png"));
                        }
                        if (table[i].getPiece() instanceof BishopB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/LoperS.png"));
                        }
                        if (table[i].getPiece() instanceof RookW) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/TarnH.png"));
                        }
                        if (table[i].getPiece() instanceof RookB) {
                            table[i].setIcon(new ImageIcon("src/Kode/Bilder/TarnS.png"));
                        }
                    }
                }
                break;
        }
    }
}
