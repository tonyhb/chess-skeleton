package chess.piece;
import chess.*;
import chess.MoveBuilder.MoveBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony Holdstock-Brown on 10/01/2014.
 */
abstract public class Base {
    protected Type type;

    protected Player player;
    protected boolean moved;

    protected Base() {
        this.moved = false;
    }

    public Base setPlayer(Player player) throws RuntimeException {
        if (this.player == null) {
            this.player = player;
        } else {
            throw new RuntimeException("Player has already been set");
        }

        return this;
    }

    public Player getPlayer() {
                            return this.player;
                                                               }

    public boolean hasMoved() {
        return this.moved;
    }

    public Type getType() {
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

    public abstract List<String> listMoves(String position);

    public abstract List<Position> findPossibleMoves(String position);

    /**
     * Returns a new MoveBuilder with the origin and piece auto-filled. Convenience function for listMoves().
     *
     * @param pos  String of the current piece's location
     * @return     A MoveBuilder instance with origin and piece set.
     */
    protected MoveBuilder newMoveBuilder(String pos) {
        return new MoveBuilder().setOrigin(new Position(pos)).setPiece(this);
    }

    abstract boolean move(String to);
}