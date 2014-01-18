package chess.MoveBuilder.Token;

/**
 * Created by Tony Holdstock-Brown on 17/01/2014.
 */
public class Token {

    protected TokenType type;

    protected int value;

    public Token(TokenType type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int run(int original) {
        switch (this.type) {
            case ADD:
                return original + this.value;
            case SUBTRACT:
                return original - this.value;
            case MULTIPLY:
                return original * this.value;
            case DIVIDE:
                return original / this.value;
        }

        return original;
    }

    public void flip() {
        switch (this.type) {
            case ADD:
                this.type = TokenType.SUBTRACT;
                break;
            case SUBTRACT:
                this.type = TokenType.ADD;
                break;
            case MULTIPLY:
                this.type = TokenType.DIVIDE;
                break;
            case DIVIDE:
                this.type = TokenType.MULTIPLY;
                break;
        }
    }


}
