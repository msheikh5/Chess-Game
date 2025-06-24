package models.piece;

import models.board.Square;

public interface PieceNormalMove {
    void moveNormal(Square start, Square end);
}
