package Kode;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

    JFrame frame = new JFrame();
    JMenuBar menuBar = new JMenuBar();
    Sjakk sjakk = new Sjakk();
    Timer timer = new Timer();
    Logg logg = new Logg();
    JScrollPane scrollpane = ScrollPane.CreateScrollPane();
    
    public GUI(String tittel) {
        setTitle(tittel);
        setLayout(new BorderLayout());
        JMenu file = new JMenu("Fil");
        JMenu settings = new JMenu("Innstillinger");
        JMenu credits = new JMenu("Credits");
        JMenu help = new JMenu("Hjelp");
        JButton knapp = new JButton("Pause");
        JButton knapp2 = new JButton("Fortsett");
        menuBar.add(file);
        menuBar.add(settings);
        menuBar.add(credits);
        menuBar.add(help);
        menuBar.add(timer);
        menuBar.add(knapp);
        menuBar.add(knapp2);
        
        frame.setJMenuBar(menuBar);
        frame.add(sjakk);
        frame.add(scrollpane, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Lager knapper til Filmenyen
        JMenuItem Nyttspill = new JMenuItem("Nytt Spill",
                new ImageIcon("src/Kode/Bilder/nyttspill1.png"));
        Nyttspill.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
        JMenuItem Avslutt = new JMenuItem("Avslutt",
                new ImageIcon("src/Kode/Bilder/avslutt.png"));
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
        Nyttspill.addActionListener(new ActionListener() {
            
        //Lyttere til knappene i menyen

            public void actionPerformed(ActionEvent e) {
                frame.remove(sjakk);
                frame.remove(timer);
                frame.remove(scrollpane);
                frame.repaint();
                sjakk = new Sjakk();
                timer = new Timer();
                scrollpane = ScrollPane.CreateScrollPane();
                frame.add(sjakk);
                frame.add(timer, BorderLayout.WEST);
                frame.add(scrollpane, BorderLayout.EAST);
                frame.setVisible(true);
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
                timer.pause();
            }
        });
        knapp2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                timer.resume();
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
