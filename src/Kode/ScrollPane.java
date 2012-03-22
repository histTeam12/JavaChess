package Kode;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class ScrollPane {

public static JScrollPane CreateScrollPane(){
    JTextArea textArea = new JTextArea(5, 5);
    JScrollPane liste = new JScrollPane(textArea);
    liste.setPreferredSize(new Dimension(200, 100));
    liste.createVerticalScrollBar();
    
    return liste;
}
//public static JScrollPane CreateCreditsPane(){
  //  String tekst = "Hei";
    //JScrollPane liste = new JScrollPane(tekst);
    //liste.setPreferredSize(new Dimension(200,100));
}

