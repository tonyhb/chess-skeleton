package chess.piece;

import chess.MoveBuilder.MoveBuilder;
import chess.Player;
import chess.Position;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Position> findPossibleMoves(String pos) {
        ArrayList<Position> moves = new ArrayList<Position>();

        // Search the ascending diagonal line, where
        // y = 1x + n
        MoveBuilder builder = this.newMoveBuilder(pos)
                .setTransformColumn("+1")
                .setTransformRow("+1");

        moves.addAll(builder.list());
        moves.addAll(builder.flip().list());

        // Search the descending diagonal line, where
        // y = -1x + n
        builder = this.newMoveBuilder(pos)
                .setTransformColumn("+1")
                .setTransformRow("-1");

        moves.addAll(builder.list());
        moves.addAll(builder.flip().list());

        return moves;
    }
}
