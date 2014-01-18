package chess.piece;

import chess.MoveBuilder.MoveBuilder;
import chess.Player;
import chess.Position;

import java.util.*;

/**
 * Created by Tony Holdstock-Brown on 10/01/2014.
 */
public class Pawn extends Base {

    public Pawn() {
        super();
        this.type = type.PAWN;
    }

    @Override
    public List<Position> findPossibleMoves(String pos) {
        ArrayList<Position> moves = new ArrayList<Position>();

        // Get the vertical moves - which is essnetially moving forward one or two.
        MoveBuilder vertical = this.newMoveBuilder(pos);
        // And see if there are any opposing pieces we can capture.
        MoveBuilder diagonal = this.newMoveBuilder(pos)
            .setLimit(1)
            .setTransformColumn("-1")
            .setRequiresOpposingPiece(true);

        if (this.getPlayer() == Player.White) {
            vertical.setTransformRow("+1");
            diagonal.setTransformRow("+1");
        } else {
            vertical.setTransformRow("-1");
            diagonal.setTransformRow("-1");
        }

        if (this.hasMoved()) {
            vertical.setLimit(1);
        } else {
            vertical.setLimit(2);
        }

        // Add the vertical moves to our move list.
        moves.addAll(vertical.list());
        // Add the diagonal moves ot our list
        moves.addAll(diagonal.list());
        moves.addAll(diagonal.setTransformColumn("+1").list());

        return moves;
    }

    @Override
    public boolean move(String to) {
        return false;
    }

}
