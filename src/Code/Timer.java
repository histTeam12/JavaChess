package Code;

import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;
import javax.swing.JLabel;

class Timer extends JLabel {
    //Creating an object variable for every digit in the timer.
    private int s;
    private int m;
    private int h;
    private int s2;
    private int m2;
    private int h2;
    private String text = "";
    private boolean pause = true;

    public Timer() {
        start();
        //Changing the font and color.
        setFont(new Font("SansSerif", 4, 20));
        setForeground(Color.white);
    }
    //Method for resetting the timer.
    public void reset() {
        s = 0;
        m = 0;
        h = 0;
        s2 = 0;
        m2 = 0;
        h2 = 0;
        pause();
    }
    //Helping method for the run() method.
    public void setTekst(String text1) {
        text = text1;
    }
    //Pause
    public void pause() {
        pause = true;
    }
    //Resume
    public void resume() {
        pause = false;
    }
    //Start with the run() method inside it.
    public void start() {
        reset();
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            //Method for manually adding to the variables.
            public void run() {
                if (!pause) {
                    if (s <= 10) {
                        s++;
                    }
                    if (s == 10) {
                        s2++;
                    }
                    if (h == 10) {
                        h2++;
                        h = 0;
                    }
                    if (s == 10 && s2 == 6 && m < 9) {
                        m++;
                        s2 = 0;
                    }
                    if (m == 9 && s2 == 6 && s == 10) {
                        m2++;
                        m = 0;
                    }
                    if (s == 10 && s2 == 6 && m2 == 6) {
                        h++;
                        m2 = 0;
                    }
                    if (s == 10 && m == 10) {
                        m = 0;
                    }
                    if (s == 9 && s2 == 6) {
                        s2 = 0;
                    }
                    if (s == 10) {
                        s = 0;
                    }
                }
                //Finally adding the variables to the shown timer.
                setText(text + h2 + h + ":" + m2 + m + ":" + s2 + s);
            }
        }, 0, 1000);
    }
}
