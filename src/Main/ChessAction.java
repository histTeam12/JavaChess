package Main;

import Logic.Chess;
import Logic.Chess;
import Logic.ChessEvent;
import Logic.ChessEvent;
import Logic.ChessListener;
import Logic.ChessListener;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author andreaskalstad
 */
public class ChessAction implements ChessListener {

    Chess ttp;
    /**
     * 
     */
    public boolean ready;

    /**
     * 
     * @param p
     */
    public ChessAction(Chess p) {
        ttp = p;
        ready = ttp.getTurn()%2 == 0;
    }
    /**
     * 
     * @param event
     */
    @Override
    public void chessReceived(ChessEvent event) {
        if (ready) {
            ttp.refresh();
        }
        ready = false;
    }
}