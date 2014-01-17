package chess.piece;
import chess.GameState;
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
    public List<Position> listMoves(String pos) {
        Position position = new Position(pos);
        List<Position> moves = new ArrayList<Position>();

        int maxDistance = 2;
        if (this.hasMoved()) {
            maxDistance = 1;
        }

        for (int n = 1; n <= maxDistance; n++) {
            if (this.getPlayer() == Player.Black) {
                Position newPos = new Position(position.column, position.row - n);
            } else {
                Position newPos = new Position(position.column, position.row + n);
            }

            if (GameState.isPieceAt(newPos)) {
                break;
            }
            moves.add(newPos);
        }

        // @TODO: Check if there's a piece we can capture.
        return moves;
    }

    @Override
    public boolean move(String to) {
        return false;
    }

}
