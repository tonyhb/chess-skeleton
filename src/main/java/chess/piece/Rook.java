package chess.piece;

import chess.Player;

/**
 * Created by tonyhb on 11/01/2014.
 */
public class Rook extends Base {

    public Rook() {
        super();
        this.type = type.ROOK;
    }

    public boolean move(String to) {
        return false;
    }

}
