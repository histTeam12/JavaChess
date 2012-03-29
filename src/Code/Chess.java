package Code;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import static javax.swing.JOptionPane.*;

public class Chess extends JInternalFrame implements MouseListener, MouseMotionListener {

    private java.util.List _listeners = new ArrayList();
    private Point startPos;
    private int xAdjustment;
    private int yAdjustment;
    private int turn = 2;
    private int team;
    private Log blackLog = new Log();
    private Log whiteLog = new Log();
    private Coordinates kord = new Coordinates();
    private ChessTable chessTable = new ChessTable();
    private JLayeredPane layeredPane;
    private BoardPane chessBoard;
    private PieceLabel chessPiece;
    private PieceLabel piece;
    private boolean meme = false;
    private Icon hjelpIkon; //Hjelpevariabel for midlertidig ikon funksjon
    private Icon lolW = new ImageIcon("src/Pictures/nyancat2.gif");
    private Icon lolB = new ImageIcon("src/Pictures/nyancat3.gif");
    private PawnB pawnB = new PawnB(new ImageIcon("src/Pictures/PawnB.png"));
    private PawnW pawnW = new PawnW(new ImageIcon("src/Pictures/PawnW.png"));
    private RookB rookB = new RookB(new ImageIcon("src/Pictures/RookB.png"));
    private RookW rookW = new RookW(new ImageIcon("src/Pictures/RookW.png"));
    private RookB rookBright = rookB;
    private RookB rookBleft = rookB;
    private RookW rookWleft = rookW;
    private RookW rookWright = rookW;
    private KnightB knightB = new KnightB(new ImageIcon("src/Pictures/KnightB.png"));
    private KnightW knightW = new KnightW(new ImageIcon("src/Pictures/KnightW.png"));
    private BishopB bishopB = new BishopB(new ImageIcon("src/Pictures/BishopB.png"));
    private BishopW bishopW = new BishopW(new ImageIcon("src/Pictures/BishopW.png"));
    private QueenB queenB = new QueenB(new ImageIcon("src/Pictures/QueenB.png"));
    private QueenW queenW = new QueenW(new ImageIcon("src/Pictures/QueenW.png"));
    private KingB kingB = new KingB(new ImageIcon("src/Pictures/KingB.png"));
    private KingW kingW = new KingW(new ImageIcon("src/Pictures/KingW.png"));

    public Chess() {
        Dimension boardSize = new Dimension(600, 600);

        setVisible(true);
        setLocation(100, 100);
        setTitle("");
        setResizable(false);
        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setBorder(null);
        setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ifu = getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        chessBoard = new BoardPane("src/Pictures/Chessboard.png");
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            square.setOpaque(false);
            chessBoard.add(square);
        }

        //Legger til brikker
        for (int i = 0; i < 8; i++) {
            PieceLabel test = new PieceLabel(pawnB.getIcon(), pawnB);
            JPanel panel = (JPanel) chessBoard.getComponent(8 + i);
            panel.add(test);
        }
        for (int i = 0; i < 8; i++) {
            PieceLabel piece = new PieceLabel(pawnW.getIcon(), pawnW);
            JPanel panel = (JPanel) chessBoard.getComponent(48 + i);
            panel.add(piece);
        }
        PieceLabel test = new PieceLabel(rookBleft.getIcon(), rookBleft);
        JPanel panel = (JPanel) chessBoard.getComponent(0);
        panel.add(test);
        test = new PieceLabel(rookBright.getIcon(), rookBright);
        panel = (JPanel) chessBoard.getComponent(7);
        panel.add(test);
        test = new PieceLabel(rookWright.getIcon(), rookWright);
        panel = (JPanel) chessBoard.getComponent(63);
        panel.add(test);
        test = new PieceLabel(rookWleft.getIcon(), rookWleft);
        panel = (JPanel) chessBoard.getComponent(56);
        panel.add(test);
        test = new PieceLabel(knightB.getIcon(), knightB);
        panel = (JPanel) chessBoard.getComponent(1);
        panel.add(test);
        test = new PieceLabel(knightB.getIcon(), knightB);
        panel = (JPanel) chessBoard.getComponent(6);
        panel.add(test);
        test = new PieceLabel(knightW.getIcon(), knightW);
        panel = (JPanel) chessBoard.getComponent(62);
        panel.add(test);
        test = new PieceLabel(knightW.getIcon(), knightW);
        panel = (JPanel) chessBoard.getComponent(57);
        panel.add(test);
        test = new PieceLabel(bishopB.getIcon(), bishopB);
        panel = (JPanel) chessBoard.getComponent(5);
        panel.add(test);
        test = new PieceLabel(bishopB.getIcon(), bishopB);
        panel = (JPanel) chessBoard.getComponent(2);
        panel.add(test);
        test = new PieceLabel(bishopW.getIcon(), bishopW);
        panel = (JPanel) chessBoard.getComponent(61);
        panel.add(test);
        test = new PieceLabel(bishopW.getIcon(), bishopW);
        panel = (JPanel) chessBoard.getComponent(58);
        panel.add(test);
        test = new PieceLabel(queenB.getIcon(), queenB);
        panel = (JPanel) chessBoard.getComponent(3);
        panel.add(test);
        test = new PieceLabel(queenW.getIcon(), queenW);
        panel = (JPanel) chessBoard.getComponent(59);
        panel.add(test);
        test = new PieceLabel(kingB.getIcon(), kingB);
        panel = (JPanel) chessBoard.getComponent(4);
        panel.add(test);
        test = new PieceLabel(kingW.getIcon(), kingW);
        panel = (JPanel) chessBoard.getComponent(60);
        panel.add(test);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            chessPiece = null;
            Component c = chessBoard.findComponentAt(e.getX(), e.getY());

            if (c instanceof JPanel) {
                return;
            }

            Point parentLocation = c.getParent().getLocation();
            xAdjustment = parentLocation.x - e.getX();
            yAdjustment = parentLocation.y - e.getY();
            chessPiece = (PieceLabel) c;
            chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
            layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
            hjelpIkon = chessPiece.getIcon(); //Hjelpevariabel for midlertidig ikon funksjon
            startPos = chessPiece.getLocation();
        } catch (NullPointerException npe) {
        }
    }

    //moveer piecen rundt
    @Override
    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) {
            return;
        }
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
//        Setter Midlertidig ikon mens piecen blir move
        if (meme) {
            if (chessPiece.getPiece().getTeam() == 1) {
                chessPiece.setIcon(lolW);
            }
            if (chessPiece.getPiece().getTeam() == 2) {
                chessPiece.setIcon(lolB);
            }
        }
    }

    //Slipper piecen tilbake på brettet
    @Override
    public void mouseReleased(MouseEvent e) {
        if (chessBoard.findComponentAt(e.getX(), e.getY()) instanceof PieceLabel) {
            piece = (PieceLabel) chessBoard.findComponentAt(e.getX(), e.getY());
        } else {
            piece = null;
        }
        if (chessPiece == null) {
            return;
        }
        //Sjekker om det er hvit eller svart sin tur:
        if ((chessPiece.getPiece().getTeam() == 2 && turn % 2 == 0) || (chessPiece.getPiece().getTeam() == 1 && turn % 2 == 1)) {
            moveBack();
            //chessPiece.setIcon(hjelpIkon);
            return;
        }
        if (meme) {
            chessPiece.setIcon(hjelpIkon); //setter tilbake til originalt ikon
        }
        Component m = chessBoard.findComponentAt(e.getX(), e.getY());
        Point b;
        if (m instanceof JPanel) {
            b = m.getLocation();
        } else {
            b = m.getParent().getLocation();
        }
        if (m instanceof PieceLabel) {
            piece = (PieceLabel) chessBoard.findComponentAt(e.getX(), e.getY());
        }
        xAdjustment = b.x - e.getX();
        yAdjustment = b.y - e.getY();
        //Sjekker om piecen slippes på en annen piece(og i så fall hvilken farge), eller blank rute
        if (m instanceof PieceLabel) {
            team = piece.getPiece().getTeam();
        }
        if (m instanceof JPanel) {
            team = 0;
        }
        movepiece(e, m);
        refresh();
        chessTable.reset();
        toTable();
//        chessTable.testTwoTable();
        System.out.println(chessTable.checkW(kingWpos()));
    }

    public void movepiece(MouseEvent e, Component m) {
        try {

            //Sjekker hva steams brikke som blir move og deretter om det er et lovlig move
            if (chessPiece.getPiece().equals(pawnB)) {
                movePawnB(e, m);
            }
            if (chessPiece.getPiece().equals(pawnW)) {
                movePawnW(e, m);
            }
            if (chessPiece.getPiece().equals(queenW)) {
                moveQueenW(e, m);
            }

            if (chessPiece.getPiece().equals(queenB)) {
                moveQueenB(e, m);
            }
            if (chessPiece.getPiece().equals(knightB)) {
                moveKnightB(e, m);
            }
            if (chessPiece.getPiece().equals(knightW)) {
                moveKnightW(e, m);
            }
            if (chessPiece.getPiece().equals(kingW)) {
                moveKingW(e, m);
            }

            if (chessPiece.getPiece().equals(kingB)) {
                moveKingB(e, m);
            }
            if (chessPiece.getPiece().equals(bishopW)) {
                moveBishopW(e, m);
            }
            if (chessPiece.getPiece().equals(bishopB)) {
                moveBishopB(e, m);
            }
            if (chessPiece.getPiece().equals(rookW)) {
                moveRookW(e, m);
            }
            if (chessPiece.getPiece().equals(rookB)) {
                moveRookB(e, m);
            }

            chessPiece.setVisible(true);
        } catch (NullPointerException npe) {
            moveBack();
        }
    }

    public void move(MouseEvent e) {
        //Hvis det står en piece i ruten allerede blir denne erstattet av den som droppes, om det er en blank rute blir den bare addet til kontaineren i den ruten
        chessPiece.setVisible(false);
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof PieceLabel) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(chessPiece);
        } else {
            Container parent = (Container) c;
            parent.add(chessPiece);
        }
        if (chessPiece.getPiece().getTeam() == 1) {
            whiteLog.leggTilLogg(chessPiece.getPiece().getName() + " from " + kord.getKoord(startPos) + " to " + kord.getKoord((e.getX() + xAdjustment), (e.getY() + yAdjustment)));
        }
        if (chessPiece.getPiece().getTeam() == 2) {
            blackLog.leggTilLogg(chessPiece.getPiece().getName() + " from " + kord.getKoord(startPos) + " to " + kord.getKoord((e.getX() + xAdjustment), (e.getY() + yAdjustment)));
        }
        fireChessEvent();
        turn++;
        chessPiece.setVisible(true);
    }

    public void moveBack() {
        //flytter piecen tilbake dit den ble plukket opp
        chessPiece.setVisible(false);
        chessPiece.setIcon(hjelpIkon);
        Component c = chessBoard.findComponentAt(startPos);

        if (c instanceof PieceLabel) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(chessPiece);
        } else {
            Container parent = (Container) c;
            parent.add(chessPiece);
        }
        chessPiece.setVisible(true);
    }

    public int kingBpos() {
        for (int i = 0; i < 64; i++) {
            if (chessBoard.findComponentAt(kord.getPunkt(i)) instanceof PieceLabel) {
                if (pieceType(kord.getPunkt(i)).equals(kingB)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public int kingWpos() {
        for (int i = 0; i < 64; i++) {
            if (chessBoard.findComponentAt(kord.getPunkt(i)) instanceof PieceLabel) {
                if (pieceType(kord.getPunkt(i)).equals(kingW)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Piece pieceType(Point a) {
        Component c = chessBoard.findComponentAt(a);
        if (c instanceof PieceLabel) {
            PieceLabel b = (PieceLabel) c;
            return b.getPiece();
        }
        return null;
    }

    public Piece pieceType(int x, int y) {
        Point a = new Point(x, y);
        Component c = chessBoard.findComponentAt(a);
        if (c instanceof PieceLabel) {
            PieceLabel b = (PieceLabel) c;
            return b.getPiece();
        }
        return null;
    }

    public void refresh() {
        layeredPane.remove(chessBoard);
        layeredPane.add(chessBoard);
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public String getBlackLog() {
        return blackLog.toString();
    }

    public String getWhiteLog() {
        return whiteLog.toString();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void toTable() {
        for (int i = 0; i < 64; i++) {
            if (chessBoard.findComponentAt(kord.getPunkt(i)) instanceof PieceLabel) {
                chessTable.updateTable((PieceLabel) chessBoard.findComponentAt(kord.getPunkt(i)), i);
            }
        }
        chessTable.updateLog(getWhiteLog(), 0);
        chessTable.updateLog(getBlackLog(), 1);
        chessTable.updateTwoTable();
    }

    public void fromTable() {
        for (int i = 0; i < 64; i++) {
            Component c = chessTable.getTable(i);
            if (c instanceof PieceLabel) {
                JPanel panel = (JPanel) chessBoard.getComponent(i);
                panel.add(c);
            }
        }
        whiteLog.clearLogg();
        blackLog.clearLogg();
        whiteLog.leggTilLogg(chessTable.getLog(0));
        blackLog.leggTilLogg(chessTable.getLog(1));
    }

    public synchronized void addChessListener(ChessListener l) {
        _listeners.add(l);
    }

    public synchronized void removeChessListener(ChessListener l) {
        _listeners.remove(l);
    }

    private synchronized void fireChessEvent() {
        if (piece != null) {
            ChessEvent chessEvent = new ChessEvent(this, chessPiece.getPiece().getTeam(), piece.getPiece());
            Iterator listeners = _listeners.iterator();
            while (listeners.hasNext()) {
                ((ChessListener) listeners.next()).chessReceived(chessEvent);
            }
        } else {
            ChessEvent chessEvent = new ChessEvent(this, chessPiece.getPiece().getTeam());
            Iterator listeners = _listeners.iterator();
            while (listeners.hasNext()) {
                ((ChessListener) listeners.next()).chessReceived(chessEvent);
            }
        }
    }

    public void changeUI(int i) {
        if (i == 1) {
            meme = true;
        }
        if (i == 2) {
            meme = false;
        }
        chessTable.reset();
        toTable();
        chessTable.changeUI(i);
        fromTable();
        refresh();
    }

    public void optionDialog(int lag) {
        JButton button1 = new JButton(knightB.getIcon());
        JButton button2 = new JButton(knightW.getIcon());
        JButton button3 = new JButton(queenB.getIcon());
        JButton button4 = new JButton(queenW.getIcon());
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chessPiece = new PieceLabel(knightB.getIcon(), knightB);
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chessPiece = new PieceLabel(knightW.getIcon(), knightW);
            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chessPiece = new PieceLabel(queenB.getIcon(), queenB);
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chessPiece = new PieceLabel(queenW.getIcon(), queenW);
            }
        });

        if (chessPiece.getPiece().getTeam() == 1) {
            Object[] group = {button2, button4};
            showConfirmDialog(null, group, "Choose piece", OK_OPTION, QUESTION_MESSAGE, pawnW.getIcon());
        }
        if (chessPiece.getPiece().getTeam() == 2) {
            Object[] group = {button1, button3};
            showConfirmDialog(null, group, "Choose piece", OK_OPTION, QUESTION_MESSAGE, pawnB.getIcon());
        }

    }

    public void movePawnB(MouseEvent e, Component m) {
        if (e.getY() + yAdjustment == startPos.getY() + 150 || e.getY() + yAdjustment == startPos.getY() - 150) {
            if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + 75) instanceof PieceLabel) {
                moveBack();
            }
        }
        if (pawnB.legalMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, team)) {
            //Bytter til dronning når bonde kommer helt over brettet (skal skiftes til valgfri brikke)
            if (e.getY() + yAdjustment == 525) {
                chessPiece.setVisible(false);
                optionDialog(chessPiece.getPiece().getTeam());
                chessPiece.setVisible(true);
                move(e);
                return;
            }
            move(e);
        } else {
            moveBack();
        }
    }

    public void movePawnW(MouseEvent e, Component m) {

        if (e.getY() + yAdjustment == startPos.getY() + 150 || e.getY() + yAdjustment == startPos.getY() - 150) {
            if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() - 75) instanceof PieceLabel) {
                moveBack();
            }
        }
        if (pawnW.legalMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, team)) {
            //Bytter til dronning når bonde kommer helt over brettet (skal skiftes til valgfri piece)
            if (e.getY() + yAdjustment == 0) {
                chessPiece.setVisible(false);
                optionDialog(chessPiece.getPiece().getTeam());
                chessPiece.setVisible(true);
                move(e);
                return;
            }
            move(e);
        } else {
            moveBack();
        }
    }

    public void moveQueenW(MouseEvent e, Component m) {
        int ruter;
        if (queenW.legalMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, team)) {
            if (Math.abs((int) startPos.getX() - ((int) e.getX() + xAdjustment)) == (Math.abs((int) startPos.getY() - ((int) e.getY() + yAdjustment)))) { //if "løper"
                //Ned venstre
                if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
                //Opp venstre
                if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
                // Opp høyre
                if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
                // Ned høyre
                if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }

                move(e);
            }

            if (((int) e.getY() + yAdjustment) != (int) startPos.getY() && ((int) e.getX() + xAdjustment) == (int) startPos.getX() || (((int) e.getY() + yAdjustment) == (int) startPos.getY() && ((int) e.getX() + xAdjustment) != (int) startPos.getX())) { //if "tårn"
                //Y-Retning
                if (((int) startPos.getX() == e.getX() + xAdjustment) && (((int) e.getY() + yAdjustment) != (int) startPos.getY())) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    } else {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    }
                }
                //X-Retning
                if (((int) startPos.getY() == e.getY() + yAdjustment) && (((int) e.getX() + xAdjustment) != (int) startPos.getX())) {
                    ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                    if ((int) e.getX() + xAdjustment > (int) startPos.getX()) {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    } else {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    }
                }
                move(e);
            }
        } else {
            moveBack();
        }
    }

    public void moveQueenB(MouseEvent e, Component m) {
        int ruter;
        if (queenB.legalMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, team)) {
            if (Math.abs((int) startPos.getX() - ((int) e.getX() + xAdjustment)) == (Math.abs((int) startPos.getY() - ((int) e.getY() + yAdjustment)))) { //if "løper"
                //Ned venstre
                if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
                //Opp venstre
                if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
                // Opp høyre
                if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
                // Ned høyre
                if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                    ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }

                move(e);
            }

            if (((int) e.getY() + yAdjustment) != (int) startPos.getY() && ((int) e.getX() + xAdjustment) == (int) startPos.getX() || (((int) e.getY() + yAdjustment) == (int) startPos.getY() && ((int) e.getX() + xAdjustment) != (int) startPos.getX())) { //if "tårn"
                //Y-Retning
                if (((int) startPos.getX() == e.getX() + xAdjustment) && (((int) e.getY() + yAdjustment) != (int) startPos.getY())) {
                    ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                    if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    } else {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    }
                }
                //X-Retning
                if (((int) startPos.getY() == e.getY() + yAdjustment) && (((int) e.getX() + xAdjustment) != (int) startPos.getX())) {
                    ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                    if ((int) e.getX() + xAdjustment > (int) startPos.getX()) {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    } else {
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof PieceLabel) {
                                moveBack();
                                return;
                            }
                        }
                    }
                }
                move(e);
            }
        } else {
            moveBack();
        }
    }

    public void moveKnightB(MouseEvent e, Component m) {
        if (knightB.legalMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, team)) {
            move(e);
        } else {
            moveBack();
        }
    }

    public void moveKnightW(MouseEvent e, Component m) {
        if (knightW.legalMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, team)) {
            move(e);
        } else {
            moveBack();
        }

    }

    public void moveKingW(MouseEvent e, Component m) {
        if ((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == -150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment),
                (e.getY() + yAdjustment)) instanceof PieceLabel && !(chessBoard.findComponentAt(((int) startPos.getX() + xAdjustment + 75), (int) (startPos.getY() + yAdjustment)) instanceof PieceLabel))) {
            if (kingW.move() == false && rookWright.move() == false) {
                move(e);
                Component c = chessBoard.findComponentAt((int) startPos.getX() + 225, (int) startPos.getY());
                Container parent = (Container) chessBoard.getComponent(61);
                parent.add(c);
                kingW.setMove();
                chessPiece.setVisible(true);
                return;
            }
        }
        if ((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == 150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment),
                (e.getY() + yAdjustment)) instanceof PieceLabel && !(chessBoard.findComponentAt(((int) startPos.getX() + xAdjustment - 75), (int) (startPos.getY() + yAdjustment)) instanceof PieceLabel)
                && !(chessBoard.findComponentAt(((int) startPos.getX() + xAdjustment - 225), (int) (startPos.getY() + yAdjustment)) instanceof PieceLabel))) {
            if (kingW.move() == false && rookWleft.move() == false) {
                move(e);
                Component c = chessBoard.findComponentAt((int) startPos.getX() - 300, (int) startPos.getY());
                Container parent = (Container) chessBoard.getComponent(59);
                parent.add(c);
                kingW.setMove();
                chessPiece.setVisible(true);
                return;
            }
        }
        if (kingW.legalMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, team)) {
            move(e);
            kingW.setMove();
        } else {
            moveBack();
        }
    }

    public void moveKingB(MouseEvent e, Component m) {
        if ((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == 150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment),
                (e.getY() + yAdjustment)) instanceof PieceLabel && !(chessBoard.findComponentAt(((int) startPos.getX() + xAdjustment + 75), (int) (startPos.getY() + yAdjustment)) instanceof PieceLabel))) {
            if (kingB.move() == false && rookBleft.move() == false) {
                move(e);
                Component c = chessBoard.findComponentAt((int) startPos.getX() - 300, (int) startPos.getY());
                Container parent = (Container) chessBoard.getComponent(3);
                parent.add(c);
                kingB.setMove();
                chessPiece.setVisible(true);
                return;
            }
        }
        if ((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == -150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment),
                (e.getY() + yAdjustment)) instanceof PieceLabel && !(chessBoard.findComponentAt(((int) startPos.getX() + xAdjustment - 75), (int) (startPos.getY() + yAdjustment)) instanceof PieceLabel)
                && !(chessBoard.findComponentAt(((int) startPos.getX() + xAdjustment - 225), (int) (startPos.getY() + yAdjustment)) instanceof PieceLabel))) {
            if (kingB.move() == false && rookBright.move() == false) {
                move(e);
                Component c = chessBoard.findComponentAt((int) startPos.getX() + 225, (int) startPos.getY());
                Container parent = (Container) chessBoard.getComponent(5);
                parent.add(c);
                kingB.setMove();
                chessPiece.setVisible(true);
                return;
            }
        }
        if (kingB.legalMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, team)) {
            move(e);
            kingB.setMove();
        } else {
            moveBack();
        }
    }

    public void moveBishopW(MouseEvent e, Component m) {
        //Ned venstre
        int ruter;
        if (bishopW.legalMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, team)) {
            if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            //Opp venstre
            if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            // Opp høyre
            if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            // Ned høyre
            if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            move(e);
        } else {
            moveBack();
        }
    }

    public void moveBishopB(MouseEvent e, Component m) {
        //Ned venstre
        int ruter;
        if (bishopB.legalMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, team)) {
            if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            //Opp venstre
            if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            // Opp høyre
            if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            // Ned høyre
            if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                for (int i = 0; i < ruter; i++) {
                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                        moveBack();
                        return;
                    }
                }
            }
            move(e);
        } else {
            moveBack();
        }
    }

    public void moveRookW(MouseEvent e, Component m) {
        int ruter;
        if (rookW.legalMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, team)) {
            //Y-Retning
            if ((int) startPos.getX() == e.getX() + xAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                } else {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
            }
            //X-Retning
            if ((int) startPos.getY() == e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                if ((int) e.getX() + xAdjustment > (int) startPos.getX()) {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                } else {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
            }
            move(e);
        } else {
            moveBack();
        }
    }

    public void moveRookB(MouseEvent e, Component m) {
        int ruter;
        if (rookB.legalMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, team)) {
            //Y-Retning
            if ((int) startPos.getX() == e.getX() + xAdjustment) {
                ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                } else {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
            }
            //X-Retning
            if ((int) startPos.getY() == e.getY() + yAdjustment) {
                ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                if ((int) e.getX() + xAdjustment > (int) startPos.getX()) {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                } else {
                    for (int i = 0; i < ruter; i++) {
                        if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof PieceLabel) {
                            moveBack();
                            return;
                        }
                    }
                }
            }
            move(e);
        } else {
            moveBack();
        }
    }
}