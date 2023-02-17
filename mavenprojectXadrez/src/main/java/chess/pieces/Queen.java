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
public class Queen extends ChessPiece {

    public Queen(Board board, Color color, char code) {
        super(color, board, code);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
        Position p = new Position(0, 0);

        //above
        p.setValues(this.position.getRow() - 1, this.position.getColumn());
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(this.position.getRow(), this.position.getColumn() - 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(this.position.getRow(), this.position.getColumn() + 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(this.position.getRow() + 1, this.position.getColumn());
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }

        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // nw
        p.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

}
