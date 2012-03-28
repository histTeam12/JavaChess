package Code;

import java.awt.*;
import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class GUI extends JFrame {

    //Alle komponenter
    private BoardPane background = new BoardPane("src/Pictures/Background.png");
    private JMenuBar menuBar = new JMenuBar();
    private Chess chess = new Chess();
    private Timer timerS;
    private Timer timerH;
    private int[] counterH = new int[6];
    private int[] counterS = new int[6];
    private JTextArea textarea = new JTextArea(10, 12);
    private JTextArea textarea2 = new JTextArea(10, 12);
    private JScrollPane scrollpane = new JScrollPane(textarea);
    private JScrollPane scrollpane2 = new JScrollPane(textarea2);
    private JLabel lostPieceWLabel = new JLabel(new ImageIcon("src/pictures/lostPieceWNormal.png"));
    private JLabel lostPieceBLabel = new JLabel(new ImageIcon("src/pictures/lostPieceBNormal.png"));
    private JLabel whitegif = new JLabel(new ImageIcon("src/pictures/WhiteGIF.gif"));
    private JLabel blackgif = new JLabel(new ImageIcon("src/pictures/BlackGIF.gif"));
    private JTextArea lostPieceW = new JTextArea(15,5);
    private JTextArea lostPieceB = new JTextArea(15,5);
    private Container contentPane = getContentPane();
    private SpringLayout layout = new SpringLayout();
    ChessListener chessL = new ChessListener() {

        @Override
        public void chessReceived(ChessEvent event) {
            if (event.lag() == 1) {
                if (event.brikke() != -1) {
                    counterH[event.brikke()]++;
                }
                timerH.resume();
                timerS.pause();
                textarea.setText(chess.getWhiteLog());
                utslagsTabellS();
                whitegif.setVisible(false);
                blackgif.setVisible(true);
            } else if (event.lag() == 2) {
                if (event.brikke() != -1) {
                    counterS[event.brikke()]++;
                }
                timerH.pause();
                timerS.resume();
                textarea2.setText(chess.getBlackLog());
                utslagsTabellH();
                blackgif.setVisible(false);
                whitegif.setVisible(true);
            }
        }
    };

    public GUI(String tittel) {
        //Ramme
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(tittel);
        contentPane.setLayout(layout);
        setJMenuBar(menuBar);
        chess = new Chess();
        chess.addChessListener(chessL);
        timerS = new Timer();
        timerH = new Timer();
        scrollpane = new JScrollPane(textarea);
        scrollpane2 = new JScrollPane(textarea2);
        background.setPreferredSize(new Dimension(1084, 661));
        utslagsTabellH();
        utslagsTabellS();
        add(scrollpane);
        add(chess);
        add(scrollpane2);
        add(timerS);
        add(timerH);
        add(lostPieceWLabel);
        add(lostPieceBLabel);
        add(lostPieceB);
        add(lostPieceW);
        add(whitegif);
        add(blackgif);
        add(background);
        setConstraints();

        //Menybar
        JMenu file = new JMenu("File");
        JMenu settings = new JMenu("Settings");
        JMenu credits = new JMenu("Credits");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(settings);
        menuBar.add(credits);
        menuBar.add(help);
        menuBar.setBorder(null);

        //Knapper til menybar
        JMenuItem Nyttspill = new JMenuItem("New Game", new ImageIcon("src/Pictures/Newgame.png"));
        Nyttspill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
        JMenuItem Avslutt = new JMenuItem("Exit", new ImageIcon("src/Pictures/Exit.png"));
        JMenuItem Save = new JMenuItem("Save game", new ImageIcon("src/Pictures/Mac.png"));
        JMenuItem Load = new JMenuItem("Open game", new ImageIcon("src/Pictures/Load Icon.png"));
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        Load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        JRadioButtonMenuItem Meme = new JRadioButtonMenuItem("Meme-chess");
        JRadioButtonMenuItem Vanlig = new JRadioButtonMenuItem("Regular chess");
        Meme.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
        Vanlig.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.SHIFT_MASK));
        Avslutt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.SHIFT_MASK));
        JMenuItem Utviklere = new JMenuItem("Developers");
        ButtonGroup bg = new ButtonGroup();

        bg.add(Meme);
        bg.add(Vanlig);
        file.add(Nyttspill);
        file.add(Save);
        file.add(Load);
        file.add(Avslutt);
        settings.add(Meme);
        settings.add(Vanlig);
        credits.add(Utviklere);

        //Logg
        settings();

        //Lyttere
        Nyttspill.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        Avslutt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Utviklere.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Copyright © 2012 Andreas Kalstad, Henrik Reitan, Michael Olsen, Lars Kristoffer Sagmo. \nAll rights reserved.", "MemeChess", 3, new ImageIcon("src/Pictures/TrollfaceW.png"));
            }
        });
        Save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.toTable();
            }
        });
        Load.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.fromTable();
                chess.refresh();
            }
        });
        Meme.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.changeUI(1);
            }
        });
        Vanlig.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.changeUI(2);
            }
        });

        pack();
        setVisible(true);
    }

    public void utslagsTabellH() {
        String res = "";
        for (int i = 0; i < counterS.length; i++) {
            res+=": "+counterS[i]+"\n";
        }
        lostPieceW.setText(res);
    }

    public void utslagsTabellS() {
        String res = "";
        for (int i = 0; i < counterH.length; i++) {
            res+=": "+counterH[i]+"\n";
        }
        lostPieceB.setText(res);
    }

    public void reset() {
        remove(chess);
        remove(scrollpane);
        remove(scrollpane2);
        remove(background);
        counterH = new int[6];
        counterS = new int[6];
        utslagsTabellH();
        utslagsTabellS();
        textarea.setText("");
        textarea2.setText("");
        chess = new Chess();
        timerS.reset();
        timerH.reset();
        scrollpane = new JScrollPane(textarea);
        scrollpane2 = new JScrollPane(textarea2);
        chess.addChessListener(chessL);
        setConstraints();
        add(chess);
        add(scrollpane, SpringLayout.WEST);
        add(scrollpane2, SpringLayout.EAST);
        settings();
        add(background);
        repaint();
        setVisible(true);
    }
    
    public void settings(){
        textarea.setEditable(false);
        textarea2.setEditable(false);
        textarea.setOpaque(false);
        scrollpane.setOpaque(false);
        scrollpane.getViewport().setOpaque(false);
        scrollpane.setBorder(null);
        textarea2.setOpaque(false);
        scrollpane2.setOpaque(false);
        scrollpane2.getViewport().setOpaque(false);
        scrollpane2.setBorder(null);
        textarea.setForeground(Color.white);
        textarea2.setForeground(Color.white);
        scrollpane.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
        scrollpane2.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
        lostPieceW.setOpaque(false);
        lostPieceW.setEditable(false);
        lostPieceW.setFont(new Font("SansSerif", 4, 31));
        lostPieceW.setForeground(Color.white);
        lostPieceB.setOpaque(false);
        lostPieceB.setEditable(false);
        lostPieceB.setFont(new Font("SansSerif", 4, 31));
        lostPieceB.setForeground(Color.white);
        blackgif.setVisible(false);
    }
    
    public void setConstraints(){
        layout.putConstraint(SpringLayout.WEST, scrollpane, 35, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, scrollpane, 20, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, scrollpane2, 20, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, scrollpane2, 920, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, chess, 840, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, chess, 30, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, timerS, 223, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, timerS, 102, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, timerH, 223, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, timerH, 982, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lostPieceW, 165, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lostPieceW, 385, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lostPieceWLabel, 130, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lostPieceWLabel, 360, SpringLayout.NORTH, contentPane);        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lostPieceB, 1045, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lostPieceB, 385, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lostPieceBLabel, 1010, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, lostPieceBLabel, 360, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, whitegif, 268, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, whitegif, 1, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, blackgif, 267, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, blackgif, 881, SpringLayout.WEST, contentPane);
    }
    
}