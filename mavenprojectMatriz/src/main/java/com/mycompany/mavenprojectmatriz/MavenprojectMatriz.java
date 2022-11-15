/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectmatriz;

import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectMatriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int[][] matriz = new int[n][n];
        
        for(int i = 0; i < matriz.length; i++) {

            for(int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Diagonal principal");
        
        int[] diagonalPrincipal = new int[3];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(i == j) {
                    diagonalPrincipal[i] = matriz[i][j];
                }
                
            }
            
        }
        
        for (int i = 0; i < diagonalPrincipal.length; i++) {
            System.out.println(diagonalPrincipal[i]);
        }
        
        int quantidadeNegativos = 0;
        
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] < 0) {
                    quantidadeNegativos++;
                }
            }
        }
        System.out.println("Quantidade de negativos: " + quantidadeNegativos );
        
        
        scanner.close();
    }
}
