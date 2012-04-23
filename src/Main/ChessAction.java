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
 * Creates and receives chess actions which indicates when the LAN clients can send and receive information between each other
 * @author andreaskalstad
 */
public class ChessAction implements ChessListener {

    Chess ttp;
    public boolean ready;

    /**
     * Constructs a chess action
     * @param p
     * Chess object
     */
    public ChessAction(Chess p) {
        ttp = p;
        ready = ttp.getTurn()%2 == 0;
    }
    /**
     * Receives a chess event
     * @param event
     * Chess event object
     */
    @Override
    public void chessReceived(ChessEvent event) {
        if (ready) {
            ttp.refresh();
        }
        ready = false;
    }
}