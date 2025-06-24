package models.piece;

import models.MovablePiece;
import models.board.ChessBoard;
import models.board.Square;

public class Bishop extends MovablePiece implements PieceDiagonalMove {


    public Bishop(boolean isWhite) {
        super(isWhite);

    }


    @Override
    public boolean canMove(Square start, Square stop, ChessBoard board) {
        int x = stop.getXPosition() - start.getXPosition();
        int y = stop.getYPosition() - start.getYPosition();
        if (checkDiagonalMove(start, stop)) {
            int numberOfSteps = Math.abs(start.getXPosition() - stop.getXPosition());
            if (x > 0 && y > 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
                for (int i = 1; i < numberOfSteps; i++) {

                    if (board.getSquare(start.getXPosition() - 'A' + i, start.getYPosition() - 1 + i).getPiece() != null)
                        return false;
                }
                return true;
            } else if (x < 0 && y > 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
                for (int i = 1; i < numberOfSteps; i++) {
                    if (board.getSquare(start.getXPosition() - 'A' - i, start.getYPosition() - 1 + i).getPiece() != null)
                        return false;
                }
                return true;
            } else if (x > 0 && y < 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
                for (int i = 1; i < numberOfSteps; i++) {
                    if (board.getSquare(start.getXPosition() - 'A' + i, start.getYPosition() - 1 - i).getPiece() != null)
                        return false;
                }
                return true;
            } else if (x < 0 && y < 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
                for (int i = 1; i < numberOfSteps; i++) {
                    if (board.getSquare(start.getXPosition() - 'A' - i, start.getYPosition() - 1 - i).getPiece() != null)
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalMove(Square start, Square end) {
        int x = Math.abs((start.getXPosition() - 'A') - (end.getXPosition() - 'A'));
        int y = Math.abs(start.getYPosition() - end.getYPosition());
        if (x == y) return true;
        return false;
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "WB";
        }
        return "BB";
    }

    @Override
    public void move(Square start, Square stop) {
        this.moveDiagonal(start, stop);

    }

    @Override
    public void moveDiagonal(Square start, Square end) {
        start.setPiece(null);
        end.setPiece(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bishop)) return false;
        Bishop bishop = (Bishop) o;
        return this.isWhite() == bishop.isWhite();

    }
}
