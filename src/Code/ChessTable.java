/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

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
                        if (table[i].getPiece() instanceof PawnW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/OkayguyW.png"));
                        }
                        if (table[i].getPiece() instanceof PawnB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/OkayguyB.png"));
                        }
                        if (table[i].getPiece() instanceof QueenW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/FmercuryW.png"));
                        }
                        if (table[i].getPiece() instanceof QueenB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/FmercuryB.png"));
                        }
                        if (table[i].getPiece() instanceof KnightW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/TrollfaceW.png"));
                        }
                        if (table[i].getPiece() instanceof KnightB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/TrollfaceB.png"));
                        }
                        if (table[i].getPiece() instanceof KingW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/YaomingW.png"));
                        }
                        if (table[i].getPiece() instanceof KingB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/YaomingB.png"));
                        }
                        if (table[i].getPiece() instanceof BishopW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/BadassW.png"));
                        }
                        if (table[i].getPiece() instanceof BishopB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/BadassB.png"));
                        }
                        if (table[i].getPiece() instanceof RookW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/MegustaW.png"));
                        }
                        if (table[i].getPiece() instanceof RookB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/MegustaB.png"));
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 64; i++) {
                    if (table[i] instanceof PieceLabel) {
                        if (table[i].getPiece() instanceof PawnW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/PawnW.png"));
                        }
                        if (table[i].getPiece() instanceof PawnB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/PawnB.png"));
                        }
                        if (table[i].getPiece() instanceof QueenW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/QueenW.png"));
                        }
                        if (table[i].getPiece() instanceof QueenB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/QueenB.png"));
                        }
                        if (table[i].getPiece() instanceof KnightW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/KnightW.png"));
                        }
                        if (table[i].getPiece() instanceof KnightB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/KnightB.png"));
                        }
                        if (table[i].getPiece() instanceof KingW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/KingW.png"));
                        }
                        if (table[i].getPiece() instanceof KingB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/KingB.png"));
                        }
                        if (table[i].getPiece() instanceof BishopW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/BishopW.png"));
                        }
                        if (table[i].getPiece() instanceof BishopB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/BishopB.png"));
                        }
                        if (table[i].getPiece() instanceof RookW) {
                            table[i].setIcon(new ImageIcon("src/Pictures/RookW.png"));
                        }
                        if (table[i].getPiece() instanceof RookB) {
                            table[i].setIcon(new ImageIcon("src/Pictures/RookB.png"));
                        }
                    }
                }
                break;
        }
    }
}