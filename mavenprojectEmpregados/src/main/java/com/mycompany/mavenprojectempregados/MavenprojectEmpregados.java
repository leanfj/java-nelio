/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectempregados;

import entities.Empregado;
import entities.EmpregadoTerceirizado;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectEmpregados {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        List<Empregado> empregados = new ArrayList<>();

        System.out.println("Entre com o numero de empregados");

        Integer quantidaeEmpregados = scanner.nextInt();

        for (Integer i = 1; i <= quantidaeEmpregados; i++) {
            System.out.println("Dados do empregado #" + i + " :");
            System.out.print("Empregado terceirizado (y/n)?: ");
            Character opcao = scanner.next().charAt(0);
            System.out.print("Nome: ");
            scanner.nextLine();
            String nome = scanner.nextLine();
            System.out.print("Horas trabalhadas: ");
            Integer horas = scanner.nextInt();
            System.out.print("Valor por hora trabalhada: ");
            Double horasTrabalhadas = scanner.nextDouble();

            if (opcao == 'y') {
                System.out.print("Valor de carga extra: ");
                Double cargaAdicional = scanner.nextDouble();
                Empregado empregado = new EmpregadoTerceirizado(cargaAdicional, nome, horas, horasTrabalhadas);
                empregados.add(empregado);
            } else {
                Empregado empregado = new Empregado(nome, horas, horasTrabalhadas);
                empregados.add(empregado);
            }

        }
        System.out.println("");
        System.out.println("Pagamentos");
        for (Empregado empregado : empregados) {
            System.out.println(empregado.getNome() + " - R$ " + empregado.pagamento());
        }
    }
}
