package models.piece;

import models.MovablePiece;
import models.board.ChessBoard;
import models.board.Square;

public class Knight extends MovablePiece {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Square start, Square stop, ChessBoard board) {
        int x = Math.abs(start.getXPosition() - stop.getXPosition());
        int y = Math.abs(start.getYPosition() - stop.getYPosition());
        if (x * y == 2 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "WN";
        }
        return "BN";

    }

    @Override
    public void move(Square start, Square stop) {
        start.setPiece(null);
        stop.setPiece(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knight)) return false;
        Knight knight = (Knight) o;
        return this.isWhite() == knight.isWhite();

    }

}




