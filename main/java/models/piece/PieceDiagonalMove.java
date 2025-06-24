package models.piece;

import models.board.Square;

public interface PieceDiagonalMove {
    void moveDiagonal(Square start, Square end);
}
