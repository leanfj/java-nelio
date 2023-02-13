/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author leandro
 */
public class Rook extends ChessPiece {

    public Rook(Board board, Color color, char code) {
        super(color, board, code);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        
        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        
        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        
        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

}
