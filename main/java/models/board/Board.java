package models.board;

import javafx.util.Pair;

public interface Board {

    Square getSquare(Pair<Integer, Integer> position);

    Square getSquare(int row, int col);

    void initBoard();
}
