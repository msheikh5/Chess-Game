package models.board;

import javafx.util.Pair;
import models.piece.*;


public class ChessBoard implements Board {

    private final Square[][] board;
    private static ChessBoard chessBoard;

    private ChessBoard() {
        board = new Square[8][8];
        initBoard();

    }

    public static ChessBoard getInstance() {
        if (chessBoard == null) {
            chessBoard = new ChessBoard();
        }
        return chessBoard;
    }


    public Square getSquare(Pair<Integer, Integer> position) {
        return board[position.getKey()][position.getValue()];
    }

    public Square getSquare(int row, int col) {
        return board[row][col];
    }

    @Override
    public void initBoard() {
        board[0][0] = new Square('A', 1, new Rook(true));
        board[1][0] = new Square('B', 1, new Knight(true));
        board[2][0] = new Square('C', 1, new Bishop(true));
        board[3][0] = new Square('D', 1, new Queen(true));
        board[4][0] = new Square('E', 1, new King(true));
        board[5][0] = new Square('F', 1, new Bishop(true));
        board[6][0] = new Square('G', 1, new Knight(true));
        board[7][0] = new Square('H', 1, new Rook(true));

        char c = 'A';
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Square(c, 2, new Pawn(true));
            c = (char) (c + 1);
        }
        c = 'A';
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                board[i][j] = new Square(c, j + 1, null);
            }
            c = (char) (c + 1);
        }
        c = 'A';
        for (int i = 0; i < 8; i++) {
            board[i][6] = new Square(c, 7, new Pawn(false));
            c = (char) (c + 1);
        }

        board[0][7] = new Square('A', 8, new Rook(false));
        board[1][7] = new Square('B', 8, new Knight(false));
        board[2][7] = new Square('C', 8, new Bishop(false));
        board[3][7] = new Square('D', 8, new Queen(false));
        board[4][7] = new Square('E', 8, new King(false));
        board[5][7] = new Square('F', 8, new Bishop(false));
        board[6][7] = new Square('G', 8, new Knight(false));
        board[7][7] = new Square('H', 8, new Rook(false));
    }


}