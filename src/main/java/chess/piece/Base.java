package chess.piece;
import chess.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony Holdstock-Brown on 10/01/2014.
 */
    abstract public class Base {
        protected Type type;

        protected Player player;
        protected boolean moved;

        protected Base() {
            this.moved = false;
        }

        public Base setPlayer(Player player) throws RuntimeException {
            if (this.player == null) {
                this.player = player;
            } else {
                throw new RuntimeException("Player has already been set");
            }

            return this;
        }

        public Player getPlayer() {
            return this.player;
        }

        public boolean hasMoved() {
            return this.moved;
        }

        public Type getType() {
            return type;
        }

        public String toString() {
            // If there's no abbreviation set, use the first letter of the piece type
            String abbr = this.type.getLetter();

            if (this.player == Player.White) {
                abbr = abbr.toLowerCase();
            } else {
                abbr = abbr.toUpperCase();
            }

            return abbr;
        }

        public abstract List<Position> listMoves(String position);

        abstract boolean move(String to);
}