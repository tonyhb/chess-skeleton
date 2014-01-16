package chess.piece;
import chess.Player;
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

}
