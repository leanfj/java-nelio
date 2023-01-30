/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import chess.ChessPiece;

/**
 *
 * @author leandro
 */
public class UI {

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.println();
            System.out.println();

        }
        System.out.println("   a    b    c    d    e    f    g    h");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print(" -- ");
        } else {
            System.out.print(piece);

        }
        System.out.print(" ");

    }
}
