package models.piece;

import models.MovablePiece;
import models.Piece;
import models.board.ChessBoard;
import models.board.Square;

public class King extends MovablePiece implements PieceNormalMove {


    public King(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public boolean canMove(Square start, Square stop, ChessBoard board) {
        boolean isLegal = false;
        int x = Math.abs(stop.getXPosition() - start.getXPosition());
        int y = Math.abs(stop.getYPosition() - start.getYPosition());
        if (x - y == 0 || Math.abs(x - y) == 1)
            stop.setPiece(this);
        isLegal = true;
        OuterLoop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                MovablePiece piece = (MovablePiece) board.getSquare(i, j).getPiece();
                if (piece !=
                        null && piece.isWhite() != start.getPiece().isWhite() &&
                        (!(piece instanceof King)) &&
                        piece.canMove(board.getSquare(i, j), stop, board)) {
                    isLegal = false;
                    break OuterLoop;
                }
            }
            if (!isLegal)
                break;
        }
        stop.setPiece(null);
        return isLegal;
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "WK";
        }
        return "BK";

    }

    @Override
    public void move(Square start, Square stop) {
        this.moveNormal(start, stop);
    }

    @Override
    public void moveNormal(Square start, Square end) {
        start.setPiece(null);
        end.setPiece(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof King)) return false;
        King king = (King) o;
        return this.isWhite() == king.isWhite();

    }
}
