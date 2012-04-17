package Accessories;

import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;
import javax.swing.JLabel;

class Timer extends JLabel {
    //Creating an object variable for every digit in the timer.

    public int s;
    public int m;
    public int h;
    public int s2;
    public int m2;
    public int h2;
    public String text = "";
    public boolean pause = true;

    public Timer() {
        start();
        //Changing the font and color.
        setFont(new Font("SansSerif", 4, 20));
        setForeground(Color.white);
    }

    public int[] getTime() {
        int[] time = new int[6];
        time[0] = s;
        time[1] = m;
        time[2] = h;
        time[3] = s2;
        time[4] = m2;
        time[5] = h2;

        return time;
    }
    public void setTime(int[] time){
        s = time[0];
        m = time[1];
        h = time[2];
        s2 = time[3];
        m2 = time[4];
        h2 = time[5];
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
