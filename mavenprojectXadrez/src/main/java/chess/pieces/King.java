/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author leandro
 */
public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, char code, ChessMatch chessMatch) {
        super(color, board, code);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above 
        p.setValues(this.position.getRow() - 1, position.getColumn());

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(this.position.getRow() + 1, position.getColumn());

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(this.position.getRow(), position.getColumn() - 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // rigth
        p.setValues(this.position.getRow(), position.getColumn() + 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //nw
        p.setValues(this.position.getRow() - 1, position.getColumn() - 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValues(this.position.getRow() - 1, position.getColumn() + 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValues(this.position.getRow() + 1, position.getColumn() + 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sw
        p.setValues(this.position.getRow() + 1, position.getColumn() - 1);

        if (this.getBoard().positionExists(p) && this.canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Special move Castling
        if (this.getMoveCount() == 0 && !this.chessMatch.getCheck()) {
            //castling kingside rook
            Position posT1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
            if (this.testeRookCastling(posT1)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() + 2);

                if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null) {
                    mat[this.position.getRow()][this.position.getColumn() + 2] = true;
                }
            }

            //castling qeenside rook
            Position posT2 = new Position(this.position.getRow(), this.position.getColumn() - 4);
            if (this.testeRookCastling(posT2)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
                Position p3 = new Position(this.position.getRow(), this.position.getColumn() - 3);

                if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null && this.getBoard().piece(p3) == null) {
                    mat[this.position.getRow()][this.position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) this.getBoard().piece(position);

        return p == null || p.getColor() != this.getColor();
    }

    private boolean testeRookCastling(Position position) {
        ChessPiece p = (ChessPiece) this.getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;

    }

}
