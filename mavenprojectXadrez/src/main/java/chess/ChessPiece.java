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

    public ChessPiece(Color color, Board board, char code) {
        super(board);
        this.color = color;
        this.code = code;
    }

    public Color getColor() {
        return color;
    }

    public char getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "" + code;
    }
    
    protected boolean isThereOpponentePiece(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.getColor() != this.color;
        
        
    }
}
