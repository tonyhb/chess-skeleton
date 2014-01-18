package chess;

import java.util.*;
import chess.piece.*;

/**
 * Class that represents the current state of the game.  Basically, what pieces are in which positions on the
 * board.
 */
public class GameState {

    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;
    public static final char MIN_COLUMN = 'a';
    public static final char MAX_COLUMN = 'h';

    private Player currentPlayer = Player.White;

    private static Map<String, Base> _pieces = new HashMap<String, Base>();

    /**
     * Create the game state.
     */
    public GameState() {
        createFirstRow(8, Player.Black);
        createSecondRow(7, Player.Black);
        createFirstRow(1, Player.White);
        createSecondRow(2, Player.White);
    }

    /**
     * Creates a line of Rooks, Knights etc. on a specified row for a player.
     * Delegates to the {@link #createRow(int, Player, chess.piece.Base...) createRow} method.
     *
     * @param row
     * @param player
     */
    private void createFirstRow(int row, Player player) {
        createRow(row, player, new Rook(), new Knight(), new Bishop(), new Queen(), new King(), new Bishop(), new Knight(), new Rook());
    }

    /**
     * Creates a line of pawns on a specified row for a player.
     * Delegates to the {@link #createRow(int, Player, chess.piece.Base...) createRow} method.
     *
     * @param row
     * @param player
     */
    private void createSecondRow(int row, Player player) {
        createRow(row, player, new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn());
    }

    /**
     * Implements adding a row of pieces to the GameState for a player.
     *
     * @param row     The row we're creating
     * @param player  The player we're adding pieces for
     * @param items   A variadic list of 8 chess pieces to add
     */
    private void createRow(int row, Player player, chess.piece.Base... items) {
        List<? extends chess.piece.Base> list = Arrays.asList(items);

        int n = 0;
        for (char i = MIN_COLUMN; i <= MAX_COLUMN; i++) {
            Base piece = list.get(n).setPlayer(player);
            _pieces.put(String.valueOf(i) + row, piece);
            n++;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static boolean isPieceAt(Position pos) {
        return isPieceAt(pos.toString());
    }

    public static boolean isPieceAt(String position) {
        if (_pieces.get(position) == null) {
            return false;
        }
        return true;
    }

    public static Base getPieceAt(String location) {
        return _pieces.get(location);
    }

    public List<String> showMoves() {
        // @TODO: Show moves for all pieces of the current player
        List<String> moves = new ArrayList<String>();

        for (Map.Entry<String, ? extends Base> item : _pieces.entrySet()) {
            String pos = item.getKey();
            Base piece = item.getValue();

            if (piece.getPlayer() != currentPlayer) {
                continue;
            }

            moves.addAll(piece.listMoves(pos));
        }

        return moves;
    }

    /**
     * Moves a chess piece from one location to another.
     * Delegates to the chess piece's `move` method.
     *
     * If the move is not valid this returns false: it doesn't throw
     * an exception.
     *
     * @param from  The location of the chess piece to move
     * @param to    Where the chess piece is moving to
     * @return      True on successful move; false if the move was invalid
     */
    public boolean movePiece(String from, String to) {
        return false;
    }

    public void switchPlayer() {
        if (currentPlayer == Player.White) {
            currentPlayer = Player.Black;
        } else {
            currentPlayer = Player.White;
        }
    }

}
