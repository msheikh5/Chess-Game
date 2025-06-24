package models.piece;

import models.MovablePiece;
import models.board.ChessBoard;
import models.board.Square;

public class Queen extends MovablePiece implements PieceDiagonalMove, PieceNormalMove {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Square start, Square stop , ChessBoard board) {
        if (checkDiagonalMove(start,stop))
        {
            Bishop bishop=new Bishop(true);
            return bishop.canMove(start, stop, board);
        }
        else {
            Rook rook=new Rook(true);
            return rook.canMove(start, stop, board);
        }
    }

    @Override
    public void move(Square start, Square stop) {
        if (checkDiagonalMove(start, stop)) {
            this.moveDiagonal(start, stop);
        } else
            this.moveNormal(start, stop);

    }


    @Override
    public void moveDiagonal(Square start, Square end) {
        start.setPiece(null);
        end.setPiece(this);
    }

    @Override
    public void moveNormal(Square start, Square end) {
        start.setPiece(null);
        end.setPiece(this);

    }

    private boolean checkDiagonalMove(Square start, Square end) {
        return Math.abs((start.getXPosition() - 'A') - (end.getXPosition() - 'A')) == Math.abs(start.getYPosition() - end.getYPosition());
    }


    @Override
    public String toString() {
        if (isWhite()) {
            return "WQ";
        }
        return "BQ";

    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Queen)) return false;
        Queen queen=(Queen) o;
        return this.isWhite()==queen.isWhite();

    }


}
