/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectformas;

import entities.Circulo;
import entities.Forma;
import entities.Retangulo;
import entities.enums.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leandro
 */
public class MavenprojectFormas {

    public static void main(String[] args) {

        List<Forma> lista = new ArrayList<>();

        Forma retangulo = new Retangulo(2.0, 1.0, Color.VERDE);
        Forma circulo = new Circulo(2.0, Color.AZUL);

        lista.add(retangulo);
        lista.add(circulo);

        for (Forma forma : lista) {
            System.out.printf("Area: %.2f \n", forma.area());
        }

    }
}
