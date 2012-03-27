package Kode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.SpringLayout;
import java.awt.Container;
import javax.swing.JLabel;

public class GUI extends JFrame {

    //Alle komponenter
    private BrettRute bakgrunn = new BrettRute("src/Kode/Bilder/ramme.png");
    private JMenuBar menuBar = new JMenuBar();
    private Sjakk sjakk = new Sjakk();
    private Timer timerS;
    private Timer timerH;
    private JMenu blank = new JMenu("     ");
    private Logg logg = new Logg();
    private JTextArea textarea = new JTextArea(10, 12);
    private JTextArea textarea2 = new JTextArea(10, 12);
    private JScrollPane scrollpane = new JScrollPane(textarea);
    private JScrollPane scrollpane2 = new JScrollPane(textarea2);
    private JLayeredPane layeredpane;
    private Container contentPane = getContentPane();
    private SpringLayout layout = new SpringLayout();
    SjakkListener sjakkL = new SjakkListener() {

        @Override
        public void sjakkReceived(SjakkEvent event) {
            if (event.lag() == 1) {
                timerS.resume();
                timerH.pause();
                textarea.setText(sjakk.getHvitLogg());
            } else if (event.lag() == 2) {
                timerS.pause();
                timerH.resume();
                textarea2.setText(sjakk.getSvartLogg());
            }
        }
    };

    public GUI(String tittel) {
        //Ramme
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle(tittel);
        contentPane.setLayout(layout);
        setJMenuBar(menuBar);
        sjakk = new Sjakk();
        sjakk.addSjakkListener(sjakkL);
        timerS = new Timer();
        timerH = new Timer();
        scrollpane = new JScrollPane(textarea);
        scrollpane2 = new JScrollPane(textarea2);
        menuBar.add(timerS);
        menuBar.add(timerH);
        add(scrollpane);
        add(sjakk);
        add(scrollpane2);
        layout.putConstraint(SpringLayout.WEST, scrollpane, 0, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, sjakk, 152, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, scrollpane2, 755, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, bakgrunn, 0, SpringLayout.WEST, contentPane);
        

        //Menybar
        JMenu file = new JMenu("Fil");
        JMenu settings = new JMenu("Innstillinger");
        JMenu credits = new JMenu("Credits");
        JMenu help = new JMenu("Hjelp");
        menuBar.add(file);
        menuBar.add(settings);
        menuBar.add(credits);
        menuBar.add(help);
        menuBar.add(blank);
        menuBar.add(timerS);
        menuBar.add(blank);
        menuBar.add(timerH);

        //Knapper til menybar
        JMenuItem Nyttspill = new JMenuItem("Nytt Spill", new ImageIcon("src/Kode/Bilder/nyttspill1.png"));
        Nyttspill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
        JMenuItem Avslutt = new JMenuItem("Avslutt", new ImageIcon("src/Kode/Bilder/avslutt.png"));
        JMenuItem Save = new JMenuItem("Lagre spill", new ImageIcon("src/Kode/Bilder/mac.gif"));
        JMenuItem Load = new JMenuItem("Åpne spill", new ImageIcon("src/Kode/Bilder/Load Icon.jpg"));
        JRadioButtonMenuItem Meme = new JRadioButtonMenuItem("Meme-sjakk");
        JRadioButtonMenuItem Vanlig = new JRadioButtonMenuItem("Vanlig sjakk");
        JMenuItem Utviklere = new JMenuItem("Utviklere");
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
        textarea.setEditable(false);
        textarea2.setEditable(false);
        scrollpane.setSize(100, 100);
        scrollpane2.setSize(100, 100);


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
                JOptionPane.showMessageDialog(null, "Copyright © 2003–2011 Andreas Henrik Michael Lars. \nAll rights reserved.", "MemeChess",3, new ImageIcon("src/Kode/Bilder/trollfaceW.png"));
            }
        });
         Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sjakk.tilTabell();
            }
        });
         Load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sjakk.fraTabell();
                sjakk.refresh();
            }
        });
         Meme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sjakk.endreUI(1);
            }
        });
         Vanlig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sjakk.endreUI(2);
            }
        });



        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void reset(){
        remove(sjakk);
        remove(scrollpane);
        remove(scrollpane2);
        textarea.setText("");
        textarea2.setText("");
        repaint();
        menuBar.remove(timerS);
        menuBar.remove(timerH);
        sjakk = new Sjakk();
        timerS = new Timer();
        timerH = new Timer();
        scrollpane = new JScrollPane(textarea);
        scrollpane2 = new JScrollPane(textarea2);
        add(sjakk);
        sjakk.addSjakkListener(sjakkL);
        menuBar.add(blank);
        menuBar.add(timerS);
        menuBar.add(blank);
        menuBar.add(timerH);
        add(scrollpane, SpringLayout.WEST);
        add(scrollpane2, SpringLayout.EAST);
        layout.putConstraint(SpringLayout.WEST, scrollpane, 0, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, sjakk, 152, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, scrollpane2, 755, SpringLayout.WEST, contentPane);
        setVisible(true);
    }
}
