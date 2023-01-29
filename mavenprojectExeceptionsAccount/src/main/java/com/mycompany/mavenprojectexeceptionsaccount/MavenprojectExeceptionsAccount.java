/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectexeceptionsaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entities.Conta;
import model.exceptions.DomainException;
import sun.awt.X11.XConstants;

/**
 *
 * @author leandro
 */
public class MavenprojectExeceptionsAccount {

    public static void main(String[] args) throws DomainException {
        System.out.println("Programa conta");
        Locale.setDefault(Locale.US);
        try ( Scanner scanner = new Scanner(System.in)) {
            List<Conta> contas = new ArrayList<>();

            boolean controlador = true;

            do {
                System.out.println("Selecione uma operação");
                System.out.println("1 - Cadastrar nova conta");
                System.out.println("2 - Realizar saque");
                System.out.println("3 - Consultar Saldo");
                System.out.println("0 - Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarConta(scanner, contas);
                        break;
                    case 2:
                        try {
                            saqueConta(scanner, contas);
                        } catch (DomainException ex) {
                            System.out.println("Erro ao executar saque: " + ex.getMessage());
                        } finally {
                            break;
                        }
                    case 3:
                        try {
                            saldoConta(scanner, contas);
                        } catch (DomainException ex) {
                            System.out.println("Erro ao executar consulta: " + ex.getMessage());
                        } finally {
                            break;
                        }
                    case 0:
                        System.out.println("Sistema finalizado.");
                        controlador = false;
                        break;
                    default:
                        throw new AssertionError();
                }

            } while (controlador);
        }
    }

    public static void cadastrarConta(Scanner scanner, List<Conta> contas) {
        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        Integer numeroConta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Titular: ");
        String titular = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();
        System.out.print("Limite de saque: ");
        double limiteSaque = scanner.nextDouble();

        Conta conta = new Conta(numeroConta, titular, saldoInicial, limiteSaque);
        contas.add(conta);
    }

    public static void saqueConta(Scanner scanner, List<Conta> contas) throws DomainException {
        if (contas.isEmpty()) {
            throw new DomainException("Lista de contas vazias");
        }
        System.out.print("Selecione uma conta: ");
        Integer numeroContaOperacao = scanner.nextInt();
        Conta contaEncontrada = contas.stream().filter(item -> numeroContaOperacao.equals(item.getNumero())).findAny().orElse(null);
        System.out.print("Informe o valor de saque: ");
        double valorSaque = scanner.nextDouble();

        try {
            contaEncontrada.saque(valorSaque);
        } catch (DomainException ex) {
            System.out.println("Erro ao executar saque: " + ex.getMessage());
        }
    }

    private static void saldoConta(Scanner scanner, List<Conta> contas) throws DomainException {
        if (contas.isEmpty()) {
            throw new DomainException("Lista de contas vazias");
        }
        System.out.print("Selecione uma conta: ");
        Integer numeroContaOperacao = scanner.nextInt();
        Conta contaEncontrada = contas.stream().filter(item -> numeroContaOperacao.equals(item.getNumero())).findAny().orElse(null);

        System.out.printf("Saldo da conta %d : $ %.2f", contaEncontrada.getNumero(), contaEncontrada.getSaldo());

    }
}
