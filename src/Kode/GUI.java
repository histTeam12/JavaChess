package Kode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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

public class GUI extends JFrame {

    //Alle komponenter
    BrettRute bakgrunn = new BrettRute("src/Kode/Bilder/ramme.png");
    JMenuBar menuBar = new JMenuBar();
    Sjakk sjakk = new Sjakk();
    Timer timerS = new Timer();
    Timer timerH = new Timer();
    Logg logg = new Logg();
    JTextArea textarea = new JTextArea(5, 30);
    JScrollPane scrollpane = new JScrollPane(textarea);
    JLayeredPane layeredpane;

    public GUI(String tittel) {
        //Ramme
        setVisible(true);
        setTitle(tittel);
        setLayout(new BorderLayout());
        setJMenuBar(menuBar);
        layeredpane = new JLayeredPane();
        getContentPane().add(layeredpane);
        layeredpane.setPreferredSize(new Dimension(700,700));

        layeredpane.add(bakgrunn, JLayeredPane.DEFAULT_LAYER);
        bakgrunn.setLayout(new GridLayout(8, 8));
        bakgrunn.setPreferredSize(new Dimension(700,700));
        bakgrunn.setBounds(0, 0, 700, 700);
        layeredpane = new JLayeredPane();
        getContentPane().add(layeredpane);
        layeredpane.setPreferredSize(new Dimension(700,700));
        layeredpane.add(bakgrunn, JLayeredPane.FRAME_CONTENT_LAYER);
        layeredpane.add(sjakk);
        layeredpane.add(scrollpane, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Menybar
        JMenu file = new JMenu("Fil");
        JMenu settings = new JMenu("Innstillinger");
        JMenu credits = new JMenu("Credits");
        JMenu help = new JMenu("Hjelp");
        JButton knapp = new JButton("Hvit");
        JButton knapp2 = new JButton("Svart");
        menuBar.add(file);
        menuBar.add(settings);
        menuBar.add(credits);
        menuBar.add(help);
        menuBar.add(timerS);
        menuBar.add(timerH);
        menuBar.add(knapp);
        menuBar.add(knapp2);

        //Knapper til menybar
        JMenuItem Nyttspill = new JMenuItem("Nytt Spill", new ImageIcon("src/Kode/Bilder/nyttspill1.png"));
        Nyttspill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
        JMenuItem Avslutt = new JMenuItem("Avslutt", new ImageIcon("src/Kode/Bilder/avslutt.png"));
        JRadioButtonMenuItem Meme = new JRadioButtonMenuItem("Meme-sjakk");
        JRadioButtonMenuItem Vanlig = new JRadioButtonMenuItem("Vanlig sjakk");
        JMenuItem Utviklere = new JMenuItem("Utviklere");
        ButtonGroup bg = new ButtonGroup();

        bg.add(Meme);
        bg.add(Vanlig);
        file.add(Nyttspill);
        file.add(Avslutt);
        settings.add(Meme);
        settings.add(Vanlig);
        credits.add(Utviklere);

        //Logg
        textarea.setEditable(false);
        textarea.setText("LOOOOL");


        //Lyttere
        Nyttspill.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                remove(sjakk);
                remove(scrollpane);
                repaint();
                menuBar.remove(timerS);
                menuBar.remove(timerH);
                sjakk = new Sjakk();
                timerS = new Timer();
                timerH = new Timer();
                scrollpane = new JScrollPane(textarea);
                add(sjakk);
                menuBar.add(timerS);
                menuBar.add(timerH);
                add(scrollpane, BorderLayout.EAST);
                setVisible(true);
            }
        });
        Avslutt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Utviklere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Andreas\n Henrik\n Michael\n Lars\n");
            }
        });
        knapp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timerS.pause();
                timerH.resume();
            }
        });
        knapp2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timerS.resume();
                timerH.pause();
            }
        });
//        sjakk.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                
//            }
//        });


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
