/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectforeach;

/**
 *
 * @author leandro
 */
public class MavenprojectForEach {

    public static void main(String[] args) {
        String[] vect = new String[] {"Maria", "Bob", "Alex"};
        
        for(int i = 0; i < vect.length; i++) {
            System.out.println("#" + i + " -> " + vect[i]);
        }
        
        int i = 0;
        for(String pessoa: vect) {
            System.out.println("#" + i + " -> " + pessoa);
            i++;
        }
    }
}
