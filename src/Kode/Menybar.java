package Kode;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

class Menybar extends JMenuBar {
public Menybar(){
    //Lager Menybaren
    JMenu file = new JMenu("Fil");
    JMenu settings = new JMenu("Innstillinger");
    JMenu credits = new JMenu ("Credits");
    JMenu help = new JMenu ("Hjelp");
    add(file);
    add(settings);
    add(credits);
    add(help);
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
    Nyttspill.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        
        }
    });
    Avslutt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        System.exit(0);
       } 
    });
    Utviklere.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        
        }
    });
}

}
