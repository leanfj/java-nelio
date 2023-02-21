/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Kinght;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author leandro
 */
public class ChessMatch {

    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean checkMate;
    private boolean check;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;

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

    public boolean getCheck() {
        return this.check;
    }

    public Color getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
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
        return this.board.piece(position).possibleMoves();

    }

    public boolean getCheckMate() {
        return this.checkMate;
    }

    private boolean testCheckMate(Color color) {
        if (!testCheck(color)) {
            return false;
        }

        List<Piece> list = this.piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).collect(Collectors.toList());
        for (Piece p : list) {
            boolean[][] mat = p.possibleMoves();
            for (int i = 0; i < this.board.getRows(); i++) {
                for (int j = 0; j < this.board.getColumns(); j++) {
                    if (mat[i][j]) {
                        Position source = ((ChessPiece) p).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = this.makeMove(source, target);
                        boolean testCheck = this.testCheck(color);

                        this.undoMove(source, target, capturedPiece);
                        if (!testCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        this.validateSourcePosition(source);
        this.validateTargetPosition(source, target);
        Piece capturedPiece = this.makeMove(source, target);
        if (this.testCheck(this.currentPlayer)) {
            this.undoMove(source, target, capturedPiece);
            throw new ChessException("You can't put yourself in check");
        }

        ChessPiece movedPiece = (ChessPiece) board.piece(target);
        promoted = null;
        if (movedPiece instanceof Pawn) {
            if ((movedPiece.getColor() == Color.WHITE && target.getRow() == 0) || (movedPiece.getColor() == Color.BLACK && target.getRow() == 7)) {
                this.promoted = (ChessPiece) this.board.piece(target);

                this.promoted = replacePromotedPiece("Q");

            }
        }

        this.check = (this.testCheck(this.opponent(this.currentPlayer))) ? true : false;

        if (this.testCheckMate(this.opponent(this.currentPlayer))) {
            this.checkMate = true;
        } else {
            this.nextTurn();
        }

        if (movedPiece instanceof Pawn && (target.getRow() == source.getRow() - 2 || target.getRow() == source.getRow() + 2)) {
            enPassantVulnerable = movedPiece;
        } else {
            enPassantVulnerable = null;
        }

        return (ChessPiece) capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
        this.piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        this.placeNewPiece('a', 1, new Rook(this.board, Color.WHITE, '\u2656'));
        this.placeNewPiece('b', 1, new Kinght(this.board, Color.WHITE, '\u2658'));
        this.placeNewPiece('c', 1, new Bishop(this.board, Color.WHITE, '\u2657'));
        this.placeNewPiece('d', 1, new Queen(this.board, Color.WHITE, '\u2655'));
        this.placeNewPiece('e', 1, new King(this.board, Color.WHITE, '\u2654', this));
        this.placeNewPiece('f', 1, new Bishop(this.board, Color.WHITE, '\u2657'));
        this.placeNewPiece('g', 1, new Kinght(this.board, Color.WHITE, '\u2658'));
        this.placeNewPiece('h', 1, new Rook(this.board, Color.WHITE, '\u2656'));

        this.placeNewPiece('a', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));
        this.placeNewPiece('b', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));
        this.placeNewPiece('c', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));
        this.placeNewPiece('d', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));
        this.placeNewPiece('e', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));
        this.placeNewPiece('f', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));
        this.placeNewPiece('g', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));
        this.placeNewPiece('h', 2, new Pawn(this.board, Color.WHITE, '\u2659', this));

        this.placeNewPiece('a', 8, new Rook(this.board, Color.BLACK, '\u265C'));
        this.placeNewPiece('b', 8, new Kinght(this.board, Color.BLACK, '\u265E'));
        this.placeNewPiece('c', 8, new Bishop(this.board, Color.BLACK, '\u265D'));
        this.placeNewPiece('d', 8, new Queen(this.board, Color.BLACK, '\u265B'));
        this.placeNewPiece('e', 8, new King(this.board, Color.BLACK, '\u265A', this));
        this.placeNewPiece('f', 8, new Bishop(this.board, Color.BLACK, '\u265D'));
        this.placeNewPiece('g', 8, new Kinght(this.board, Color.BLACK, '\u265E'));
        this.placeNewPiece('h', 8, new Rook(this.board, Color.BLACK, '\u265C'));

        this.placeNewPiece('a', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));
        this.placeNewPiece('b', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));
        this.placeNewPiece('c', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));
        this.placeNewPiece('d', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));
        this.placeNewPiece('e', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));
        this.placeNewPiece('f', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));
        this.placeNewPiece('g', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));
        this.placeNewPiece('h', 7, new Pawn(this.board, Color.BLACK, '\u265F', this));

    }

    private void validateSourcePosition(Position position) {
        if (!this.board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (this.currentPlayer != ((ChessPiece) this.board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }
        if (!this.board.piece(position).isTherAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece!");
        }
    }

    private Piece makeMove(Position source, Position target) {
        ChessPiece p = (ChessPiece) this.board.removePiece(source);
        p.increaseMoveCount();
        Piece capturedPiece = this.board.removePiece(target);

        this.board.placePiece(p, target);

        if (capturedPiece != null) {
            this.piecesOnTheBoard.remove(capturedPiece);
            this.capturedPieces.add(capturedPiece);
        }

        //castling kingside rook
        if (p instanceof King && target.getColumn() == source.getColumn() + 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
            Position targetT = new Position(source.getRow(), source.getColumn() + 1);
            ChessPiece rook = ((ChessPiece) this.board.removePiece(sourceT));
            this.board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }

        //castling queenside rook
        if (p instanceof King && target.getColumn() == source.getColumn() - 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
            Position targetT = new Position(source.getRow(), source.getColumn() - 1);
            ChessPiece rook = ((ChessPiece) this.board.removePiece(sourceT));
            this.board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }

        if (p instanceof Pawn) {
            if (source.getColumn() != target.getColumn() && capturedPiece == null) {
                Position pawnPosition;

                if (p.getColor() == Color.WHITE) {
                    pawnPosition = new Position(target.getRow() + 1, target.getColumn());
                } else {
                    pawnPosition = new Position(target.getRow() - 1, target.getColumn());

                }

                capturedPiece = this.board.removePiece(pawnPosition);

                capturedPieces.add(capturedPiece);

                piecesOnTheBoard.remove(capturedPiece);
            }
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

    public void undoMove(Position source, Position target, Piece capturedPiece) {
        ChessPiece p = (ChessPiece) this.board.removePiece(target);
        p.decreaseMoveCount();
        this.board.placePiece(p, source);

        if (capturedPiece != null) {
            this.board.placePiece(capturedPiece, target);
            this.capturedPieces.remove(capturedPiece);
            this.piecesOnTheBoard.add(capturedPiece);
        }

        //castling kingside rook
        if (p instanceof King && target.getColumn() == source.getColumn() + 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
            Position targetT = new Position(source.getRow(), source.getColumn() + 1);
            ChessPiece rook = ((ChessPiece) this.board.removePiece(targetT));
            this.board.placePiece(rook, sourceT);
            rook.decreaseMoveCount();
        }

        //castling queenside rook
        if (p instanceof King && target.getColumn() == source.getColumn() - 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
            Position targetT = new Position(source.getRow(), source.getColumn() - 1);
            ChessPiece rook = ((ChessPiece) this.board.removePiece(targetT));
            this.board.placePiece(rook, sourceT);
            rook.decreaseMoveCount();
        }

        if (p instanceof Pawn) {
            if (source.getColumn() != target.getColumn() && capturedPiece == enPassantVulnerable) {
                ChessPiece pawn = (ChessPiece) this.board.removePiece(target);
                Position pawnPosition;

                if (p.getColor() == Color.WHITE) {
                    pawnPosition = new Position(3, target.getColumn());
                } else {
                    pawnPosition = new Position(4, target.getColumn());

                }

                this.board.placePiece(pawn, pawnPosition);
            }
        }
    }

    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color) {
        List<Piece> list = this.piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).collect(Collectors.toList());
        for (Piece p : list) {
            if (p instanceof King) {
                return (ChessPiece) p;
            }
        }

        throw new IllegalStateException("There is no " + color + " king in board");
    }

    private boolean testCheck(Color color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = this.piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == opponent(color)).collect(Collectors.toList());
        for (Piece p : opponentPieces) {
            boolean[][] mat = p.possibleMoves();
            if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }

        return false;
    }

    public ChessPiece replacePromotedPiece(String type) {
        if (this.promoted == null) {
            throw new IllegalStateException("There is no piece to be promoted");

        }

        if (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
            throw new InvalidParameterException("Invalid type for Promotion");

        }

        Position pos = this.promoted.getChessPosition().toPosition();

        Piece p = this.board.removePiece(pos);

        this.piecesOnTheBoard.remove(p);

        ChessPiece newPiece = newPiece(type, promoted.getColor());
        this.board.placePiece(newPiece, pos);
        this.piecesOnTheBoard.add(newPiece);

        return newPiece;

    }

    private ChessPiece newPiece(String type, Color color) {
        ChessPiece piece;

        switch (type) {
            case "B":
                piece = new Bishop(this.board, color, '\u2657');
                break;
            case "N":
                piece = new Kinght(this.board, color, '\u2657');
                break;
            case "Q":
                piece = new Queen(this.board, color, '\u2655');
                break;
            default:
                piece = new Rook(this.board, color, '\u265C');
        }

        return piece;

    }

}
