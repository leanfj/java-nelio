/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectvetoresprodutos;

import entities.Produto;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectVetoresProdutos {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner;
        scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        Produto[] vect = new Produto[n];
        
        for (int i = 0; i < vect.length; i++) {
            scanner.nextLine();
            String nome = scanner.nextLine();
            double preco = scanner.nextDouble();
            
            vect[i] = new Produto(nome, preco);
            
        }
        
        double soma = 0.0;
        
        for (int i = 0; i < vect.length; i++) {
            soma += vect[i].getPreco();
        }
        
        double media = soma / vect.length;
        
        System.out.printf("A media de preços é: %.2f%n", media );
        scanner.close();
       
    }
}
