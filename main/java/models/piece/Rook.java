package models.piece;

import models.MovablePiece;
import models.board.ChessBoard;
import models.board.Square;

public class Rook extends MovablePiece implements PieceNormalMove {
    public Rook(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public boolean canMove(Square start, Square stop, ChessBoard board) {
        int x = stop.getXPosition() - start.getXPosition();
        int y = stop.getYPosition() - start.getYPosition();
        if (x == 0 && y > 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
            for (int i = 1; i < Math.abs(y); i++) {
                if (board.getSquare(start.getXPosition() - 'A', start.getYPosition() + i - 1).getPiece() != null)
                    return false;
            }
            return true;
        } else if (x == 0 && y < 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
            for (int i = 1; i < Math.abs(y); i++) {
                if (board.getSquare(start.getXPosition() - 'A', start.getYPosition() - 1 - i).getPiece() != null)
                    return false;
            }
            return true;
        } else if (x > 0 && y == 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
            for (int i = 1; i < Math.abs(x); i++) {
                if (board.getSquare(start.getXPosition() - 'A' + i, start.getYPosition() - 1).getPiece() != null)
                    return false;
            }
            return true;
        } else if (x < 0 && y == 0 && (stop.getPiece() == null || start.getPiece().isWhite() != stop.getPiece().isWhite())) {
            for (int i = 1; i < x; i++) {
                if (board.getSquare(start.getXPosition() - 'A' + i, start.getYPosition() - 1).getPiece() != null)
                    return false;
            }
            return true;
        }
        return false;
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

    @Override
    public String toString() {
        if (isWhite()) {
            return "WR";
        }
        return "BR";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rook)) return false;
        Rook rook = (Rook) o;
        return this.isWhite() == rook.isWhite();

    }


}
