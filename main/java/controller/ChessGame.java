package controller;

import javafx.util.Pair;
import models.Piece;
import models.board.BoardPrinter;
import models.board.ChessBoard;
import models.Player;
import models.piece.King;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChessGame {
    private Player[] players;
    private ChessBoard board;
    private Player currentPlayer;
    private GameState gameState;
    private boolean isDone;
    private List<String> movesPlayed;

    public void start() {
        players = new Player[2];
        board = ChessBoard.getInstance();
        BoardPrinter printer = new BoardPrinter(board);
        gameState = GameState.PLAYING;
        movesPlayed = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the white player name:");
        String whitePlayerName = scanner.nextLine();
        System.out.println("Enter the black player name:");
        String blackPlayerName = scanner.nextLine();
        players[0] = new Player(whitePlayerName, true);
        players[1] = new Player(blackPlayerName, false);
        currentPlayer = players[0];

        while (!this.isDone()) {
            printer.printBoard();
            System.out.println("Enter next move (" + currentPlayer.getName() + "):");
            String input = scanner.nextLine();
            if (this.isWhiteTurn()) {
                this.playWhite(input);
            } else if (!this.isWhiteTurn())
                this.playBlack(input);

            this.printPlayedMove();
        }
        this.printWinnerName();
    }

    public void playWhite(String move) {
        Pair<Integer, Integer> from = ChessGameController.transformInput(move.split(" ")[1]);
        Pair<Integer, Integer> to = ChessGameController.transformInput(move.split(" ")[2]);
        if (ChessGameController.validateMove(move) || board.getSquare(from).getPiece() == null || !board.getSquare(from).getPiece().isWhite()) {
            System.out.println("Invalid move please try again");
            return;
        }
        currentPlayer = players[0];

        startMove(from, to);

        currentPlayer = players[1];
        movesPlayed.add("white Played" + move);
    }

    public void playBlack(String move) {
        Pair<Integer, Integer> from = ChessGameController.transformInput(move.split(" ")[1]);
        Pair<Integer, Integer> to = ChessGameController.transformInput(move.split(" ")[2]);
        if (ChessGameController.validateMove(move) || board.getSquare(from).getPiece() == null || board.getSquare(from).getPiece().isWhite()) {
            System.out.println("Invalid move please try again");
            return;
        }

        startMove(from, to);

        currentPlayer = players[0];
        movesPlayed.add("black played" + move);

    }

    private void startMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        ChessGameController.movePiece(from, to, this.board);
        isGameFinished();


    }


    private void isGameFinished() {
        if (checkMate()) {
            if (currentPlayer.isWhiteSide()) {
                gameState = GameState.WHITE_WIN;


            } else
                gameState = GameState.BLACK_WIN;
            isDone = true;

        }
    }


    public boolean checkMate() {
        return false;
    }


    public void printWinnerName() {
        if (gameState == GameState.WHITE_WIN) {
            System.out.println(players[0].getName() + " wins!");
        } else if (gameState == GameState.BLACK_WIN) {
            System.out.println(players[1].getName() + " wins!");
        } else {
            System.out.println("Draw!");
        }

    }


    public boolean isWhiteTurn() {
        return currentPlayer.isWhiteSide();
    }

    public boolean isDone() {
        return isDone;
    }

    public void printPlayedMove() {
        for (String move : movesPlayed) {
            System.out.println(move);
        }
    }


    public ChessBoard getBoard() {
        return board;
    }

}







