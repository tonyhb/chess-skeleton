package chess.piece;

import chess.Player;

/**
 * Created by tonyhb on 11/01/2014.
 */
public class Bishop extends Base {

    public Bishop() {
        super();
        this.type = Type.BISHOP;
    }

    public boolean move(String to) {
        return false;
    }
}
