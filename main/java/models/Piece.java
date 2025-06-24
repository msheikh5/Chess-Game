package models;


import models.board.ChessBoard;
import models.board.Square;

public abstract class Piece {
    private boolean isKilled;
    private boolean isWhite;


    public Piece(boolean isWhite) {
        this.isWhite = isWhite;

    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isKilled() {
        return isKilled;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Piece{" +
                "isKilled=" + isKilled +
                ", isWhite=" + isWhite +
                '}';
    }

    public abstract void move(Square start, Square stop);

    public abstract boolean canMove(Square start, Square stop, ChessBoard board);
}
