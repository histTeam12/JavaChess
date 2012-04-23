package Accessories;

import java.util.ArrayList;

/**
 * A log of which movements the players have done
 * @author andreaskalstad
 */
public class Log {

    ArrayList log = new ArrayList();

    //Method for adding text to the log arraylist
    /**
     * Adds strings of text to the log array
     * @param text
     * String of movements
     */
    public void addToLog(String text) {
        log.add(text);
    }

    //Method for clearing the log arraylist
    /**
     * Clears out the log array
     */
    public void clearLog() {
        log.removeAll(log);
    }

    /**
     * Overrides the toString method so we get the text in the right format
     * @return
     * Returns a string in right format
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
