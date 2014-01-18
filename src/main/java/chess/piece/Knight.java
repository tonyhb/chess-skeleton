package chess.piece;
import chess.Position;

import java.util.*;

import static chess.piece.Type.*;

/**
 * Created by Tony Holdstock-Brown on 11/01/2014.
 */
public class Knight extends Base {

    public Knight() {
        super();
        this.type = KNIGHT;
    }

    public boolean move(String to) {
        return false;
    }

    public List<Position> findPossibleMoves(String pos) {
        ArrayList<Position> moves = new ArrayList<Position>();
        return moves;
    }

}
