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
    Timer timerS;
    Timer timerH;
    Logg logg = new Logg();
    JTextArea textarea = new JTextArea(5, 30);
    JScrollPane scrollpane = new JScrollPane(textarea);
    JLayeredPane layeredpane;
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
                    textarea.setText(sjakk.getSvartLogg());
                } 
            }
        };

    public GUI(String tittel) {
        //Ramme
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle(tittel);
        setLayout(new BorderLayout());
        setJMenuBar(menuBar);
        sjakk = new Sjakk();
        sjakk.addSjakkListener(sjakkL);
        timerS = new Timer();
        timerH = new Timer();
        scrollpane = new JScrollPane(textarea);
        add(sjakk);
        menuBar.add(timerS);
        menuBar.add(timerH);
        add(scrollpane, BorderLayout.EAST);

        //Menybar
        JMenu file = new JMenu("Fil");
        JMenu settings = new JMenu("Innstillinger");
        JMenu credits = new JMenu("Credits");
        JMenu help = new JMenu("Hjelp");
        menuBar.add(file);
        menuBar.add(settings);
        menuBar.add(credits);
        menuBar.add(help);
        menuBar.add(timerS);
        menuBar.add(timerH);

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
        textarea.setText("");


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
                textarea.setText("");
                add(sjakk);
                sjakk.addSjakkListener(sjakkL);
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
        


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
