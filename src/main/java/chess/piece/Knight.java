package chess.piece;
import chess.Player;
import chess.Position;

import java.util.List;

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

    public List<String> listMoves(String pos) { return null; }
    public List<Position> findPossibleMoves(String pos) { return null; }

}
