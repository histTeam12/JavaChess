/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

class Menybar {
    private GUI gui;
public static JMenuBar createMenybar(){
    //Lager Menybaren
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("Fil");
    JMenu settings = new JMenu("Innstillinger");
    JMenu credits = new JMenu ("Credits");
    JMenu help = new JMenu ("Hjelp");
    menuBar.add(file);
    menuBar.add(settings);
    menuBar.add(credits);
    menuBar.add(help);
    //Lager knapper til Filmenyen
    JMenuItem Item1 = new JMenuItem("Nytt Spill", 
            new ImageIcon("src/Kode/Bilder/nyttspill1.png"));
                Item1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
    JMenuItem Item2 = new JMenuItem("Avslutt", 
            new ImageIcon("src/Kode/Bilder/avslutt.png"));
    JRadioButtonMenuItem Meme = new JRadioButtonMenuItem("Meme-sjakk");
    JRadioButtonMenuItem Vanlig = new JRadioButtonMenuItem("Vanlig sjakk");
    ButtonGroup bg = new ButtonGroup();
    bg.add(Meme);
    bg.add(Vanlig);
    file.add(Item1);
    file.add(Item2);
    settings.add(Meme);
    settings.add(Vanlig);
    Item1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
        //Her legges kommandoen for å restarte spillet.
        }
    });
    Item2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent arg0){
        System.exit(0);
       } 
    });
    
    
    return menuBar;
}

}
