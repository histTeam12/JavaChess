/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;

class Menybar {
public static JMenuBar createMenybar(){
    JMenuBar menuBar = new JMenuBar();
    JMenu File = new JMenu("Fil");
    JMenu Settings = new JMenu("Innstillinger");
    JMenu Credits = new JMenu ("Credits");
    JMenu Help = new JMenu ("Hjelp");
    menuBar.add(File);
    menuBar.add(Settings);
    menuBar.add(Credits);
    menuBar.add(Help);
    JMenuItem Item1 = new JMenuItem("Nytt Spill");
    JMenuItem Item2 = new JMenuItem("Avslutt");
    File.add(Item1);
    File.add(Item2);
    
    return menuBar;
}

}
