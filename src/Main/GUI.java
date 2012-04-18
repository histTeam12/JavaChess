package Main;

import Accessories.SaveGame;
import Accessories.Timer;
import Accessories.Rules;
import Accessories.SaveGame;
import Accessories.Timer;
import Logic.Chess;
import Logic.ChessEvent;
import Logic.ChessListener;
import Logic.PieceLabel;
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
import java.io.*;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.*;

public class GUI extends JFrame {

    //OBJECT VARIABLES
    private Rules rules = new Rules();
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/Accessories/Pictures/Background.png")));
    private JMenuBar menuBar = new JMenuBar();
    private Chess chess = new Chess();
    private SaveGame[] savegames = new SaveGame[6];
    private Timer timerS;
    private Timer timerH;
    private int[] counterH = new int[6];
    private int[] counterS = new int[6];
    private JTextArea textarea = new JTextArea(10, 12);
    private JTextArea textarea2 = new JTextArea(10, 12);
    private JScrollPane scrollpane = new JScrollPane(textarea);
    private JScrollPane scrollpane2 = new JScrollPane(textarea2);
    private JLabel lostPieceWLabel = new JLabel(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceWNormal.png")));
    private JLabel lostPieceBLabel = new JLabel(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceBNormal.png")));
    private JLabel whitegif = new JLabel(new ImageIcon(getClass().getResource("/Accessories/Pictures/WhiteGIF.gif")));
    private JLabel blackgif = new JLabel(new ImageIcon(getClass().getResource("/Accessories/Pictures/BlackGIF.gif")));
    private JTextArea helparea = rules.getRules();
    private JLabel helpbg = new JLabel(new ImageIcon(getClass().getResource("/Accessories/Pictures/Helpbackground.png")));
    private JScrollPane helppane = new JScrollPane(helparea);
    private JFrame helplabel = new JFrame();
    private JTextArea lostPieceW = new JTextArea(15, 5);
    private JTextArea lostPieceB = new JTextArea(15, 5);
    private Container contentPane = getContentPane();
    private SpringLayout layout = new SpringLayout(); //Using springlayout and adding constraints to place the components.

    //CONSTRUCTOR
    public GUI(String title) {
        //Settings for the frame and adding components.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        contentPane.setLayout(layout);
        setJMenuBar(menuBar);
        background.setPreferredSize(new Dimension(1084, 661));
        chess = new Chess();
        chess.addChessListener(chessL);
        timerS = new Timer();
        timerH = new Timer();
        scrollpane = new JScrollPane(textarea);
        scrollpane2 = new JScrollPane(textarea2);
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

        setConstraints(); //Sets constraints to the stuff added to the JFrame.
        settings(); //Using the settings() method to create the log.
        lostpieceTableW();
        lostpieceTableB();


        //Creating and adding the menubar
        JMenu file = new JMenu("File");
        JMenu settings = new JMenu("Settings");
        JMenu credits = new JMenu("Credits");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(settings);
        menuBar.add(credits);
        menuBar.add(help);
        menuBar.setBorder(null);

        //Creating buttons for the menubar with icons and key bindings.
        JMenuItem Newgame = new JMenuItem("New Game", new ImageIcon(getClass().getResource("/Accessories/Pictures/newgame.png")));
        Newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
        JMenuItem Exit = new JMenuItem("Exit", new ImageIcon(getClass().getResource("/Accessories/Pictures/Exit.png")));
        JMenuItem Save = new JMenuItem("Save game", new ImageIcon(getClass().getResource("/Accessories/Pictures/mac.png")));
        JMenuItem Load = new JMenuItem("Open game", new ImageIcon(getClass().getResource("/Accessories/Pictures/LoadIcon.png")));
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        Load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        JMenuItem Meme = new JMenuItem("Meme pieces");
        JMenuItem Regular = new JMenuItem("Regular pieces");
        JMenuItem Rules = new JMenuItem("Rules");
        Meme.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
        Regular.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.SHIFT_MASK));
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.SHIFT_MASK));
        JMenuItem Developers = new JMenuItem("Developers");
        ButtonGroup bg = new ButtonGroup(); //Creating a button group for the two radiobuttons.

        //Adding the buttons to the different
        bg.add(Meme);
        bg.add(Regular);
        file.add(Newgame);
        file.add(Save);
        file.add(Load);
        file.add(Exit);
        settings.add(Meme);
        settings.add(Regular);
        credits.add(Developers);
        help.add(Rules);
        

        //Listeners for the buttons in the menubar.
        Newgame.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        Exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Developers.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                developers();
            }
        });
        Save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });
        Load.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    fromSerialized();
                } catch (IOException io) {
                    System.out.println("ioExcepion" + io.getMessage());
                }
                loadGame();
            }
        });
        Meme.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.changeUI(1);
                lostPieceWLabel.setIcon(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceWMeme.png")));
                lostPieceBLabel.setIcon(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceBMeme.png")));
            }
        });
        Regular.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.changeUI(2);
                lostPieceWLabel.setIcon(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceWNormal.png")));
                lostPieceBLabel.setIcon(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceBNormal.png")));
            }
        });
        Rules.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               help();
            }
        });
        
        //Finishing the constructor by packing and setting visible.
        pack();
        setVisible(true);
    }

    //METHODS
    public void help(){
        helplabel.setTitle("Rules");
        helplabel.setPreferredSize(new Dimension(500, 400));
        helparea.setFont(new Font("Arial", Font.PLAIN, 15));
        helparea.setOpaque(false);
        helppane.setOpaque(false);
        textarea.setEditable(true);
        textarea.setOpaque(false);
        helppane.getViewport().setOpaque(false);
        helppane.setBorder(null);
        helppane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        helplabel.add(helppane,BorderLayout.WEST);
        helplabel.add(helpbg, BorderLayout.EAST);
        helplabel.pack();
        helplabel.setResizable(true);
        helplabel.setVisible(true);
    }
    
    //Method for adding info to the lost pieces table.
    public void lostpieceTableW() {
        String res = "";
        for (int i = 0; i < counterS.length; i++) {
            res += ": " + counterS[i] + "\n";
        }
        lostPieceW.setText(res);
    }

    public void lostpieceTableB() {
        String res = "";
        for (int i = 0; i < counterH.length; i++) {
            res += ": " + counterH[i] + "\n";
        }
        lostPieceB.setText(res);
    }
    //A reset method for the 'New Game' option in the menubar.

    public void reset() {
        remove(chess);
        remove(scrollpane);
        remove(scrollpane2);
        remove(background);
        counterH = new int[6];
        counterS = new int[6];
        lostpieceTableW();
        lostpieceTableB();
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
        lostPieceWLabel.setIcon(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceWNormal.png")));
        lostPieceBLabel.setIcon(new ImageIcon(getClass().getResource("/Accessories/Pictures/LostPieceBNormal.png")));
        repaint();
        setVisible(true);
    }
    
    public void developers(){
        JLabel devpicture = new JLabel(new ImageIcon(getClass().getResource("/Accessories/Pictures/Developers.png")));
        JFrame devlabel = new JFrame();
        devlabel.add(devpicture);
        devlabel.pack();
        devlabel.setVisible(true);
    }
    //Settings for the log and lost pieces table.

    public void settings() {
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
        scrollpane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollpane2.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
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
    //Adding constraints to the different components, determining their positions.

    public void setConstraints() {
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

    public void save(String title, int index) {
        PieceLabel[] table = new PieceLabel[64];
        for (int i = 0; i < table.length; i++) {
            if (chess.getPiece(i) instanceof PieceLabel) {
                table[i] = (PieceLabel) chess.getPiece(i);
            }
        }
        SaveGame save = new SaveGame(title, chess.getTurn(), timerH.getTime(), timerS.getTime(), counterH, counterS, chess.getWhiteLog(), chess.getBlackLog(), table, chess.getPieceTable());
        savegames[index] = save;
    }

    public void load(int index) {
        chess.loadGame(savegames[index].getTable(), savegames[index].getTurn(), savegames[index].getLogW(), savegames[index].getLogB(), savegames[index].getPieces());
        timerH.setTime(savegames[index].getTimerW());
        timerS.setTime(savegames[index].getTimerB());
        timerH.pause();
        timerS.pause();
        counterH = savegames[index].getCounterW();
        counterS = savegames[index].getCounterB();
        lostpieceTableW();
        lostpieceTableB();
        textarea.setText(chess.getWhiteLog());
        textarea2.setText(chess.getBlackLog());
        if (chess.getTurn() % 2 == 0) {
            blackgif.setVisible(false);
            whitegif.setVisible(true);
        } else {
            blackgif.setVisible(true);
            whitegif.setVisible(false);
        }
    }
    //A method that changes the GUI based on movement.
    ChessListener chessL = new ChessListener() {

        public void chessReceived(ChessEvent event) {
            if (event.team() == 1) {
                if (event.piece() != -1) {
                    counterH[event.piece()]++;
                }
                timerH.resume();
                timerS.pause();
                textarea.setText(chess.getWhiteLog());
                lostpieceTableB();
                whitegif.setVisible(false);
                blackgif.setVisible(true);
            } else if (event.team() == 2) {
                if (event.piece() != -1) {
                    counterS[event.piece()]++;
                }
                timerH.pause();
                timerS.resume();
                textarea2.setText(chess.getBlackLog());
                lostpieceTableW();
                blackgif.setVisible(false);
                whitegif.setVisible(true);
            }
        }
    };

    public void saveGame() {
        JButton button1 = new JButton("blank");
        try {
            button1 = new JButton(savegames[0].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button2 = new JButton("blank");
        try {
            button2 = new JButton(savegames[1].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button3 = new JButton("blank");
        try {
            button3 = new JButton(savegames[2].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button4 = new JButton("blank");
        try {
            button4 = new JButton(savegames[3].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button5 = new JButton("blank");
        try {
            button5 = new JButton(savegames[4].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button6 = new JButton("blank");
        try {
            button6 = new JButton(savegames[5].getTitle());
        } catch (NullPointerException npe) {
        }

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                String a = showInputDialog("Name: ");
                if (a == null || a.equals("")) {
                    JOptionPane.getRootFrame().dispose();
                } else {
                    save(a, 0);
                    try {
                        serialize();
                    } catch (IOException ioe) {
                    }
                }
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                String a = showInputDialog("Name: ");
                if (a == null || a.equals("")) {
                    JOptionPane.getRootFrame().dispose();
                } else {
                    save(a, 1);
                    try {
                        serialize();
                    } catch (IOException ioe) {
                    }
                }
            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                String a = showInputDialog("Name: ");
                if (a == null || a.equals("")) {
                    JOptionPane.getRootFrame().dispose();
                } else {
                    save(a, 2);
                    try {
                        serialize();
                    } catch (IOException ioe) {
                    }
                }
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                String a = showInputDialog("Name: ");
                if (a == null || a.equals("")) {
                    JOptionPane.getRootFrame().dispose();
                } else {
                    save(a, 3);
                    try {
                        serialize();
                    } catch (IOException ioe) {
                    }
                }
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                String a = showInputDialog("Name: ");
                if (a == null || a.equals("")) {
                    JOptionPane.getRootFrame().dispose();
                } else {
                    save(a, 4);
                    try {
                        serialize();
                    } catch (IOException ioe) {
                    }
                }
            }
        });
        button6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                String a = showInputDialog("Name: ");
                if (a == null || a.equals("")) {
                    JOptionPane.getRootFrame().dispose();
                } else {
                    save(a, 5);
                    try {
                        serialize();
                    } catch (IOException ioe) {
                    }
                }
            }
        });
    
        Object[] group = {button1, button2, button3, button4, button5, button6};
        showConfirmDialog(null, group, "Save", DEFAULT_OPTION, PLAIN_MESSAGE);
    }

    public void loadGame() {
        JButton button1 = new JButton("blank");
        try {
            button1 = new JButton(savegames[0].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button2 = new JButton("blank");
        try {
            button2 = new JButton(savegames[1].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button3 = new JButton("blank");
        try {
            button3 = new JButton(savegames[2].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button4 = new JButton("blank");
        try {
            button4 = new JButton(savegames[3].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button5 = new JButton("blank");
        try {
            button5 = new JButton(savegames[4].getTitle());
        } catch (NullPointerException npe) {
        }
        JButton button6 = new JButton("blank");
        try {
            button6 = new JButton(savegames[5].getTitle());
        } catch (NullPointerException npe) {
        }

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    load(0);
                    JOptionPane.getRootFrame().dispose();
                } catch (NullPointerException np) {
                    System.out.println("NullPointer load");
                }
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    load(1);
                    JOptionPane.getRootFrame().dispose();
                } catch (NullPointerException np) {
                }
            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    load(2);
                    JOptionPane.getRootFrame().dispose();
                } catch (NullPointerException np) {
                }
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    load(3);
                    JOptionPane.getRootFrame().dispose();
                } catch (NullPointerException np) {
                }
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    load(4);
                    JOptionPane.getRootFrame().dispose();
                } catch (NullPointerException np) {
                }
            }
        });

        button6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    load(5);
                    JOptionPane.getRootFrame().dispose();
                } catch (NullPointerException np) {
                }
            }
        });

        Object[] group = {button1, button2, button3, button4, button5, button6};
        showConfirmDialog(null, group, "Load", DEFAULT_OPTION, PLAIN_MESSAGE);
    }

    public void serialize() throws IOException {
        try {
            FileOutputStream utstrøm = new FileOutputStream("save.ser");
            ObjectOutputStream ut = new ObjectOutputStream(utstrøm);
            ut.writeObject(savegames);
            ut.close();
        } catch (EOFException eof) {
        }
    }

    public void fromSerialized() throws IOException {
        FileInputStream innstrøm = new FileInputStream("save.ser");
        ObjectInputStream inn = new ObjectInputStream(innstrøm);
        try {
            Object tab = inn.readObject();
            savegames = (SaveGame[]) tab;
        } catch (EOFException eof) {
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException cnfe) {
        }
        inn.close();
    }
}
