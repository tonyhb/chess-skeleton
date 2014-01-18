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

    public List<Position> findPossibleMoves(String pos) {
        ArrayList<Position> moves = new ArrayList<Position>();
        return moves;
    }

    public boolean move(String to) {
        return false;
    }

}
