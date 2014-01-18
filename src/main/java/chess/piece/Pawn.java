package chess.piece;
import chess.GameState;
import chess.MoveBuilder.MoveBuilder;
import chess.Player;
import chess.Position;
import javafx.geometry.Pos;

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
    public List<String> listMoves(String pos) {
        List<Position> possible = findPossibleMoves(pos);
        ArrayList<String> moves = new ArrayList<String>();

        for (Position position : possible) {
            moves.add(pos + " " + position.toString());
        }

        return moves;
    }

    @Override
    public List<Position> findPossibleMoves(String pos) {
        ArrayList<Position> moves = new ArrayList<Position>();

        // Get the vertical moves - which is essnetially moving forward one or two.
        MoveBuilder vertical = this.newMoveBuilder(pos);
        // And see if there are any opposing pieces we can capture.
        MoveBuilder lDiagonal = this.newMoveBuilder(pos)
            .setLimit(1)
            .setTransformColumn("-1")
            .setRequiresOpposingPiece(true);
        MoveBuilder rDiagonal = this.newMoveBuilder(pos)
            .setLimit(1)
            .setTransformColumn("+1")
            .setRequiresOpposingPiece(true);

        if (this.getPlayer() == Player.White) {
            vertical.setTransformRow("+1");
            lDiagonal.setTransformRow("+1");
            rDiagonal.setTransformRow("+1");
        } else {
            vertical.setTransformRow("-1");
            lDiagonal.setTransformRow("-1");
            rDiagonal.setTransformRow("-1");
        }

        if (this.hasMoved()) {
            vertical.setLimit(1);
        } else {
            vertical.setLimit(2);
        }

        // Add the vertical moves to our move list.
        moves.addAll(vertical.list());
        moves.addAll(lDiagonal.list());
        moves.addAll(rDiagonal.list());

        return moves;
    }

    @Override
    public boolean move(String to) {
        return false;
    }

}
