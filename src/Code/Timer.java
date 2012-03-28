package Code;

import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;
import javax.swing.JLabel;

class Timer extends JLabel {

    private int s;
    private int m;
    private int h;
    private int s2;
    private int m2;
    private int h2;
    private String tekst = "";
    private boolean pause = true;

    public Timer() {
        start();
        setFont(new Font("SansSerif", 4, 20));
        setForeground(Color.white);
    }

    public void reset() {
        s = 0;
        m = 0;
        h = 0;
        s2 = 0;
        m2 = 0;
        h2 = 0;
        pause();
    }

    public void setTekst(String text) {
        tekst = text;
    }

    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
    }

    public void start() {
        reset();
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

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
                setText(tekst + h2 + h + ":" + m2 + m + ":" + s2 + s);
            }
        }, 0, 1000);
    }
}
