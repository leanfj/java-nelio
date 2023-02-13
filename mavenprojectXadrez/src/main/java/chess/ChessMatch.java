/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leandro
 */
public class ChessMatch {

    private Board board;
    private int turn;
    private Color currentPlayer;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        this.board = new Board(8, 8);
        this.turn = 1;
        this.currentPlayer = Color.WHITE;
        this.initialSetup();
    }

    public int getTurn() {
        return this.turn;
    }

    public Color getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];

        for (int i = 0; i < this.board.getRows(); i++) {
            for (int j = 0; j < this.board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) this.board.piece(i, j);
            }
        }

        return mat;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        this.validateSourcePosition(position);
        return board.piece(position).possibleMoves();

    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        this.validateSourcePosition(source);
        this.validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        this.nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        this.placeNewPiece('c', 1, new Rook(board, Color.WHITE, 'R'));
        this.placeNewPiece('c', 2, new Rook(board, Color.WHITE, 'R'));
        this.placeNewPiece('d', 2, new Rook(board, Color.WHITE, 'R'));
        this.placeNewPiece('e', 2, new Rook(board, Color.WHITE, 'R'));
        this.placeNewPiece('e', 1, new Rook(board, Color.WHITE, 'R'));
        this.placeNewPiece('d', 1, new King(board, Color.WHITE, 'K'));

        this.placeNewPiece('c', 7, new Rook(board, Color.BLACK, 'R'));
        this.placeNewPiece('c', 8, new Rook(board, Color.BLACK, 'R'));
        this.placeNewPiece('d', 7, new Rook(board, Color.BLACK, 'R'));
        this.placeNewPiece('e', 7, new Rook(board, Color.BLACK, 'R'));
        this.placeNewPiece('e', 8, new Rook(board, Color.BLACK, 'R'));
        this.placeNewPiece('d', 8, new King(board, Color.BLACK, 'K'));
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (this.currentPlayer != ((ChessPiece) this.board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }
        if (!board.piece(position).isTherAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece!");
        }
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = this.board.removePiece(source);
        Piece capturedPiece = this.board.removePiece(target);
        
        this.board.placePiece(p, target);
        
        if(capturedPiece != null) {
            this.piecesOnTheBoard.remove(capturedPiece);
            this.capturedPieces.add(capturedPiece);
        }
        
        
        return capturedPiece;
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!this.board.piece(source).possibleMove(target)) {
            throw new ChessException("The chose piece can't move to target position");
        }
    }

    private void nextTurn() {
        this.turn++;
        this.currentPlayer = (this.currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;

    }
}
