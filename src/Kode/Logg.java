package Kode;

import java.util.ArrayList;

public class Logg {

    ArrayList logg = new ArrayList();

    public void leggTilLogg(String tekst) {
        logg.add(tekst);
    }
    
    public void clearLogg(){
        logg.removeAll(logg);
    }
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < logg.size(); i++) {
            res += logg.get(i)+"\n";
        }
        return res;
    }
    
}
