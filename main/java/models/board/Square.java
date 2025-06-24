package models.board;

import models.MovablePiece;
import models.Piece;


public class Square {
    private final char xPosition;
    private final int yPosition;
    private Piece piece;


    public Square(char x, int y, Piece piece) {
        this.xPosition = x;
        this.yPosition = y;
        this.piece = (MovablePiece) piece;
    }


    public char getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public Piece getPiece() {
        return piece;
    }


    public void setPiece(Piece piece) {
        this.piece = (MovablePiece) piece;
    }


}
