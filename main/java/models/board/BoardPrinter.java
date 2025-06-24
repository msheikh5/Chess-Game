package models.board;

public class BoardPrinter {
    private ChessBoard board;

    public BoardPrinter(ChessBoard board) {
        this.board = board;
    }

    public void printBoard() {
        int i = 8;
        for (int row = 7; row >= 0; row--) {
            System.out.println("");
            if (row == 7)
                System.out.println("   A     B     C     D     E     F     G     H");

            System.out.println("----------------------------------------------------------");

            for (int column = 0; column < 8; column++) {
                if (column == 0)
                    System.out.print(i);
                if (board.getSquare(column, row).getPiece() == null) {
                    System.out.print("|     ");
                } else {
                    System.out.printf("| %s", board.getSquare(column, row).getPiece().toString() + " " + " ");
                }
                if (column == 7)
                    System.out.print(i);
            }

            i--;
        }
        System.out.println("");
        System.out.println("----------------------------------------------------------");
        System.out.println("   A     B     C     D     E     F     G     H");

    }
}
