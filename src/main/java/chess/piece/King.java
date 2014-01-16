package chess.piece;

import chess.Player;

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
}
