package chess.piece;

/**
 * Created by tonyhb on 11/01/2014.
 */
public enum Type {
    PAWN("p"), ROOK("r"), KNIGHT("n"), BISHOP("b"), QUEEN("q"), KING("k");

    private String letter;

    private Type(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return this.letter;
    }
}