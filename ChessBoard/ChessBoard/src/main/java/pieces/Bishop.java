package pieces;

import org.example.Board;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{
    public Bishop(Board board, int col, int row, boolean iswhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;


        this.iswhite = iswhite;
        this.name = "Queen";

        this.sprite = sheet.getSubimage(2 * sheetScale, iswhite ? 0 : sheetScale,
                sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int col, int row){
        return Math.abs(this.col - col) ==Math.abs(this.row - row);
    }

    public boolean moveCollidewithPiece(int col, int row){


        //upleft
        if(this.col > col && this.row > row )
            for (int i = 1; i< Math.abs(this.col - col); i++)
                if(board.getPiece(this.col - i, this.row - 1) !=null)
                    return true;
        //upright
        if(this.col < col && this.row > row )
            for (int i = 1; i< Math.abs(this.col - col); i++)
                if(board.getPiece(this.col + i, this.row - 1) !=null)
                    return true;

        //downleft
        if(this.col > col && this.row < row )
            for (int i = 1; i< Math.abs(this.col - col); i++)
                if(board.getPiece(this.col - i, this.row + 1) !=null)
                    return true;
        //downright
        if(this.col < col && this.row < row )
            for (int i = 1; i< Math.abs(this.col - col); i++)
                if(board.getPiece(this.col + i, this.row + 1) !=null)
                    return true;

        return false;
    }
}
