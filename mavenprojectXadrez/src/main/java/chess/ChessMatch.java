/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 *
 * @author leandro
 */
public class ChessMatch {
    
    private Board board;
    
    public ChessMatch() {
        this.board = new Board(8, 8);
        this.initialSetup();
    }
    
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        
        return mat;
    }
    
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    
    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE, 'R'));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE, 'R'));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE, 'R'));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE, 'R'));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE, 'R'));
        placeNewPiece('d', 1, new King(board, Color.WHITE, 'K'));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK, 'R'));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK, 'R'));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK, 'R'));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK, 'R'));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK, 'R'));
        placeNewPiece('d', 8, new King(board, Color.BLACK, 'K'));
    }
}