package models;

import models.board.ChessBoard;
import models.board.Square;

public abstract class MovablePiece extends Piece {


    public MovablePiece(boolean isWhite) {
        super(isWhite);
    }

    public abstract void move(Square start, Square stop);

    public abstract boolean canMove(Square start, Square stop, ChessBoard board);
}
