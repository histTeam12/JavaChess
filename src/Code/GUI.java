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
import static javax.swing.JOptionPane.*;

public class GUI extends JFrame {

    //OBJECT VARIABLES
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/Pictures/Background.png")));
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
    private JLabel lostPieceWLabel = new JLabel(new ImageIcon(getClass().getResource("/Pictures/LostPieceWNormal.png")));
    private JLabel lostPieceBLabel = new JLabel(new ImageIcon(getClass().getResource("/Pictures/LostPieceBNormal.png")));
    private JLabel whitegif = new JLabel(new ImageIcon(getClass().getResource("/Pictures/WhiteGIF.gif")));
    private JLabel blackgif = new JLabel(new ImageIcon(getClass().getResource("/Pictures/BlackGIF.gif")));
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
        JMenuItem Newgame = new JMenuItem("New Game", new ImageIcon(getClass().getResource("/Pictures/newgame.png")));
        Newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
        JMenuItem Exit = new JMenuItem("Exit", new ImageIcon(getClass().getResource("/Pictures/Exit.png")));
        JMenuItem Save = new JMenuItem("Save game", new ImageIcon(getClass().getResource("/Pictures/mac.png")));
        JMenuItem Load = new JMenuItem("Open game", new ImageIcon(getClass().getResource("/Pictures/LoadIcon.png")));
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        Load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        JMenuItem Meme = new JMenuItem("Meme pieces");
        JMenuItem Regular = new JMenuItem("Regular pieces");
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
                JOptionPane.showMessageDialog(null, "Copyright © 2012 Andreas Kalstad, Henrik Reitan, Michael Olsen, Lars Kristoffer Sagmo. \nAll rights reserved.", "MemeChess", 3, new ImageIcon(getClass().getResource("/Pictures/TrollfaceW.png")));
            }
        });
        Save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });
        Load.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                loadGame();
            }
        });
        Meme.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.changeUI(1);
                lostPieceWLabel.setIcon(new ImageIcon(getClass().getResource("/Pictures/LostPieceWMeme.png")));
                lostPieceBLabel.setIcon(new ImageIcon(getClass().getResource("/Pictures/LostPieceBMeme.png")));
            }
        });
        Regular.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chess.changeUI(2);
                lostPieceWLabel.setIcon(new ImageIcon(getClass().getResource("/Pictures/LostPieceWNormal.png")));
                lostPieceBLabel.setIcon(new ImageIcon(getClass().getResource("/Pictures/LostPieceBNormal.png")));
            }
        });
        //Finishing the constructor by packing and setting visible.
        pack();
        setVisible(true);
    }

    //METHODS
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
        lostPieceWLabel.setIcon(new ImageIcon(getClass().getResource("/Pictures/LostPieceWNormal.png")));
        lostPieceBLabel.setIcon(new ImageIcon(getClass().getResource("/Pictures/LostPieceBNormal.png")));
        repaint();
        setVisible(true);
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
        Component[] table = new Component[64];
        for (int i = 0; i < table.length; i++) {
            table[i] = chess.getPiece(i);
        }
        SaveGame save = new SaveGame(title, chess.getTurn(), timerH.getTime(), timerS.getTime(), counterH, counterS, chess.getWhiteLog(), chess.getBlackLog(), table);
        savegames[index] = save;
    }

    public void load(int index) {
        chess.loadGame(savegames[index].getTable(), savegames[index].getTurn(), savegames[index].getLogW(), savegames[index].getLogB());
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
                save(showInputDialog("Name:"), 0);
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                save(showInputDialog("Name:"), 1);
            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                save(showInputDialog("Name:"), 2);
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                save(showInputDialog("Name:"), 3);
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                save(showInputDialog("Name:"), 4);
            }
        });
        button6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.getRootFrame().dispose();
                save(showInputDialog("Name:"), 5);
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
}
