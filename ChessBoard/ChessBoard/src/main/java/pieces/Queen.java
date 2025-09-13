package pieces;

import org.example.Board;

import java.awt.image.BufferedImage;

public class Queen extends Piece{
    public Queen(Board board, int col, int row, boolean iswhite) {
        super(board);this.col = col;
        this.row = row;
        this.xPos = col* board.tileSize;
        this.yPos = row* board.tileSize;


        this.iswhite = iswhite;
        this.name="Queen";

        this.sprite = sheet.getSubimage( sheetScale,iswhite? 0 : sheetScale,
                sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);


    }
    public boolean isValidMovement(int col, int row){
        return this.col == col || this.row ==row || Math.abs(this.col - col) ==Math.abs(this.row - row);
    }

    public boolean moveCollidewithPiece(int col, int row){
        if (this.col == col || this.row ==row) {
            //left
            if (this.col > col)
                for (int c = this.col - 1; c > col; c--)
                    if (board.getPiece(c, this.row) != null)
                        return true;
            //right
            if (this.col < col)
                for (int c = this.col - 1; c < col; c++)
                    if (board.getPiece(c, this.row) != null)
                        return true;

            //up
            if (this.row > row)
                for (int r = this.row - 1; r > row; r--)
                    if (board.getPiece(this.col, r) != null)
                        return true;
            //down
            if (this.row < row)
                for (int r = this.row - 1; r < row; r++)
                    if (board.getPiece(this.col, r) != null)
                        return true;
        }else{

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

        }


        return false;
    }
}

