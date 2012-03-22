package Kode;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class ScrollPane {
public static JScrollPane CreateScrollPane(){
    JTextArea textArea = new JTextArea("Hello");
    textArea.setEditable(false);
    JScrollPane liste = new JScrollPane(textArea);
    liste.setPreferredSize(new Dimension(200, 100));
    liste.createVerticalScrollBar();
    
    return liste;
}
}

