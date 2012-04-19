package Accessories;

import java.util.ArrayList;

public class Log {

    ArrayList log = new ArrayList();

    public void addToLog(String text) {
        log.add(text);
    }

    public void clearLog() {
        log.removeAll(log);
    }

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
