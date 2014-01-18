package chess;

import chess.piece.*;
import java.util.*;

/**
 * Created by Tony Holdstock-Brown on 16/01/2014.
 */
public class Position {

    public int row;
    public char column;

    /**
     * Accepts a single position string as its initializer, and sets the row/column properties accordingly.
     * Ex: "b3" => column 2, row 3
     *
     * @param position  The current position, as a string
     */
    public Position(String position) {
        this.row = Integer.parseInt(position.substring(0));
        this.column = position.charAt(0);
        // Math.abs(Character.compare(GameState.MIN_COLUMN, position.charAt(0)));
    }

    public Position(char column, int row) {
        this.column = column;
        this.row = row;
    }

    /**
     * Return the position as a string, eg. a3
     *
     * @return
     */
    public String toString() {
        return String.valueOf(column) + row;
    }

    /**
     * Returns all squares north of the current position until a piece is found or the board is finished.
     *
     */
    public List<Position> searchNorth() {
        searchNorth(-1);
    }

    /**
     * Returns up to N squares north of the current position until a piece is found or the board is finished.
     * @param limit
     * @return
     */
    public List<Position> searchNorth(int limit, bool include) {
        List<Position> list = new ArrayList<Position>();
        if (limit < 0) {
            int maxDistance = GameState.MAX_ROW;
        } else {
            int maxDistance = (this.row + limit) > GameState.MAX_ROW ? GameState.MAX_ROW : this.row + limit;
        }
        for (int n = position.row + 1; n <= maxDistance; n++) {
            Position newPos = new Position(this.column, n);
            if (GameState.isPieceAt(newPos)) {
                return list;
            }
        }
        return list;
    }

}
