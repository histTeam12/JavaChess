/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.JPanel;

public class BoardPane extends JPanel {
    private String imgpath;

    public BoardPane(String imgpath) {
        setOpaque(false);
        this.imgpath = imgpath;
        
    }
    
    public void setIcon(String path){
        imgpath = path;
    }

    @Override
    public void paint(Graphics g) {
        Image a = Toolkit.getDefaultToolkit().getImage(imgpath);
        g.drawImage(a, 0, 0, getSize().width, getSize().height, this);
        super.paint(g);
    }
}