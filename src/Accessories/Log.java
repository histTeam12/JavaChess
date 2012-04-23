package Accessories;

import java.util.ArrayList;

/**
 * 
 * @author andreaskalstad
 */
public class Log {

    ArrayList log = new ArrayList();

    //Method for adding text to the log arraylist
    /**
     * 
     * @param text
     */
    public void addToLog(String text) {
        log.add(text);
    }

    //Method for clearing the log arraylist
    /**
     * 
     */
    public void clearLog() {
        log.removeAll(log);
    }

    //toString method so we get the text in the right format
    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < log.size(); i++) {
            if (i == log.size() - 1) {
                res += log.get(i);
            } else {
                res += log.get(i) + "\n";
            }
        }
        return res;
    }
}
