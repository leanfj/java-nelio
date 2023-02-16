/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 *
 * @author leandro
 */
public abstract class ChessPiece extends Piece {
    private Color color;
    private char code;
    private int moveCount;

    public ChessPiece(Color color, Board board, char code) {
        super(board);
        this.color = color;
        this.code = code;
    }

    public Color getColor() {
        return this.color;
    }

    public char getCode() {
        return this.code;
    }
    
    public int getMoveCount() {
        return this.moveCount;
    }
    
    protected void increaseMoveCount() {
        this.moveCount++;
    }
    
    protected void decreaseMoveCount() {
        this.moveCount--;
    }

    @Override
    public String toString() {
        return "" + this.code;
    }
    
    protected boolean isThereOpponentePiece(Position position) {
        ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
        return piece != null && piece.getColor() != this.color;
        
        
    }
    
    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
}
