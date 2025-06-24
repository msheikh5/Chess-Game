package models.piece;

import models.MovablePiece;
import models.Piece;
import models.board.ChessBoard;
import models.board.Square;

public class Pawn extends MovablePiece implements PieceNormalMove {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(Square start, Square stop, ChessBoard board) {
        int x=Math.abs(start.getXPosition()-stop.getXPosition());
        int y=Math.abs(start.getYPosition()-stop.getYPosition());
        if ((start.getPiece().isWhite() && start.getYPosition()==2) || (!start.getPiece().isWhite() && start.getYPosition()==7)) {
            if ((y==2|| y==1) && x==0 )
            {
                return true;
            }
        }
        else if (x==1&& y==1&& stop.getPiece()!=null)
            return true;

            else if (x==0 && y==1 && stop.getPiece()==null)
                return true;

        return false;
    }

    @Override
    public void move(Square start, Square stop) {
    this.moveNormal(start,stop);
    }

    @Override
    public void moveNormal(Square start, Square end) {
        if (end.getYPosition()==1 || end.getYPosition()==8)
        {
            pawnPromotion(start,end);
        }
        else {
            start.setPiece(null);
            end.setPiece(this);
        }
    }

    @Override
    public String toString(){
        if(isWhite()){
            return "WP";
        }
        else{
            return "BP";
        }
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pawn)) return false;
        Pawn pawn=(Pawn) o;
        return this.isWhite()==pawn.isWhite();

    }

    public void pawnPromotion(Square start, Square end) {
        Piece q = new Queen(start.getPiece().isWhite());
        start.setPiece(null);
        end.setPiece(q);
    }


}
