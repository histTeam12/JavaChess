package Code;
class Main {
public static void main(String[] args){
        GUI gui = new GUI("Chess"); 
        gui.setSize(1100, 720); 
        gui.setLocationRelativeTo(null); //Centralizing the window in the screen.
        gui.setResizable(false); //Unable to drag the edges of the window.
    }
}
