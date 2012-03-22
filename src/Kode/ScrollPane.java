package øving.pkg8;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class ScrollPane {

public static JScrollPane CreatScrollPane(){
    JTextArea textArea = new JTextArea(5, 5);
    JScrollPane liste = new JScrollPane(textArea);
    liste.setPreferredSize(new Dimension(200, 100));
    liste.createVerticalScrollBar();
    
    return liste;
}
}
