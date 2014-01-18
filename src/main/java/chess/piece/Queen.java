package chess.piece;

import chess.Position;

import java.util.*;

/**
 * Created by tonyhb on 11/01/2014.
 */
public class Queen extends Base {

    public Queen() {
        super();
        this.type = Type.QUEEN;
    }

    public boolean move(String to) {
        return false;
    }

    public List<Position> findPossibleMoves(String pos) {
        ArrayList<Position> moves = new ArrayList<Position>();
        return moves;
    }
}
