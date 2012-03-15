package Kode;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Sjakk extends JFrame implements MouseListener, MouseMotionListener {
    
    int penis;
    int tur = 2;
    JLayeredPane layeredPane;
    BrettRute chessBoard;
    BrikkeLabel chessPiece;
    BrikkeLabel brikke;
    int lag;
    Icon lolW = new ImageIcon("src/Kode/Bilder/lolW.png");
    Icon lolB = new ImageIcon("src/Kode/Bilder/lolB.png");
    BondeS bondeS = new BondeS(new ImageIcon("src/Kode/Bilder/okayguyB.png"));
    BondeH bondeH = new BondeH(new ImageIcon("src/Kode/Bilder/okayguyW.png"));
    TarnS tårnS = new TarnS(new ImageIcon("src/Kode/Bilder/fyeahS.png"));
    TarnS tårnShø = tårnS;
    TarnS tårnSve = tårnS;
    TarnH tårnH = new TarnH(new ImageIcon("src/Kode/Bilder/fyeahW.png"));    
    TarnH tårnve = tårnH;
    TarnH tårnhø = tårnH;
    HestS hestS = new HestS(new ImageIcon("src/Kode/Bilder/trollfaceB.png"));
    HestH hestH = new HestH(new ImageIcon("src/Kode/Bilder/trollfaceW.png"));
    LoperS løperS = new LoperS(new ImageIcon("src/Kode/Bilder/badassB.png"));
    LoperH løperH = new LoperH(new ImageIcon("src/Kode/Bilder/badassW.png"));
    DronningS dronningS = new DronningS(new ImageIcon("src/Kode/Bilder/fmercuryB.png"));
    DronningH dronningH = new DronningH(new ImageIcon("src/Kode/Bilder/fmercuryW.png"));
    KongeS kongeS = new KongeS(new ImageIcon("src/Kode/Bilder/yaomingB.png"));
    KongeH kongeH = new KongeH(new ImageIcon("src/Kode/Bilder/yaomingW.png"));
    Icon hjelpIkon; //Hjelpevariabel for midlertidig ikon funksjon
    Point startPos;
    int xAdjustment;
    int yAdjustment;

    public Sjakk() {
        Dimension boardSize = new Dimension(600, 600);

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        chessBoard = new BrettRute("src/Kode/Bilder/Sjakkbrett5.png");
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
            BrikkeLabel test = new BrikkeLabel(bondeS.getIcon(), bondeS);
            JPanel panel = (JPanel) chessBoard.getComponent(8 + i);
            panel.add(test);
        }
        for (int i = 0; i < 8; i++) {
            BrikkeLabel piece = new BrikkeLabel(bondeH.getIcon(), bondeH);
            JPanel panel = (JPanel) chessBoard.getComponent(48 + i);
            panel.add(piece);
        }
        BrikkeLabel test = new BrikkeLabel(tårnSve.getIcon(), tårnSve);
        JPanel panel = (JPanel) chessBoard.getComponent(0);
        panel.add(test);
        test = new BrikkeLabel(tårnShø.getIcon(), tårnShø);
        panel = (JPanel) chessBoard.getComponent(7);
        panel.add(test);
        test = new BrikkeLabel(tårnhø.getIcon(), tårnhø);
        panel = (JPanel) chessBoard.getComponent(63);
        panel.add(test);
        test = new BrikkeLabel(tårnve.getIcon(), tårnve);
        panel = (JPanel) chessBoard.getComponent(56);
        panel.add(test);
        test = new BrikkeLabel(hestS.getIcon(), hestS);
        panel = (JPanel) chessBoard.getComponent(1);
        panel.add(test);
        test = new BrikkeLabel(hestS.getIcon(), hestS);
        panel = (JPanel) chessBoard.getComponent(6);
        panel.add(test);
        test = new BrikkeLabel(hestH.getIcon(), hestH);
        panel = (JPanel) chessBoard.getComponent(62);
        panel.add(test);
        test = new BrikkeLabel(hestH.getIcon(), hestH);
        panel = (JPanel) chessBoard.getComponent(57);
        panel.add(test);
        test = new BrikkeLabel(løperS.getIcon(), løperS);
        panel = (JPanel) chessBoard.getComponent(5);
        panel.add(test);
        test = new BrikkeLabel(løperS.getIcon(), løperS);
        panel = (JPanel) chessBoard.getComponent(2);
        panel.add(test);
        test = new BrikkeLabel(løperH.getIcon(), løperH);
        panel = (JPanel) chessBoard.getComponent(61);
        panel.add(test);
        test = new BrikkeLabel(løperH.getIcon(), løperH);
        panel = (JPanel) chessBoard.getComponent(58);
        panel.add(test);
        test = new BrikkeLabel(dronningS.getIcon(), dronningS);
        panel = (JPanel) chessBoard.getComponent(3);
        panel.add(test);
        test = new BrikkeLabel(dronningH.getIcon(), dronningH);
        panel = (JPanel) chessBoard.getComponent(59);
        panel.add(test);
        test = new BrikkeLabel(kongeS.getIcon(), kongeS);
        panel = (JPanel) chessBoard.getComponent(4);
        panel.add(test);
        test = new BrikkeLabel(kongeH.getIcon(), kongeH);
        panel = (JPanel) chessBoard.getComponent(60);
        panel.add(test);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel) {
            return;
        }

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (BrikkeLabel) c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
        hjelpIkon = chessPiece.getBrikke().getIcon(); //Hjelpevariabel for midlertidig ikon funksjon
        startPos = chessPiece.getLocation();
    }

    //Flytter brikken rundt
    @Override
    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) {
            return;
        }
        chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
        //Setter Midlertidig ikon mens brikken blir flyttet
        if (chessPiece.getBrikke().getLag() == 1) {
            chessPiece.setIcon(lolW);
        }
        if (chessPiece.getBrikke().getLag() == 2) {
            chessPiece.setIcon(lolB);
        }
    }

    //Slipper brikken tilbake på brettet
    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            if (chessPiece == null) {
                return;
            }
            //Sjekker om det er hvit eller svart sin tur:
            if ((chessPiece.getBrikke().getLag() == 2 && tur % 2 == 0) || (chessPiece.getBrikke().getLag() == 1 && tur % 2 == 1)) {
                flyttTilbake();
                chessPiece.setIcon(hjelpIkon);
                return;
            }
            chessPiece.setIcon(hjelpIkon); //setter tilbake til originalt ikon
            Component m = chessBoard.findComponentAt(e.getX(), e.getY());
            Point b;
            if (m instanceof JPanel) {
                b = m.getLocation();
            } else {
                b = m.getParent().getLocation();
            }
            if (m instanceof BrikkeLabel) {
                brikke = (BrikkeLabel) chessBoard.findComponentAt(e.getX(), e.getY());
            }
            xAdjustment = b.x - e.getX();
            yAdjustment = b.y - e.getY();
            //Sjekker om brikken slippes på en annen brikke(og i så fall hvilken farge), eller blank rute
            if (m instanceof BrikkeLabel) {
                lag = brikke.getBrikke().getLag();
            }
            if (m instanceof JPanel) {
                lag = 0;
            }
            //Sjekker hva slags brikke som blir flyttet og deretter om det er et lovlig flytt
            if (chessPiece.getIcon().equals(bondeS.getIcon())) {
                if (e.getY() + yAdjustment == startPos.getY() + 150 || e.getY() + yAdjustment == startPos.getY() - 150) {
                    if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + 75) instanceof BrikkeLabel) {
                        flyttTilbake();
                    }
                }
                if (bondeS.lovligMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, lag)) {
                    flytt(e);
                    //Bytter til dronning når bonde kommer helt over brettet (skal skiftes til valgfri brikke)
                    if (e.getY() + yAdjustment == 525) {
                        JOptionPane.showMessageDialog(null, "Dronning");
                        chessPiece = (new BrikkeLabel(dronningS.getIcon(), dronningS));
                    }
                } else {
                    flyttTilbake();
                }

            }
            if (chessPiece.getIcon().equals(bondeH.getIcon())) {
                if (e.getY() + yAdjustment == startPos.getY() + 150 || e.getY() + yAdjustment == startPos.getY() - 150) {
                    if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() - 75) instanceof BrikkeLabel) {
                        flyttTilbake();
                    }
                }
                if (bondeH.lovligMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, lag)) {
                    flytt(e);
                    //Bytter til dronning når bonde kommer helt over brettet (skal skiftes til valgfri brikke)
                    if (e.getY() + yAdjustment == 0) {
                        JOptionPane.showMessageDialog(null, "Dronning");
                        chessPiece = (new BrikkeLabel(dronningH.getIcon(), dronningH));
                    }
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(dronningH.getIcon())) {
                int ruter;
                if (dronningH.lovligMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, lag)) {
                    if (Math.abs((int) startPos.getX() - ((int) e.getX() + xAdjustment)) == (Math.abs((int) startPos.getY() - ((int) e.getY() + yAdjustment)))) { //if "løper"
                        //Ned venstre
                        if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                        //Opp venstre
                        if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                        // Opp høyre
                        if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                        // Ned høyre
                        if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }

                        flytt(e);
                    }

                    if (((int) e.getY() + yAdjustment) != (int) startPos.getY() && ((int) e.getX() + xAdjustment) == (int) startPos.getX() || (((int) e.getY() + yAdjustment) == (int) startPos.getY() && ((int) e.getX() + xAdjustment) != (int) startPos.getX())) { //if "tårn"
                        //Y-Retning
                        if (((int) startPos.getX() == e.getX() + xAdjustment) && (((int) e.getY() + yAdjustment) != (int) startPos.getY())) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                                for (int i = 0; i < ruter; i++) {
                                    if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                        flyttTilbake();
                                        return;
                                    }
                                }
                            } else {
                                for (int i = 0; i < ruter; i++) {
                                    if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof BrikkeLabel) {
                                        flyttTilbake();
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
                                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                        flyttTilbake();
                                        return;
                                    }
                                }
                            } else {
                                for (int i = 0; i < ruter; i++) {
                                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                        flyttTilbake();
                                        return;
                                    }
                                }
                            }
                        }
                        flytt(e);
                    }
                } else {
                    flyttTilbake();
                }
            }

            if (chessPiece.getIcon().equals(dronningS.getIcon())) {
                int ruter;
                if (dronningS.lovligMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, lag)) {
                    if (Math.abs((int) startPos.getX() - ((int) e.getX() + xAdjustment)) == (Math.abs((int) startPos.getY() - ((int) e.getY() + yAdjustment)))) { //if "løper"
                        //Ned venstre
                        if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                        //Opp venstre
                        if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                        // Opp høyre
                        if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                        // Ned høyre
                        if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                            ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }

                        flytt(e);
                    }

                    if (((int) e.getY() + yAdjustment) != (int) startPos.getY() && ((int) e.getX() + xAdjustment) == (int) startPos.getX() || (((int) e.getY() + yAdjustment) == (int) startPos.getY() && ((int) e.getX() + xAdjustment) != (int) startPos.getX())) { //if "tårn"
                        //Y-Retning
                        if (((int) startPos.getX() == e.getX() + xAdjustment) && (((int) e.getY() + yAdjustment) != (int) startPos.getY())) {
                            ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                            if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                                for (int i = 0; i < ruter; i++) {
                                    if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                        flyttTilbake();
                                        return;
                                    }
                                }
                            } else {
                                for (int i = 0; i < ruter; i++) {
                                    if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof BrikkeLabel) {
                                        flyttTilbake();
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
                                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                        flyttTilbake();
                                        return;
                                    }
                                }
                            } else {
                                for (int i = 0; i < ruter; i++) {
                                    if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                        flyttTilbake();
                                        return;
                                    }
                                }
                            }
                        }
                        flytt(e);
                    }
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(hestS.getIcon())) {
                if (hestS.lovligMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, lag)) {
                    flytt(e);
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(hestH.getIcon())) {
                if (hestH.lovligMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, lag)) {
                    flytt(e);
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(kongeH.getIcon())) {
                    if((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == -150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment), 
                    (e.getY() + yAdjustment)) instanceof BrikkeLabel && !(chessBoard.findComponentAt(((int)startPos.getX() + xAdjustment + 75), (int)(startPos.getY() + yAdjustment)) instanceof BrikkeLabel))){
                            if(kongeH.flyttet() == false && tårnhø.flyttet() == false){
                                    flytt(e);
                                    Component c = chessBoard.findComponentAt((int)startPos.getX() +225, (int)startPos.getY());
                        Container parent = (Container) chessBoard.getComponent(61);
                        parent.add(c);
                                    kongeH.setFlyttet();
                                    chessPiece.setVisible(true);
                                    return;
                            }
                    }
                    if((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == 150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment), 
                  (e.getY() + yAdjustment)) instanceof BrikkeLabel && !(chessBoard.findComponentAt(((int)startPos.getX() + xAdjustment - 75), (int)(startPos.getY() + yAdjustment)) instanceof BrikkeLabel) &&
                  !(chessBoard.findComponentAt(((int)startPos.getX() + xAdjustment - 225), (int)(startPos.getY() + yAdjustment)) instanceof BrikkeLabel))){
                            if(kongeH.flyttet() == false && tårnve.flyttet() == false){
                                    flytt(e);
                                       Component c = chessBoard.findComponentAt((int)startPos.getX() -300, (int)startPos.getY());
                        Container parent = (Container) chessBoard.getComponent(59);
                        parent.add(c);
                                    kongeH.setFlyttet();
                                    chessPiece.setVisible(true);
                                    return;
                            }
                    }
                if (kongeH.lovligMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, lag)) {
                    flytt(e);
                    kongeH.setFlyttet();
                } else {
                    flyttTilbake();
                }
            }
            
            if (chessPiece.getIcon().equals(kongeS.getIcon())) {
                    if((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == 150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment), 
                    (e.getY() + yAdjustment)) instanceof BrikkeLabel && !(chessBoard.findComponentAt(((int)startPos.getX() + xAdjustment + 75), (int)(startPos.getY() + yAdjustment)) instanceof BrikkeLabel))){
                            if(kongeS.flyttet() == false && tårnSve.flyttet() == false){
                                    flytt(e);                                 
                                    Component c = chessBoard.findComponentAt((int)startPos.getX() -300, (int)startPos.getY());
                        Container parent = (Container) chessBoard.getComponent(3);
                        parent.add(c);
                                    kongeS.setFlyttet();
                                    chessPiece.setVisible(true);
                                    return;
                            }
                    }
                    if((e.getY() + yAdjustment == startPos.getY()) && (startPos.getX() - (e.getX() + xAdjustment)) == -150 && !(chessBoard.findComponentAt((e.getX() + xAdjustment), 
                  (e.getY() + yAdjustment)) instanceof BrikkeLabel && !(chessBoard.findComponentAt(((int)startPos.getX() + xAdjustment - 75), (int)(startPos.getY() + yAdjustment)) instanceof BrikkeLabel) &&
                  !(chessBoard.findComponentAt(((int)startPos.getX() + xAdjustment - 225), (int)(startPos.getY() + yAdjustment)) instanceof BrikkeLabel))){
                            if(kongeS.flyttet() == false && tårnShø.flyttet() == false){
                                    flytt(e);
                                       Component c = chessBoard.findComponentAt((int)startPos.getX() +225, (int)startPos.getY());
                        Container parent = (Container) chessBoard.getComponent(5);
                        parent.add(c);
                                    kongeS.setFlyttet();
                                    chessPiece.setVisible(true);
                                    return;
                            }
                    }
                if (kongeH.lovligMove(e.getY() + yAdjustment, e.getX() + xAdjustment, startPos, m, lag)) {
                    flytt(e);
                    kongeH.setFlyttet();
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(løperH.getIcon())) {
                //Ned venstre
                int ruter;
                if (løperH.lovligMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, lag)) {
                    if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    //Opp venstre
                    if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    // Opp høyre
                    if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    // Ned høyre
                    if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    flytt(e);
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(løperS.getIcon())) {
                //Ned venstre
                int ruter;
                if (løperS.lovligMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, lag)) {
                    if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    //Opp venstre
                    if ((int) startPos.getX() > e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() - (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    // Opp høyre
                    if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() > e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() - (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    // Ned høyre
                    if ((int) startPos.getX() < e.getX() + xAdjustment && (int) startPos.getY() < e.getY() + yAdjustment) {
                        ruter = Math.abs(((int) startPos.getX() - (e.getX() + xAdjustment)) / 75);
                        for (int i = 0; i < ruter; i++) {
                            if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                flyttTilbake();
                                return;
                            }
                        }
                    }
                    flytt(e);
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(tårnH.getIcon())) {
                int ruter;
                if (tårnH.lovligMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, lag)) {
                    //Y-Retning
                    if ((int) startPos.getX() == e.getX() + xAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        } else {
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
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
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        } else {
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                    }
                    flytt(e);
                } else {
                    flyttTilbake();
                }
            }
            if (chessPiece.getIcon().equals(tårnS.getIcon())) {
                int ruter;
                if (tårnS.lovligMove((int) e.getY() + yAdjustment, (int) e.getX() + xAdjustment, startPos, m, lag)) {
                    //Y-Retning
                    if ((int) startPos.getX() == e.getX() + xAdjustment) {
                        ruter = Math.abs(((int) startPos.getY() - (e.getY() + yAdjustment)) / 75);
                        if ((int) e.getY() + yAdjustment > (int) startPos.getY()) {
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * 75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        } else {
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX(), (int) startPos.getY() + (i * -75)) instanceof BrikkeLabel) {
                                    flyttTilbake();
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
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * 75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        } else {
                            for (int i = 0; i < ruter; i++) {
                                if (chessBoard.findComponentAt((int) startPos.getX() + (i * -75), (int) startPos.getY()) instanceof BrikkeLabel) {
                                    flyttTilbake();
                                    return;
                                }
                            }
                        }
                    }
                    flytt(e);
                } else {
                    flyttTilbake();
                }
            }

            chessPiece.setVisible(true);
        } catch (NullPointerException npe) {
            flyttTilbake();
        }
    }

    public void flytt(MouseEvent e) {
        //Hvis det står en brikke i ruten allerede blir denne erstattet av den som droppes, om det er en blank rute blir den bare addet til kontaineren i den ruten
        chessPiece.setVisible(false);
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());

        if (c instanceof BrikkeLabel) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(chessPiece);
            chessBoard.repaint(10);
        } else {
            Container parent = (Container) c;
            parent.add(chessPiece);
            chessBoard.repaint(10);
        }
        tur++;
        chessPiece.setVisible(true);
    }

    public void flyttTilbake() {
        //Flytter brikken tilbake dit den ble plukket opp
        chessPiece.setVisible(false);
        Component c = chessBoard.findComponentAt(startPos);

        if (c instanceof BrikkeLabel) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(chessPiece);
            chessBoard.repaint(10);
        } else {
            Container parent = (Container) c;
            parent.add(chessPiece);
            chessBoard.repaint(10);
        }
        chessPiece.setVisible(true);
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

    public static void main(String[] args) {
        JFrame frame = new Sjakk();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}