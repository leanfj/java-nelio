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
public class Kinght extends ChessPiece {

    public Kinght(Board board, Color color, char code) {
        super(color, board, code);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position p = new Position(0, 0);

        p.setValues(this.position.getRow() - 1, position.getColumn() - 2);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() - 2, position.getColumn() - 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() - 2, position.getColumn() + 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() - 1, position.getColumn() + 2);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() + 1, position.getColumn() + 2);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() + 2, position.getColumn() + 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() + 2, position.getColumn() - 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() + 1, position.getColumn() - 2);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) this.getBoard().piece(position);

        return p == null || p.getColor() != this.getColor();
    }

}
