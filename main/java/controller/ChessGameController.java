package controller;

import javafx.util.Pair;
import models.MovablePiece;
import models.Piece;
import models.board.ChessBoard;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessGameController {

    private ChessGameController() {

    }


    public static Pair<Integer, Integer> transformInput(String position) {
        int x = position.charAt(0) - 'A';
        int y = position.charAt(1) - '1';
        Pair<Integer, Integer> newPosition = new Pair<>(x, y);
        return newPosition;
    }

    public static void movePiece(Pair<Integer, Integer> from, Pair<Integer, Integer> to, ChessBoard board) {
        Piece piece = board.getSquare(from).getPiece();
        isMovablePiece(piece);
        MovablePiece piece1 = (MovablePiece) piece;
        movePiece(board, from, to, piece1);

    }

    public static void isMovablePiece(Piece piece) {
        if (!(piece instanceof MovablePiece)) {
            System.out.println("Cannot move this piece");
            return;
        }
    }

    public static void movePiece(ChessBoard board, Pair<Integer, Integer> from, Pair<Integer, Integer> to, MovablePiece piece) {
        if (piece.canMove(board.getSquare(from), board.getSquare(to), board)) {
            checkKilledPiece(to, board);
            piece.move(board.getSquare(from), board.getSquare(to));
        } else {
            while (true) {
                System.out.println("Cannot move this piece, try again");
                Scanner scanner = new Scanner(System.in);
                String move = scanner.nextLine();
                from = ChessGameController.transformInput(move.split(" ")[1]);
                to = ChessGameController.transformInput(move.split(" ")[2]);
                if (!ChessGameController.validateMove(move) && board.getSquare(from).getPiece() != null && board.getSquare(from).getPiece().isWhite() == piece.isWhite()) {
                    movePiece(from, to, board);
                    break;
                }
            }
        }
    }

    public static void checkKilledPiece(Pair<Integer, Integer> to, ChessBoard board) {
        if (board.getSquare(to).getPiece() != null) {
            board.getSquare(to).getPiece().setKilled(true);
            board.getSquare(to).setPiece(null);
        }
    }

    public static boolean validateMove(String move) {
        String regex = "^MOVE\\s[A-H][1-8]\\s[A-H][1-8]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(move);
        boolean result = m.matches();
        return !result;
    }


}
