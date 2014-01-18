package chess.MoveBuilder;

import chess.GameState;
import chess.MoveBuilder.Token.Operator;
import chess.MoveBuilder.Token.Token;
import chess.MoveBuilder.Token.TokenType;
import chess.Position;
import chess.piece.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Tony Holdstock-Brown on 17/01/2014.
 */
public class MoveBuilder {

    protected Position origin;
    protected Base piece;
    protected int limit = 8;
    protected Boolean requiresOpposingPiece = false;

    protected ArrayList<Token> transformRow;
    protected ArrayList<Token> transformColumn;

    public MoveBuilder setPiece(Base piece) {
        this.piece = piece;
        return this;
    }

    public MoveBuilder setOrigin(Position origin) {
        this.origin = origin;
        return this;
    }

    public MoveBuilder setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public MoveBuilder setRequiresOpposingPiece(Boolean requiresOpposingPiece) {
        this.requiresOpposingPiece = requiresOpposingPiece;
        return this;
    }

    public MoveBuilder setTransformRow(String transform) {
        this.transformRow = tokenize(transform);
        return this;
    }

    public MoveBuilder setTransformColumn(String transform) {
        this.transformColumn = tokenize(transform);
        return this;
    }

    protected ArrayList<Token> tokenize(String transform) throws RuntimeException {
        ArrayList<Token> list = new ArrayList<Token>();
        String holder = "";
        Token  token  = null;
        int length = transform.length();

        for (int i = 0; i < length; i++) {
            char c = transform.charAt(i);

            // Ignore spaces.
            if (c == ' ') {
                continue;
            }

            // If this is an operator, create a new token with the correct operator type.
            switch (c) {
                case '+':
                    token = new Operator(TokenType.ADD);
                    continue;
                case '-':
                    token = new Operator(TokenType.SUBTRACT);
                    continue;
                case '*':
                    token = new Operator(TokenType.MULTIPLY);
                    continue;
                case '/':
                    token = new Operator(TokenType.DIVIDE);
                    continue;
            }


            // Numbers should always follow operators, so ensure we have a token to extract
            // the number
            if (token != null && Character.isDigit(c)) {
                holder = "";
                // Extract the number
                while (Character.isDigit(c) && i < length) {
                    holder += String.valueOf(c);
                    i++;
                    if (i < length) {
                        c = transform.charAt(i);
                    }
                }

                // Add the number as a token
                token.setValue(Integer.valueOf(holder));
                list.add(token);
                continue;
            }

            // We shouldn't be here - only operators and numbers are allowed.
            throw new RuntimeException("Invalid character in transform: " + c);
        }

        return list;
    }

    /**
     * Flips all transforms added to the MoveBuilder, eg. "+1" becomes "-1" for any transform.
     * This allows us to check the entire column above and below a piece with ease - set up
     * a builder for searching above a piece, get all moves, call flip() and get the list again.
     *
     * @return this
     */
    public MoveBuilder flip() {
        if (transformColumn != null) {
            ArrayList<Token> flippedColumn = new ArrayList<Token>();
            for (Token token : transformColumn) {
                token.flip();
                flippedColumn.add(token);
            }
            transformColumn = flippedColumn;
        }
        if (transformRow != null) {
            ArrayList<Token> flippedRow = new ArrayList<Token>();
            for (Token token : transformRow) {
                token.flip();
                flippedRow.add(token);
            }
            transformRow = flippedRow;
        }

        return this;
    }

    public ArrayList<Position> list() {
        ArrayList<Position> list = new ArrayList<Position>();
        char column = this.origin.column;
        int row = this.origin.row;
        int i = 0;

        while (i < limit) {

            if (transformColumn != null) {
                for (Token token : transformColumn) {
                    column = (char)token.run((int)column);
                }
            }
            if (transformRow != null) {
                for (Token token : transformRow) {
                    row = token.run(row);
                }
            }

            if (row < GameState.MIN_ROW ||
                row > GameState.MAX_ROW ||
                column < GameState.MIN_COLUMN ||
                column > GameState.MAX_COLUMN)
            {
                // The transformations went outside the boards boundaries - we can quit.
                break;
            }

            Position pos = new Position(column, row);

            boolean isPieceAt = GameState.isPieceAt(pos);

            if (isPieceAt) {
                // If this is an opponent's piece, we should be able to capture it.
                Base p = GameState.getPieceAt(pos);
                if (p.getPlayer() != this.piece.getPlayer()) {
                    list.add(pos);
                }
                // This is as far as we can go.
                break;
            }

            // At this point there was no piece in the way.
            // Only add this move to the list if we didn't require an opposing piece
            if ( ! requiresOpposingPiece) {
                list.add(pos);
            }

            i++;
        }

        return list;
    }

}
