/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class BrettRuteH extends JPanel {
    private String imgpath;

    public BrettRuteH(String imgpath) {
        setOpaque(false);
        this.imgpath = imgpath;
    }

    @Override
    public void paint(Graphics g) {
        Image a = Toolkit.getDefaultToolkit().getImage(imgpath);
        g.drawImage(a, 0, 0, getSize().width, getSize().height, this);
        super.paint(g);
    }
}