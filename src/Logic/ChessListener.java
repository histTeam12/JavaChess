package Logic;

/**
 * Interface that connects the chess events to other classes
 * @author andreaskalstad
 */
public interface ChessListener {

    /**
     * Receives a chess event
     * @param event
     */
    public void chessReceived(ChessEvent event);
}