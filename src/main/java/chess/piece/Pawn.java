package chess.piece;
import chess.Player;

/**
 * Created by Tony Holdstock-Brown on 10/01/2014.
 */
public class Pawn extends Base {

    public Pawn() {
        super();
        this.type = type.PAWN;
    }

    public boolean move(String to) {
        return false;
    }

}
