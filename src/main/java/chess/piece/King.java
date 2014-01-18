package chess.piece;

import chess.MoveBuilder.MoveBuilder;
import chess.Position;

import java.util.*;

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

    public List<Position> findPossibleMoves(String pos) {
        ArrayList<Position> moves = new ArrayList<Position>();

        // Search the ascending diagonal line
        MoveBuilder builder = this.newMoveBuilder(pos)
                .setLimit(1)
                .setTransformColumn("+1")
                .setTransformRow("+1");
        moves.addAll(builder.list());
        moves.addAll(builder.flip().list());

        // Search the descending diagonal line
        builder.setTransformColumn("-1")
                .setTransformRow("+1");
        moves.addAll(builder.list());
        moves.addAll(builder.flip().list());

        // Search the horizontal line
        builder.setTransformColumn("+1")
                .setTransformRow("");
        moves.addAll(builder.list());
        moves.addAll(builder.flip().list());

        // Search the vertical line
        builder.setTransformColumn("")
                .setTransformRow("+1");
        moves.addAll(builder.list());
        moves.addAll(builder.flip().list());

        return moves;
    }
}
