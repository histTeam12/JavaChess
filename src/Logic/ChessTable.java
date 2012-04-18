package Logic;

import Pieces.QueenW;
import Pieces.RookB;
import Pieces.RookW;
import Pieces.QueenB;
import Pieces.Piece;
import Pieces.PawnW;
import Pieces.PawnB;
import Pieces.KingW;
import Pieces.KnightW;
import Pieces.KnightB;
import Pieces.KingB;
import Pieces.BishopB;
import Pieces.BishopW;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChessTable {

    private PieceLabel[] table;
    private String[] log;
    private PieceLabel[][] twoTable;

    public ChessTable() {
        this.table = new PieceLabel[64];
        this.log = new String[2];
        this.twoTable = new PieceLabel[8][8];
    }

    public ChessTable(Component[] table2) {
        this.table = new PieceLabel[64];
        for (int i = 0; i < 64; i++) {
            if (table2[i] instanceof PieceLabel) {
                table[i] = (PieceLabel) table2[i];
            }
        }
        this.log = new String[2];
        this.twoTable = new PieceLabel[8][8];
    }

    public void updateTable(PieceLabel piece, int indeks) {
        table[indeks] = piece;
    }

    public void newTable(PieceLabel[] table2) {
        table = table2;
//        reset();
//        for(int i = 0; i<64;i++){
//            if(table2[i] instanceof PieceLabel){
//                table[i] = (PieceLabel) table2[i];
//            }
//        }
        updateTwoTable();
    }

    public PieceLabel[] getTable() {
        return table;
    }

    public PieceLabel getPiece(int index) {
        return table[index];
    }

    public void testTwoTable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (twoTable[i][j] instanceof PieceLabel) {
                    System.out.println("i: " + i + " j: " + j + " " + twoTable[i][j].getPiece());
                }
            }
        }
    }

    public void updateTwoTable() {
        int a = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                twoTable[i][j] = table[a];
                a++;

            }
        }
    }

    public void updateLog(String log2, int indeks) {
        log[indeks] = log2;
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

    public void reset() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        log[0] = "";
        log[1] = "";
    }

    public void changeUI(int a) {
        switch (a) {
            case 1:
                for (int i = 0; i < 64; i++) {
                    if (table[i] instanceof PieceLabel) {
                        if (table[i].getPiece() instanceof PawnW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/OkayguyW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/OkayguyW.png")));
                        }
                        if (table[i].getPiece() instanceof PawnB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/OkayguyB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/OkayguyB.png")));
                        }
                        if (table[i].getPiece() instanceof QueenW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/FmercuryW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/FmercuryW.png")));
                        }
                        if (table[i].getPiece() instanceof QueenB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/FmercuryB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/FmercuryB.png")));
                        }
                        if (table[i].getPiece() instanceof KnightW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/TrollfaceW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/TrollfaceW.png")));
                        }
                        if (table[i].getPiece() instanceof KnightB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/TrollfaceB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/TrollfaceB.png")));
                        }
                        if (table[i].getPiece() instanceof KingW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/YaomingW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/YaomingW.png")));
                        }
                        if (table[i].getPiece() instanceof KingB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/YaomingB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/YaomingB.png")));
                        }
                        if (table[i].getPiece() instanceof BishopW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/LolW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/LolW.png")));
                        }
                        if (table[i].getPiece() instanceof BishopB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/LolB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/LolB.png")));
                        }
                        if (table[i].getPiece() instanceof RookW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/MegustaW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/MegustaW.png")));
                        }
                        if (table[i].getPiece() instanceof RookB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/MegustaB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/MegustaB.png")));
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 64; i++) {
                    if (table[i] instanceof PieceLabel) {
                        if (table[i].getPiece() instanceof PawnW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/PawnW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/PawnW.png")));
                        }
                        if (table[i].getPiece() instanceof PawnB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/PawnB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/PawnB.png")));
                        }
                        if (table[i].getPiece() instanceof QueenW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/QueenW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/QueenW.png")));
                        }
                        if (table[i].getPiece() instanceof QueenB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/QueenB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/QueenB.png")));
                        }
                        if (table[i].getPiece() instanceof KnightW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KnightW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KnightW.png")));
                        }
                        if (table[i].getPiece() instanceof KnightB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KnightB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KnightB.png")));
                        }
                        if (table[i].getPiece() instanceof KingW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KingW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KingW.png")));
                        }
                        if (table[i].getPiece() instanceof KingB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KingB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/KingB.png")));
                        }
                        if (table[i].getPiece() instanceof BishopW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/BishopW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/BishopW.png")));
                        }
                        if (table[i].getPiece() instanceof BishopB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/BishopB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/BishopB.png")));
                        }
                        if (table[i].getPiece() instanceof RookW) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/RookW.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/RookW.png")));
                        }
                        if (table[i].getPiece() instanceof RookB) {
                            table[i].setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/RookB.png")));
                            table[i].getPiece().setIcon(new ImageIcon(getClass().getResource("/Pieces/Pictures/RookB.png")));
                        }
                    }
                }
                break;
        }
    }

    public int kingWpos() {
        for (int i = 0; i < table.length; i++) {
            if (table[i].getPiece() instanceof KingW) {
                return i;
            }
        }
        return -1;
    }

    public int kingBpos() {
        for (int i = 0; i < table.length; i++) {
            if (table[i].getPiece() instanceof KingB) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkW(int i) {
        if (checkBishopW(i)) {
            return true;
        }
        if (checkRookW(i)) {
            return true;
        }
        if (checkKnightW(i)) {
            return true;
        }
        if (checkPawnW(i)) {
            return true;
        }
        if (checkKingW(i)) {
            return true;
        }
        return false;
    }

    public boolean checkB(int i) {
        if (checkBishopB(i)) {
            return true;
        }
        if (checkRookB(i)) {
            return true;
        }
        if (checkKnightB(i)) {
            return true;
        }
        if (checkPawnB(i)) {
            return true;
        }
        if (checkKingB(i)) {
            return true;
        }
        return false;
    }

    public boolean checkKnightW(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        if ((a + 1 <= 7 && a + 1 >= 0) && (b - 2 <= 7 && b - 2 >= 0)) {
            if (twoTable[a + 1][b - 2] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 2].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        if ((a + 1 <= 7 && a + 1 >= 0) && (b + 2 <= 7 && b + 2 >= 0)) {
            if (twoTable[a + 1][b + 2] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 2].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        if ((a + 2 <= 7 && a + 2 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a + 2][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 2][b - 1].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 2][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b + 1].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a - 2][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b - 1].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 2][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b + 1].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        if ((a - 1 <= 7 && a - 1 >= 0) && (b - 2 <= 7 && b - 2 >= 0)) {
            if (twoTable[a - 1][b - 2] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 2].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        if ((a - 1 <= 7 && a - 1 >= 0) && (b + 2 <= 7 && b + 2 >= 0)) {
            if (twoTable[a - 1][b + 2] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 2].getPiece() instanceof KnightB) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPawnW(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        if (a + 1 < 8 && b - 1 < 8 && a + 1 >= 0 && b - 1 >= 0) {
            if (twoTable[a - 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 1].getPiece() instanceof PawnB) {
                    return true;
                }
            }
        }
        if (a + 1 < 8 && b + 1 < 8 && a + 1 >= 0 && b + 1 >= 0) {
            if (twoTable[a - 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 1].getPiece() instanceof PawnB) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRookW(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        for (int j = b; j < 8; j++) {
            if (twoTable[a][j] instanceof PieceLabel) {
                if (twoTable[a][j].getPiece() instanceof RookB || twoTable[a][j].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[a][j].getPiece() instanceof RookB) == false && (twoTable[a][j].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
        }
        for (int j = b; j >= 0; j--) {
            if (twoTable[a][j] instanceof PieceLabel) {
                if (twoTable[a][j].getPiece() instanceof RookB || twoTable[a][j].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[a][j].getPiece() instanceof RookB) == false && (twoTable[a][j].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
        }
        for (int j = a; j < 8; j++) {
            if (twoTable[j][b] instanceof PieceLabel) {
                if (twoTable[j][b].getPiece() instanceof RookB || twoTable[j][b].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[j][b].getPiece() instanceof RookB) == false && (twoTable[j][b].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
        }
        for (int j = a; j >= 0; j--) {
            if (twoTable[j][b] instanceof PieceLabel) {
                if (twoTable[j][b].getPiece() instanceof RookB || twoTable[j][b].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[j][b].getPiece() instanceof RookB) == false && (twoTable[j][b].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
        }
        return false;
    }

    public boolean checkBishopW(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        int c = a;
        int d = b;
        for (int j = 0; j < 8; j++) {

            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopB || twoTable[c][d].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopB) == false && (twoTable[c][d].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
            if (c > 0 && d > 0) {
                c--;
                d--;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopB || twoTable[c][d].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopB) == false && (twoTable[c][d].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
            if (c < 7 && d < 7) {
                c++;
                d++;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopB || twoTable[c][d].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopB) == false && (twoTable[c][d].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
            if (c < 7 && d > 0) {
                c++;
                d--;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopB || twoTable[c][d].getPiece() instanceof QueenB) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopB) == false && (twoTable[c][d].getPiece() instanceof KingW) == false) {
                    break;
                }
            }
            if (c > 0 && d < 7) {
                c--;
                d++;
            }
        }
        return false;
    }

    public boolean checkKingW(int i) {
        //
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        //top left
        if ((a - 1 <= 7 && a - 1 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a - 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 1].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        //top right
        if ((a - 1 <= 7 && a - 1 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 1].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        //top
        if ((a - 1 <= 7 && a - 1 >= 0) && (b <= 7 && b >= 0)) {
            if (twoTable[a - 1][b] instanceof PieceLabel) {
                if (twoTable[a - 1][b].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        //left
        if ((a <= 7 && a >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a][b - 1] instanceof PieceLabel) {
                if (twoTable[a][b - 1].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        //right
        if ((a <= 7 && a >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a][b + 1] instanceof PieceLabel) {
                if (twoTable[a][b + 1].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        //bot left
        if ((a + 1 <= 7 && a + 1 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a + 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 1].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        //bot
        if ((a + 1 <= 7 && a + 1 >= 0) && (b <= 7 && b >= 0)) {
            if (twoTable[a + 1][b] instanceof PieceLabel) {
                if (twoTable[a + 1][b].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        //bot right
        if ((a + 1 <= 7 && a + 1 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a + 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 1].getPiece() instanceof KingB) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean checkKnightB(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        if ((a + 1 <= 7 && a + 1 >= 0) && (b - 2 <= 7 && b - 2 >= 0)) {
            if (twoTable[a + 1][b - 2] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 2].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        if ((a + 1 <= 7 && a + 1 >= 0) && (b + 2 <= 7 && b + 2 >= 0)) {
            if (twoTable[a + 1][b + 2] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 2].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        if ((a + 2 <= 7 && a + 2 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a + 2][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 2][b - 1].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 2][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b + 1].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a - 2][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b - 1].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 2][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b + 1].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        if ((a - 1 <= 7 && a - 1 >= 0) && (b - 2 <= 7 && b - 2 >= 0)) {
            if (twoTable[a - 1][b - 2] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 2].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        if ((a - 1 <= 7 && a - 1 >= 0) && (b + 2 <= 7 && b + 2 >= 0)) {
            if (twoTable[a - 1][b + 2] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 2].getPiece() instanceof KnightW) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPawnB(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        if (a + 1 < 8 && b - 1 < 8 && a + 1 >= 0 && b - 1 >= 0) {
            if (twoTable[a + 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 1].getPiece() instanceof PawnW) {
                    return true;
                }
            }
        }
        if (a + 1 < 8 && b + 1 < 8 && a + 1 >= 0 && b + 1 >= 0) {
            if (twoTable[a + 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 1].getPiece() instanceof PawnW) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRookB(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        for (int j = b; j < 8; j++) {
            if (twoTable[a][j] instanceof PieceLabel) {
                if (twoTable[a][j].getPiece() instanceof RookW || twoTable[a][j].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[a][j].getPiece() instanceof RookW) == false && (twoTable[a][j].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
        }
        for (int j = b; j >= 0; j--) {
            if (twoTable[a][j] instanceof PieceLabel) {
                if (twoTable[a][j].getPiece() instanceof RookW || twoTable[a][j].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[a][j].getPiece() instanceof RookW) == false && (twoTable[a][j].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
        }
        for (int j = a; j < 8; j++) {
            if (twoTable[j][b] instanceof PieceLabel) {
                if (twoTable[j][b].getPiece() instanceof RookW || twoTable[j][b].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[j][b].getPiece() instanceof RookW) == false && (twoTable[j][b].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
        }
        for (int j = a; j >= 0; j--) {
            if (twoTable[j][b] instanceof PieceLabel) {
                if (twoTable[j][b].getPiece() instanceof RookW || twoTable[j][b].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[j][b].getPiece() instanceof RookW) == false && (twoTable[j][b].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
        }
        return false;
    }

    public boolean checkBishopB(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        int c = a;
        int d = b;
        for (int j = 0; j < 8; j++) {
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopW || twoTable[c][d].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopW) == false && (twoTable[c][d].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
            if (c > 0 && d > 0) {
                c--;
                d--;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopW || twoTable[c][d].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopW) == false && (twoTable[c][d].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
            if (c < 7 && d < 7) {
                c++;
                d++;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopW || twoTable[c][d].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopW) == false && (twoTable[c][d].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
            if (c < 7 && d > 0) {
                c++;
                d--;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece() instanceof BishopW || twoTable[c][d].getPiece() instanceof QueenW) {
                    return true;
                }
                if ((twoTable[c][d].getPiece() instanceof BishopW) == false && (twoTable[c][d].getPiece() instanceof KingB) == false) {
                    break;
                }
            }
            if (c > 0 && d < 7) {
                c--;
                d++;
            }
        }
        return false;
    }

    public boolean checkKingB(int i) {
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        //top left
        if ((a - 1 <= 7 && a - 1 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a - 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 1].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        //top right
        if ((a - 1 <= 7 && a - 1 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 1].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        //top
        if ((a - 1 <= 7 && a - 1 >= 0) && (b <= 7 && b >= 0)) {
            if (twoTable[a - 1][b] instanceof PieceLabel) {
                if (twoTable[a - 1][b].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        //left
        if ((a <= 7 && a >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a][b - 1] instanceof PieceLabel) {
                if (twoTable[a][b - 1].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        //right
        if ((a <= 7 && a >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a][b + 1] instanceof PieceLabel) {
                if (twoTable[a][b + 1].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        //bot left
        if ((a + 1 <= 7 && a + 1 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a + 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 1].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        //bot
        if ((a + 1 <= 7 && a + 1 >= 0) && (b <= 7 && b >= 0)) {
            if (twoTable[a + 1][b] instanceof PieceLabel) {
                if (twoTable[a + 1][b].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        //bot right
        if ((a + 1 <= 7 && a + 1 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a + 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 1].getPiece() instanceof KingW) {
                    return true;
                }
            }
        }
        return false;

    }

    public int[] colorMoves(int i, Piece p) {
        int[] list = new int[0];
        if (p instanceof KnightW || p instanceof KnightB) {
            list = colorKnight(i, p);
        }
        if (p instanceof BishopW || p instanceof BishopB) {
            list = colorBishop(i, p);
        }
        if (p instanceof KingW || p instanceof KingB) {
            list = colorKing(i, p);
        }
        if (p instanceof PawnW || p instanceof PawnB) {
            list = colorPawn(i, p);
        }
        if (p instanceof RookW || p instanceof RookB) {
            list = colorRook(i, p);
        }
        if (p instanceof QueenW || p instanceof QueenB) {
            list = colorQueen(i, p);
        }
        return list;
    }

    public int[] colorSpecialMoves(int i, Piece p, boolean castlingL, boolean castlingR, boolean castlingK, boolean passant, int j) {
        int[] list = new int[0];
        if (p instanceof KingW || p instanceof KingB) {
            list = colorCastling(i, castlingL, castlingR, castlingK);
        }
        if (p instanceof PawnW || p instanceof PawnB) {
            list = colorPassant(i, passant, j, p);
        }
        return list;
    }

    public int[] colorBishop(int i, Piece p) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        int c = a;
        int d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c > 0 && d > 0) {
                c--;
                d--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c < 7 && d < 7) {
                c++;
                d++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c > 0 && d < 7) {
                c--;
                d++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c < 7 && d > 0) {
                c++;
                d--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;
    }

    public int[] colorKnight(int i, Piece p) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        if ((a + 1 <= 7 && a + 1 >= 0) && (b - 2 <= 7 && b - 2 >= 0)) {
            if (twoTable[a + 1][b - 2] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 2].getPiece().getTeam() != p.getTeam()) {
                    array.add((a + 1) * 8 + (b - 2));
                }
            }
            if (!(twoTable[a + 1][b - 2] instanceof PieceLabel)) {
                array.add((a + 1) * 8 + (b - 2));
            }
        }
        if ((a + 1 <= 7 && a + 1 >= 0) && (b + 2 <= 7 && b + 2 >= 0)) {
            if (twoTable[a + 1][b + 2] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 2].getPiece().getTeam() != p.getTeam()) {
                    array.add((a + 1) * 8 + (b + 2));
                }
            }
            if (!(twoTable[a + 1][b + 2] instanceof PieceLabel)) {
                array.add((a + 1) * 8 + (b + 2));
            }
        }
        if ((a + 2 <= 7 && a + 2 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a + 2][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 2][b - 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a + 2) * 8 + (b - 1));
                }
            }
            if (!(twoTable[a + 2][b - 1] instanceof PieceLabel)) {
                array.add((a + 2) * 8 + (b - 1));
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 2][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b + 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 2) * 8 + (b + 1));
                }
            }
            if (!(twoTable[a - 2][b + 1] instanceof PieceLabel)) {
                array.add((a - 2) * 8 + (b + 1));
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a - 2][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b - 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 2) * 8 + (b - 1));
                }
            }
            if (!(twoTable[a - 2][b - 1] instanceof PieceLabel)) {
                array.add((a - 2) * 8 + (b - 1));
            }
        }
        if ((a - 2 <= 7 && a - 2 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 2][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 2][b + 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 2) * 8 + (b + 1));
                }
            }
            if (!(twoTable[a - 2][b + 1] instanceof PieceLabel)) {
                array.add((a - 2) * 8 + (b + 1));
            }
        }
        if ((a - 1 <= 7 && a - 1 >= 0) && (b - 2 <= 7 && b - 2 >= 0)) {
            if (twoTable[a - 1][b - 2] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 2].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 1) * 8 + (b - 2));
                }
            }
            if (!(twoTable[a - 1][b - 2] instanceof PieceLabel)) {
                array.add((a - 1) * 8 + (b - 2));
            }
        }
        if ((a - 1 <= 7 && a - 1 >= 0) && (b + 2 <= 7 && b + 2 >= 0)) {
            if (twoTable[a - 1][b + 2] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 2].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 1) * 8 + (b + 2));
                }
            }
            if (!(twoTable[a - 1][b + 2] instanceof PieceLabel)) {
                array.add((a - 1) * 8 + (b + 2));
            }
        }
        if ((a + 2 <= 7 && a + 2 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a + 2][b + 1] instanceof PieceLabel) {
                if (twoTable[a + 2][b + 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a + 2) * 8 + (b + 1));
                }
            }
            if (!(twoTable[a + 2][b + 1] instanceof PieceLabel)) {
                array.add((a + 2) * 8 + (b + 1));
            }
        }

        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;
    }

    public int[] colorKing(int i, Piece p) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        //top left
        if ((a - 1 <= 7 && a - 1 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a - 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 1) * 8 + (b - 1));
                }
            }
            if (!(twoTable[a - 1][b - 1] instanceof PieceLabel)) {
                array.add((a - 1) * 8 + (b - 1));
            }
        }
        //top right
        if ((a - 1 <= 7 && a - 1 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a - 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 1) * 8 + (b + 1));
                }
            }
            if (!(twoTable[a - 1][b + 1] instanceof PieceLabel)) {
                array.add((a - 1) * 8 + (b + 1));
            }
        }
        //top
        if ((a - 1 <= 7 && a - 1 >= 0) && (b <= 7 && b >= 0)) {
            if (twoTable[a - 1][b] instanceof PieceLabel) {
                if (twoTable[a - 1][b].getPiece().getTeam() != p.getTeam()) {
                    array.add((a - 1) * 8 + (b));
                }
            }
            if (!(twoTable[a - 1][b] instanceof PieceLabel)) {
                array.add((a - 1) * 8 + (b));
            }
        }
        //left
        if ((a <= 7 && a >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a][b - 1] instanceof PieceLabel) {
                if (twoTable[a][b - 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a) * 8 + (b - 1));
                }
            }
            if (!(twoTable[a][b - 1] instanceof PieceLabel)) {
                array.add((a) * 8 + (b - 1));
            }
        }
        //right
        if ((a <= 7 && a >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a][b + 1] instanceof PieceLabel) {
                if (twoTable[a][b + 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a) * 8 + (b + 1));
                }
            }
            if (!(twoTable[a][b + 1] instanceof PieceLabel)) {
                array.add((a) * 8 + (b + 1));
            }
        }
        //bot left
        if ((a + 1 <= 7 && a + 1 >= 0) && (b - 1 <= 7 && b - 1 >= 0)) {
            if (twoTable[a + 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a + 1) * 8 + (b - 1));
                }
            }
            if (!(twoTable[a + 1][b - 1] instanceof PieceLabel)) {
                array.add((a + 1) * 8 + (b - 1));
            }
        }
        //bot
        if ((a + 1 <= 7 && a - 1 >= 0) && (b <= 7 && b >= 0)) {
            if (twoTable[a + 1][b] instanceof PieceLabel) {
                if (twoTable[a + 1][b].getPiece().getTeam() != p.getTeam()) {
                    array.add((a + 1) * 8 + (b));
                }
            }
            if (!(twoTable[a + 1][b] instanceof PieceLabel)) {
                array.add((a + 1) * 8 + (b));
            }
        }
        //bot right
        if ((a + 1 <= 7 && a + 1 >= 0) && (b + 1 <= 7 && b + 1 >= 0)) {
            if (twoTable[a + 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 1].getPiece().getTeam() != p.getTeam()) {
                    array.add((a + 1) * 8 + (b + 1));
                }
            }
            if (!(twoTable[a + 1][b + 1] instanceof PieceLabel)) {
                array.add((a + 1) * 8 + (b + 1));
            }
        }
        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;
    }

    public int[] colorPawn(int i, Piece p) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        if (a - 1 < 8 && b + 1 < 8 && a + 1 >= 0 && b + 1 >= 0) {
            if (twoTable[a - 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b + 1].getPiece().getTeam() != p.getTeam()) {
                    if (p.getTeam() == 1) {
                        array.add((a - 1) * 8 + (b + 1));
                    }
                }
            }
        }
        if (a - 1 < 8 && b - 1 < 8 && a + 1 >= 0 && b - 1 >= 0) {
            if (twoTable[a - 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a - 1][b - 1].getPiece().getTeam() != p.getTeam()) {
                    if (p.getTeam() == 1) {
                        array.add((a - 1) * 8 + (b - 1));
                    }
                }
            }
        }
        if (a + 1 < 8 && b + 1 < 8 && a + 1 >= 0 && b + 1 >= 0) {
            if (twoTable[a + 1][b + 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b + 1].getPiece().getTeam() != p.getTeam()) {
                    if (p.getTeam() == 2) {
                        array.add((a + 1) * 8 + (b + 1));
                    }
                }
            }
        }
        if (a + 1 < 8 && b - 1 < 8 && a + 1 >= 0 && b - 1 >= 0) {
            if (twoTable[a + 1][b - 1] instanceof PieceLabel) {
                if (twoTable[a + 1][b - 1].getPiece().getTeam() != p.getTeam()) {
                    if (p.getTeam() == 2) {
                        array.add((a + 1) * 8 + (b - 1));
                    }
                }
            }
        }
        if (p.getTeam() == 1) {
            if (a - 1 < 8 && b < 8 && a + 1 >= 0 && b >= 0) {
                if (!(twoTable[a - 1][b] instanceof PieceLabel)) {
                    array.add((a - 1) * 8 + (b));
                }
            }
            if (a - 2 < 8 && b < 8 && a - 2 >= 0 && b >= 0) {
                if (!(twoTable[a - 2][b] instanceof PieceLabel)) {
                    if (a == 6) {
                        if (!(twoTable[a - 1][b] instanceof PieceLabel) && !(twoTable[a - 2][b] instanceof PieceLabel)) {
                            array.add((a - 2) * 8 + (b));
                        }
                    }
                }
            }
        }
        if (p.getTeam() == 2) {
            if (a + 1 < 8 && b < 8 && a + 1 >= 0 && b >= 0) {
                if (!(twoTable[a + 1][b] instanceof PieceLabel)) {
                    array.add((a + 1) * 8 + (b));
                }
            }
            if (a + 2 < 8 && b < 8 && a + 2 >= 0 && b >= 0) {
                if (a == 1) {
                    if (!(twoTable[a + 1][b] instanceof PieceLabel) && !(twoTable[a + 2][b] instanceof PieceLabel)) {
                        array.add((a + 2) * 8 + (b));
                    }
                }
            }
        }
        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;
    }

    public int[] colorRook(int i, Piece p) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        int c = a;
        int d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c < 7) {
                c++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c > 0) {
                c--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (d < 7) {
                d++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (d > 0) {
                d--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;
    }

    public int[] colorQueen(int i, Piece p) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        int c = a;
        int d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c < 7) {
                c++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c > 0) {
                c--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (d < 7) {
                d++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (d > 0) {
                d--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c > 0 && d > 0) {
                c--;
                d--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c < 7 && d < 7) {
                c++;
                d++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c > 0 && d < 7) {
                c--;
                d++;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        c = a;
        d = b;
        for (int j = 0; j < 8; j++) {
            if ((c <= 7 && c >= 0) && (d <= 7 && d >= 0)) {
                if (twoTable[c][d] instanceof PieceLabel) {
                    if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                        array.add((c) * 8 + (d));
                    }
                }
                if (!(twoTable[c][d] instanceof PieceLabel)) {
                    array.add((c) * 8 + (d));
                }
            }
            if (c < 7 && d > 0) {
                c++;
                d--;
            }
            if (twoTable[c][d] instanceof PieceLabel) {
                if (twoTable[c][d].getPiece().getTeam() != p.getTeam()) {
                    array.add((c) * 8 + (d));
                }
                break;
            }
        }
        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;
    }

    public int[] colorCastling(int i, boolean castlingL, boolean castlingR, boolean castlingK) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        int c = a;
        int d = b;
        if (!(twoTable[c][d - 2] instanceof PieceLabel)) {
            if (!castlingL && !castlingK) {
                array.add(c * 8 + (d - 2));
            }
        }
        if (!(twoTable[c][d + 2] instanceof PieceLabel)) {
            if (!castlingR && !castlingK) {
                array.add(c * 8 + (d + 2));
            }
        }
        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;
    }

    public int[] colorPassant(int i, boolean passant, int j, Piece p) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        if (i > 7) {
            a = i / 8;
            b = i - (a * 8);
        } else {
            b = i;
            a = 0;
        }
        int c = 0;
        int d = 0;
        if (j > 7) {
            c = j / 8;
            d = j - (c * 8);
        } else {
            c = j;
            d = 0;
        }
        if (p.getTeam() == 1 && passant) {
            if ((a == (c + 1)) && ((b == d - 1) || (b == d + 1))) {
                array.add(j);
            }
        }
        if (p.getTeam() == 2 && passant) {
            if ((a == c - 1) && (b == d - 1 || b == d + 1)) {
                array.add(j);
            }
        }
        int[] list = new int[array.size()];
        for (int y = 0; y < array.size(); y++) {
            list[y] = array.get(y);
        }
        return list;

    }
}