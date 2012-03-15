package Kode;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
    private JButton knapp = new JButton("LOOOL");
    private JButton knapp2 = new JButton("LOOOL");
    private JButton knapp3 = new JButton("LOOOL");
    private JButton knapp4 = new JButton("LOOOL");
    
    public GUI(String tittel) {
        setTitle(tittel);
        setLayout(new BorderLayout());
        JFrame frame = new JFrame();
        JInternalFrame a = new Sjakk();
        frame.add(a);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(knapp2, BorderLayout.SOUTH);
        frame.add(knapp3, BorderLayout.WEST);
        frame.add(knapp4, BorderLayout.EAST);
        frame.add(knapp, BorderLayout.NORTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public static void main(String[] args){
        GUI gui = new GUI("Sjakk");
        
    }
}
