package Kode;

import java.util.TimerTask;
import javax.swing.JLabel;

class Timer extends JLabel{
    private int s;
    private int m;
    private int h;
    
    public Timer(){
        
        start();
    }
    private void reset(){
        s = 0;
        m = 0;
        h = 0;
    }
    public void start(){
        reset();
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                
                if (s <= 59) s++;                                                                
                if (s == 60 && m < 59) m++;                
                if (s == 60 && m == 59) h++;
                if (s == 60 && m == 60 && h == 60) h = 0;
                if (s == 60 && m == 59) m = 0;
                if (s == 60) s =0;                    
                
                setText( h+":"+m+":"+s );
            }
        }, 0, 1000 );
    }
}
