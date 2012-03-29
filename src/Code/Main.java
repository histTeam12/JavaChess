package Code;
class Main {
public static void main(String[] args){
        GUI gui = new GUI("Chess"); //Creating the window.
        gui.setSize(1100, 720); //Size of the total window.
        gui.setLocationRelativeTo(null); //Centralizing the window in the screen.
        gui.setResizable(false); //Unable to drag the edges of the window.
    }
}
