/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectformas;

import entities.Circulo;
import entities.Forma;
import entities.Retangulo;
import entities.enums.Color;

/**
 *
 * @author leandro
 */
public class MavenprojectFormas {

    public static void main(String[] args) {
        Forma retangulo = new Retangulo(2.0, 1.0, Color.VERDE);
        Forma circulo = new Circulo(2.0, Color.AZUL);

        System.out.printf("Area retangulo: %.2f \n", retangulo.area());
        System.out.printf("Area circulo: %.2f", circulo.area());

    }
}
