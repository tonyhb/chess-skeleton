package chess.piece;

import chess.Player;
import chess.Position;

import java.util.List;

/**
 * Created by tonyhb on 11/01/2014.
 */
public class King extends Base {

    public King() {
        super();
        this.type = type.KING;
    }

    public boolean move(String to) {
        return false;
    }

    public List<String> listMoves(String pos) { return null; }
    public List<Position> findPossibleMoves(String pos) { return null; }
}
