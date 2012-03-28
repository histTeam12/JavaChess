package Code;

import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;
import javax.swing.JLabel;

class Timer extends JLabel {

    private int s;
    private int m;
    private int h;
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
    }
    public void setTekst(String text){
        tekst = text;
    }

    public void pause() {
       pause = true;
    }
    public void resume(){
        pause = false;
    }

    public void start() {
        reset();
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (!pause) {

                    if (s <= 59) {
                        s++;
                    }
                    if (s == 60 && m < 59) {
                        m++;
                    }
                    if (s == 60 && m == 59) {
                        h++;
                    }
                    if (s == 60 && m == 60 && h == 60) {
                        h = 0;
                    }
                    if (s == 60 && m == 59) {
                        m = 0;
                    }
                    if (s == 60) {
                        s = 0;
                    }

                    
                }
                setText(tekst + h + ":" + m + ":" + s);
            }
        }, 0, 1000);
    }
}