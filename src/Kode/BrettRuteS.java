/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class BrettRuteS extends JPanel {

    public BrettRuteS() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
        Image a = Toolkit.getDefaultToolkit().getImage("src/Kode/Bilder/Svartfelt.png");
        g.drawImage(a, 0, 0, getSize().width, getSize().height, this);
        super.paint(g);
    }
}