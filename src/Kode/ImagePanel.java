/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class ImagePanel extends JPanel {

    public ImagePanel() {
        setOpaque(false);
        setLayout(new FlowLayout());
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("src/Kode/Bilder/brett.png");
        ImagePanel c = new ImagePanel();
        myFrame.add(c);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 600);
        myFrame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {              //IT DEPEND ON YOUR PICTURE AND PUT IT'S LOCATION IN  
        Image a = Toolkit.getDefaultToolkit().getImage("src/Kode/Bilder/brett.png");
        g.drawImage(a, 0, 0, getSize().width, getSize().height, this);
        super.paint(g);
    }
}