package Accessories;

import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 * Creates a timer which is able to run, pause, resume, reset
 * @author andreaskalstad
 */
public class Timer extends JLabel {
    //Creating an object variable for every digit in the timer.
    private int s;
    private int m;
    private int h;
    private int s2;
    private int m2;
    private int h2;
    private String text = "";
    private boolean pause = true;

    /**
     * Constructs a timer which immediately starts
     */
    public Timer() {
        start();
        setFont(new Font("SansSerif", 4, 20));
        setForeground(Color.white);
    }

    /**
     * Returns an integer array of 6 with the different digits
     * @return
     * Integer array with digits
     */
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
    /**
     * Sets the timers digits
     * @param time
     * Integer array with digits
     */
    public void setTime(int[] time){
        s = time[0];
        m = time[1];
        h = time[2];
        s2 = time[3];
        m2 = time[4];
        h2 = time[5];
    }
    
    /**
     * Resets the timer
     */
    public void reset() {
        s = 0;
        m = 0;
        h = 0;
        s2 = 0;
        m2 = 0;
        h2 = 0;
        pause();
    }
    
    /**
     * Changes the text
     * @param text1
     * a text string
     */
    public void changeText(String text1) {
        text = text1;
    }

    /**
     * Pauses the timer
     */
    public void pause() {
        pause = true;
    }
    
    /**
     * Resumes the timer
     */
    public void resume() {
        pause = false;
    }
    
    /**
     * Starts the timer
     */
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
