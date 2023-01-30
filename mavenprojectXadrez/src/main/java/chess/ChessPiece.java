/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 *
 * @author leandro
 */
public class ChessPiece extends Piece {
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
    
}
