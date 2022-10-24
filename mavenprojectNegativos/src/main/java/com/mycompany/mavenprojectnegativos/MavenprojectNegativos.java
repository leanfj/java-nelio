/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectnegativos;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectNegativos {

    public static void main(String[] args) {
        System.out.println("Numeros negativos em vetor");
        Locale.setDefault(Locale.US);
        Scanner scanner;
        scanner = new Scanner(System.in);
        
        System.out.println("Quantos numeros você vai digitar: ");
        int n = scanner.nextInt();
        
        Integer[] vect = new Integer[n];
        
        for(int i = 0; i < vect.length; i++) {
            System.out.println("Digite um número: ");
            int numero = scanner.nextInt();
            vect[i] = numero;
        }
        
        System.out.println("Números negativos: ");
        for (int i = 0; i < vect.length; i++) {
            
            if(vect[i] < 0) {
                System.out.printf("%d %n", vect[i]);
            }
            
        }
        
        scanner.close();
        
    }
}
 