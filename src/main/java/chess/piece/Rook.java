package chess.piece;

import chess.GameState;
import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonyhb on 11/01/2014.
 */
public class Rook extends Base {

    public Rook() {
        super();
        this.type = type.ROOK;
    }

    /*
    public List<Position> listMoves(String pos) {
        Position position = new Position(pos);
        List<Position> moves = new ArrayList<Position>();

        // Look south
        for (int n = position.row - 1; n >= GameState.MIN_ROW; n--) {
            Position newPos = new Position(position.column, n);
            if (GameState.isPieceAt(newPos)) {
                break;
            }
            moves.add(newPos);
        }

        // Look north
        for (int n = position.row + 1; n <= GameState.MAX_ROW; n++) {
            Position newPos = new Position(position.column, n);
            if (GameState.isPieceAt(newPos)) {
                break;
            }
            moves.add(newPos);
        }

        // Look east
        for (char n = position.column; n <= GameState.MAX_COLUMN; ++n) {
            Position newPos = new Position(n, position.row);
            if (GameState.isPieceAt(newPos)) {
                break;
            }
            moves.add(newPos);
        }
        // Look west
        for (char n = position.column; n <= GameState.MIN_COLUMN; --n) {
            Position newPos = new Position(n, position.row);
            if (GameState.isPieceAt(newPos)) {
                break;
            }
            moves.add(newPos);
        }

        return moves;
    }
    */
    public List<String> listMoves(String pos) { return null; }
    public List<Position> findPossibleMoves(String pos) { return null; }

    public boolean move(String to) {
        return false;
    }

}
