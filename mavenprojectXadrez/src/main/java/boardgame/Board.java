/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boardgame;

/**
 *
 * @author leandro
 */
public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
        
    }
    
    public Piece piece(int row, int column) {
        return this.pieces[row][column];
    }
    
    public Piece piece(Position position) {
        return this.pieces[position.getRow()][position.getColumn()];
    }
    
    public void placePiece(Piece piece, Position position) {
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
