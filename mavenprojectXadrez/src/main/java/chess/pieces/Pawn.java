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
public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, char code, ChessMatch chessMatch) {
        super(color, board, code);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (this.getColor() == Color.WHITE) {
            //Above 1 movement
            p.setValues(this.position.getRow() - 1, this.position.getColumn());
            if (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //First movement
            p.setValues(this.position.getRow() - 2, this.position.getColumn());
            Position p2 = new Position(this.position.getRow() - 1, this.position.getColumn());
            if (this.isPossibleFirstMovent(p, p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //diagonal left
            p.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
            if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //diagonal rigth 
            p.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
            if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            if (this.position.getRow() == 3) {
                Position left = new Position(this.position.getRow(), position.getColumn() - 1);
                if (this.getBoard().positionExists(left) && this.isThereOpponentePiece(left) && this.getBoard().piece(left) == this.chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }

                Position right = new Position(this.position.getRow(), position.getColumn() + 1);
                if (this.getBoard().positionExists(right) && this.isThereOpponentePiece(right) && this.getBoard().piece(right) == this.chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        } else {
            //Above 1 movement
            p.setValues(this.position.getRow() + 1, this.position.getColumn());
            if (this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //First movement
            p.setValues(this.position.getRow() + 2, this.position.getColumn());
            Position p2 = new Position(this.position.getRow() + 1, this.position.getColumn());
            if (this.isPossibleFirstMovent(p, p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //diagonal left
            p.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
            if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //diagonal rigth
            p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
            if (this.getBoard().positionExists(p) && this.isThereOpponentePiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            if (this.position.getRow() == 4) {
                Position left = new Position(this.position.getRow(), position.getColumn() - 1);
                if (this.getBoard().positionExists(left) && this.isThereOpponentePiece(left) && this.getBoard().piece(left) == this.chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }

                Position right = new Position(this.position.getRow(), position.getColumn() + 1);
                if (this.getBoard().positionExists(right) && this.isThereOpponentePiece(right) && this.getBoard().piece(right) == this.chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        return mat;
    }

    private boolean isPossibleFirstMovent(Position p, Position p2) {
        return this.getBoard().positionExists(p) && !this.getBoard().thereIsAPiece(p) && this.getBoard().positionExists(p2) && !this.getBoard().thereIsAPiece(p2) && this.getMoveCount() == 0;
    }

}
