package Main;

import Logic.Chess;
import Logic.Chess;
import Logic.ChessEvent;
import Logic.ChessEvent;
import Logic.ChessListener;
import Logic.ChessListener;
import java.awt.*;
import java.awt.event.*;

public class ChessAction implements ChessListener {

    Chess ttp;
    public boolean ready;

    public ChessAction(Chess p) {
        ttp = p;
        ready = ttp.c == 0;
    }
    @Override
    public void chessReceived(ChessEvent event) {
        if (ready) {
            ttp.refresh();
        }
        ready = false;
    }
}