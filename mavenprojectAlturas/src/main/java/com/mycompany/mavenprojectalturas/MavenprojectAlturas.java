/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectalturas;

import entities.Pessoa;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectAlturas {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Sistema de Alturas");

        System.out.println("Quantas pessoas serão digitadas:");

        int n = scanner.nextInt();

        Pessoa[] listaPessoas = new Pessoa[n];

        for (int i = 0; i < listaPessoas.length; i++) {
            System.out.println("Dados da " + i + "a pessoa:");
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            System.out.print("Altura: ");
            double altura = scanner.nextDouble();

            listaPessoas[i] = new Pessoa(nome, idade, altura);

        }

        double somatorioAlturas = 0.0;

        for (int i = 0; i < listaPessoas.length; i++) {
            Pessoa listaPessoa = listaPessoas[i];
            somatorioAlturas += listaPessoa.getAltura();
        }

        double mediaAlturas = somatorioAlturas / listaPessoas.length;

        System.out.printf("Média de alturas de pessoas: %.2f %n", mediaAlturas);

        int quantidadePessoasMenorde16 = 0;
        for (int i = 0; i < listaPessoas.length; i++) {
            if (listaPessoas[i].getIdade() < 16) {
                quantidadePessoasMenorde16++;
            }
        }

        System.out.println("---Pessoas menores de 16 anos---");
        double porcentagem = (quantidadePessoasMenorde16 * 100.0) / listaPessoas.length;
        System.out.printf("Porcentagem de pessoas menor: %.1f%%%n", porcentagem);

        System.out.println("Pessao com menos de 16 anos");
        for (int i = 0; i < listaPessoas.length; i++) {
            if (listaPessoas[i].getIdade() < 16) {
                System.out.println(listaPessoas[i]);
            }
        }

        scanner.close();
    }
}
