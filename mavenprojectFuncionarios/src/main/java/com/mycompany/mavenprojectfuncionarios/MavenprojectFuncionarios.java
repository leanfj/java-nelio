/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectfuncionarios;

import entities.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectFuncionarios {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner;

        scanner = new Scanner(System.in);

        System.out.println("Exercício Funcionários");
        System.out.println("Quanto funcionário que registrar ?");

        int n = scanner.nextInt();

        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

        for (int i = 0; i < n; i++) {
            System.out.println("Funcionário #" + i);
            System.out.println("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("Salario: ");
            Double salario = scanner.nextDouble();

            Funcionario funcionario = new Funcionario(id, nome, salario);
            listaFuncionarios.add(funcionario);

        }

        System.out.println("Informe o ID do funcionario que deseja dar aumento: ");
        int idParaBusca = scanner.nextInt();

        Funcionario funcionarioAchado = listaFuncionarios.stream().filter(item -> item.getId() == idParaBusca).findFirst().orElse(null);

        if (funcionarioAchado != null) {
            System.out.println("Quantos porcento de aumento");

            double porcentagemAumento = scanner.nextDouble();

            funcionarioAchado.aumentaSalario(porcentagemAumento);

            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(funcionario);
            }
        } else {
            System.out.println("Funcionário não existe");
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(funcionario);
            }
        }

        scanner.close();
    }
}
