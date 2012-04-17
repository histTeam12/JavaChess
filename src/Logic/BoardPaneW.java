/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class BoardPaneW extends JPanel {
    private String imgpath;

    public BoardPaneW(String imgpath) {
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