package Accessories;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class Rules {
    private JTextArea rules = new JTextArea();
    private String title1 = "Setup\n";
    private String text1 = "Chess is played on a square board of eight rows (called ranks \n"
    + "and denoted with numbers 1 to 8) and eight columns (called files and \n"
    + "denoted with letters a to h) of squares. The colors of the sixty- \n"
    +"four squares alternate and are referred to as light squares and\n"
    + "dark squares. The chessboard is placed with a light square at the \n"
    + "right-hand end of the rank nearest to each player, and the pieces \n"
    + "are set out as shown in the diagram, with each queen on its own \n"
    + "color.\n"
    + "The pieces are divided, by convention, into white and black sets. The\n"
    + "players are referred to as White and Black, and each begins the\n"
    + "game with sixteen pieces of the specified color. These consist of\n"
    + "one king, one queen, two rooks, two bishops, two knights, and eight\n"
    + "pawns.\n"
    + "\n";
    private String title2 = "Movement\n";
    private String text2 =
    "White always moves first. After the initial move, the players \n"
    + "alternately move one piece at a time (with the exception of \n"
    + "castling, when two pieces are moved). Pieces are moved to either an \n"
    + "unoccupied square or one occupied by an opponents piece, which is \n"
    + "captured and removed from play. With the sole exception of en \n"
    + "passant, all pieces capture opponent's pieces by moving to the \n"
    + "square that the opponents piece occupies. A player may not make any \n"
    + "move that would put or leave his king under attack. If the player to \n"
    + "move has no legal moves, the game is over; it is either a checkmate\n"
    + "if the king is under attack or a stalemate if the king is not.\n"
    + "Each chess piece has its own style of moving. In the diagrams, the\n "
    + "dots mark the squares where the piece can move if no other pieces\n "
    + "(including ones own piece) are on the squares between the pieces \n"
    + "initial position and its destination.\n"
    + "\n"
    + "The king moves one square in any direction. The king has also a \n"
    + "special move which is called castling and involves also moving a\n"
    + "rook.\n"
    + "\n"
    + "The rook can move any number of squares along any rank or file, but \n"
    + "may not leap over other pieces. Along with the king, the rook is\n"
    + "involved during the king's castling move.\n"
    + "\n"
    + "The bishop can move any number of squares diagonally, but may not \n"
    + "leap over other pieces.\n"
    + "\n"
    + "The queen combines the power of the rook and bishop and can move any \n"
    + "number of squares along rank, file, or diagonal, but it may not leap \n"
    + "over other pieces.\n"
    + "\n"
    + "The knight moves to any of the closest squares that are not on the \n"
    + "same rank, file, or diagonal, thus the move forms an L-shape: two\n "
    + "squares vertically and one square horizontally, or two squares \n"
    + "horizontally and one square vertically. The knight is the only piece \n"
    + "that can leap over other pieces.\n"
    + "\n"
    + "The pawn may move forward to the unoccupied square immediately in \n"
    + "front of it on the same file; or on its first move it may advance \n"
    + "two squares along the same file provided both squares are\n"
    + "unoccupied; or it may move to a square occupied by an opponents \n"
    + "piece which is diagonally in front of it on an adjacent file, \n"
    + "capturing that piece. The pawn has two special moves: the en passant \n"
    + "capture and pawn promotion.\n"
    + "\n";
    private String title3 = "Special moves \n\nPawns\n";
    private String text3 =       
    "Pawns can optionally move two squares forward instead of one on \n"
    + "their first move only. They capture diagonally, but they \n"
    + "cannot capture with their normal move. Pawns also are \n"
    + "involved in the special capture called en passant.\n"
    + "\n";
    private String title4 = "Castling\n";
    private String text4 =
    "Once in every game, each king is allowed to make a special move, \n"
    + "known as castling. Castling consists of moving the king two squares \n"
    + "along the first rank toward a rook (which is on the player's first \n"
    + "rank) and then placing the rook on the last square the king \n"
    + "has just crossed. Castling is permissible only if all of the \n"
    + "following conditions hold.\n"
    + "Neither of the pieces involved in castling may have been previously \n"
    + "moved during the game.\n"
    + "There must be no pieces between the king and the rook.\n"
    + "The king may not be in check, nor may the king pass through squares \n"
    + "that are under attack by enemy pieces, nor move to a square where it \n"
    + "is in check.\n"
    + "\n";
    private String title5 = "En passant\n";
    private String text5 = 
    "When a pawn advances two squares from its starting position and \n"
    + "there is an opponents pawn on an adjacent file next to its \n"
    + "destination square, then the opponents pawn can capture it en \n"
    + "passant (in passing), and move to the square the pawn passed over. \n"
    + "However, this can only be done on the very next move, otherwise the \n"
    + "right to do so is forfeit. For example, if the black pawn has just \n"
    + "advanced two squares from g7 (initial starting position) to g5, then \n"
    + "the white pawn on f5 may take it via en passant on g6 (but only on \n"
    + "whites next move).\n"
    + "\n";
    private String title6 = "Promotion\n";
    private String text6 = 
    "When a pawn advances to the eighth rank, as a part of the move it is \n"
    + "promoted and must be exchanged for the players choice of queen, \n"
    + "rook, bishop, or knight of the same color. Usually, the pawn is \n"
    + "chosen to be promoted to a queen, but in some cases another piece is \n"
    + "chosen; this is called underpromotion. In the diagram on the right,\n"
    + "the pawn on c7 can be advanced to the eighth rank and be promoted \n"
    + "to an allowed piece. There is no restriction placed on the piece \n"
    + "that is chosen on promotion, so it is possible to have more pieces \n"
    + "of the same type than at the start of the game (for example, two \n"
    + "queens).\n"
    + "\n";
    private String title7 = "Check (chess)\n";
    private String text7 = 
    "When a king is under immediate attack by one or two of the \n"
    + "opponents pieces, it is said to be in check. A response to a check \n"
    + "is a legal move if it results in a position where the king is no \n"
    + "longer under direct attack (that is, not in check). This can involve \n"
    + "capturing the checking piece; interposing a piece between the \n"
    + "checking piece and the king (which is possible only if the attacking \n"
    + "piece is a queen, rook, or bishop and there is a square between it \n"
    + "and the king); or moving the king to a square where it is not under \n"
    + "attack. Castling is not a permissible response to a check. The \n"
    + "object of the game is to checkmate the opponent; this occurs when \n"
    + "the opponents king is in check, and there is no legal way to remove \n"
    + "it from attack. It is illegal for a player to make a move that would \n"
    + "put or leave his own king in check.\n"
    + "\n";
    private String title8 = "End of the game\n";
    private String text8 = 
    "Stalemate if it is Black to move. It is not checkmate, and since \n"
    + "Black cannot move, the game is a draw.\n"
    + "Although the objective of the game is to checkmate the opponent, \n"
    + "chess games do not have to end in checkmate either player may \n"
    + "resign which is a win for the other player. It is considered bad \n"
    + "etiquette to continue playing when in a truly hopeless position. \n"
    + "If it is a game with time control, a player may run out of time \n"
    + "and lose, even with a much superior position. Games also may end \n"
    + "in a draw (tie). A draw can occur in several situations, including \n"
    + "draw by agreement, stalemate, threefold repetition of a position, \n"
    + "the fifty-move rule, or a draw by impossibility of checkmate \n"
    + "(usually because of insufficient material to checkmate). \n"
    + "As checkmate from some positions cannot be forced in fewer than \n"
    + "50 moves (such as in the pawnless chess endgame and two knights \n"
    + "endgame), the fifty-move rule is not applied everywhere,\n"
    + "particularly in correspondence chess.\n"
    + "\n";
    private String title9 = "Time control\n";
    private String text9 =
    "Besides casual games without any time restriction, chess is also \n"
    + "played with a time control, mostly by club and professional players. \n"
    + "If a players time runs out before the game is completed, the game \n"
    + "is automatically lost (provided his opponent has enough pieces left \n"
    + "to deliver checkmate). The duration of a game ranges from long games \n"
    + "played up to seven hours to shorter rapid chess games, usually \n"
    + "lasting 30 minutes or one hour per game. Even shorter is blitz \n"
    + "chess, with a time control of three to fifteen minutes for each \n"
    + "player, and bullet chess (under three minutes). In tournament play, \n"
    + "time is controlled using a game clock that has two displays, one for \n"
    + "each player's remaining time.";
    public Rules(){
        rules.setOpaque(false);
        rules.setForeground(Color.white);
        rules.setSelectionStart(0);
        rules.setSelectionEnd(0);
        rules.append(title1);
        rules.append(text1);
        rules.append(title2);
        rules.append(text2);
        rules.append(title3);
        rules.append(text3);
        rules.append(title4);
        rules.append(text4);
        rules.append(title5);
        rules.append(text5);
        rules.append(title6);
        rules.append(text6);
        rules.append(title7);
        rules.append(text7);
        rules.append(title8);
        rules.append(text8);
        rules.append(title9);
        rules.append(text9);
    }

    public JTextArea getRules(){
        return rules;
   
    }
}

