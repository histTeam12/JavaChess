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

class Menybar {
public static JMenuBar createMenybar(){
    //Lager Menybaren
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("Fil");
    JMenu Settings = new JMenu("Innstillinger");
    JMenu Credits = new JMenu ("Credits");
    JMenu Help = new JMenu ("Hjelp");
    menuBar.add(file);
    menuBar.add(Settings);
    menuBar.add(Credits);
    menuBar.add(Help);
    //Lager knapper til Filmenyen
    JMenuItem Item1 = new JMenuItem("Nytt Spill");
    JMenuItem Item2 = new JMenuItem("Avslutt");
    file.add(Item1);
    file.add(Item2);
    
    JRadioButtonMenuItem Meme = new JRadioButtonMenuItem("Meme-sjakk");
    JRadioButtonMenuItem Vanlig = new JRadioButtonMenuItem("Vanlig sjakk");
    ButtonGroup bg = new ButtonGroup();
    bg.add(Meme);
    bg.add(Vanlig);
    Settings.add(Meme);
    Settings.add(Vanlig);
    
    
    
    
    return menuBar;
}

}
