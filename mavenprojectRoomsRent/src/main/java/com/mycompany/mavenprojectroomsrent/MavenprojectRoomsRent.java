/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectroomsrent;

import entities.Rent;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectRoomsRent {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner;
        scanner = new Scanner(System.in);
        
        Rent[] vector = new Rent[10];
        
        System.out.println("Quanto quartos deseja alugar");
        int n = scanner.nextInt();
        
        for (int i = 0; i <= n; i++) {
            System.out.println("Rent #" + i + ":");
            System.out.println("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.next();
            System.out.println("Room: ");
            int roomNumber = scanner.nextInt();
            
            vector[roomNumber] = new Rent(name, email);           
        }
        
        System.out.println("Quartos ocupados");
        for (int i = 0; i < vector.length; i++) {
            if(vector[i] != null) {
                System.out.println("Room #" + i + ":");
                System.out.println(vector[i]);
            }
            
        }
        
        scanner.close();
    }
}
