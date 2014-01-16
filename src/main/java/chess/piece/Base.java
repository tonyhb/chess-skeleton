package chess.piece;
import chess.*;

/**
 * Created by Tony Holdstock-Brown on 10/01/2014.
 */
abstract public class Base {
    protected Type type;

    protected String location;
    protected chess.Player player;
    protected boolean hasMoved;

    protected Base() {
        this.hasMoved = false;
    }

    public Base setPlayer(Player player) throws RuntimeException {
        if (this.player == null) {
            this.player = player;
        } else {
            throw new RuntimeException("Player has already been set");
        }

        return this;
    }

    public Base setLocation(String location) throws RuntimeException {
        if (this.location == null) {
            this.location = location;
        } else {
            throw new RuntimeException("Location has already been set; please use move() to move the chess piece");
        }
        return this;
    }

    public chess.piece.Type getType() {
        return type;
    }

    public String toString() {
        // If there's no abbreviation set, use the first letter of the piece type
        String abbr = this.type.getLetter();

        if (this.player == Player.White) {
            abbr = abbr.toLowerCase();
        } else {
            abbr = abbr.toUpperCase();
        }

        return abbr;
    }

    abstract boolean move(String to);
}