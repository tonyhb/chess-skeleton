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
        this.column = position.charAt(0);
        this.row = Integer.parseInt(position.substring(1));
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

}
