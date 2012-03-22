package Kode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class GUI extends JFrame{
    private JLabel knapp = new JLabel(new ImageIcon("src/Kode/Bilder/north.png"));
    private JLabel knapp2 = new JLabel(new ImageIcon("src/Kode/Bilder/east.png"));
    private JLabel knapp3 = new JLabel(new ImageIcon("src/Kode/Bilder/west.png"));
    private JLabel knapp4 = new JLabel(new ImageIcon("src/Kode/Bilder/south.png"));
    JFrame frame = new JFrame();
    
    public GUI(String tittel) {
        setTitle(tittel);
        setLayout(new BorderLayout());
        JInternalFrame sjakk = new Sjakk();
        JScrollPane scrollpane = ScrollPane.CreatScrollPane();
        JMenuBar menuBar = Menybar.createMenybar();
        frame.add(scrollpane, BorderLayout.EAST);
        frame.setJMenuBar(menuBar);
        frame.add(sjakk);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        frame.add(knapp4, BorderLayout.SOUTH);
        frame.add(knapp3, BorderLayout.WEST);
        frame.add(knapp2, BorderLayout.EAST);
        frame.add(knapp, BorderLayout.NORTH);
        * 
        */
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        GUI gui = new GUI("Sjakk");
        gui.setSize(1280, 700);        
    }
}
