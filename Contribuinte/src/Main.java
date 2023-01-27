import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Contribuinte> listaContribuintes = new ArrayList<>();

        System.out.print("Entre com o numero de Contribiuntes: ");

        int numeroContribuintes = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numeroContribuintes; i++) {
            System.out.printf("Dados do contribuinte #%d \n", i  + 1);
            System.out.print("Pessoa Física ou Pessoa Juridica (F/J)? ");
            Character opcao = scanner.nextLine().charAt(0);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Recebimento anual: ");
            double recebimentoAnual = scanner.nextDouble();
            if(opcao.equals('F')) {
                System.out.print("Gastos Médicos: ");
                double gastoMedicos = scanner.nextDouble();
                scanner.nextLine();
                listaContribuintes.add(new PessoaFisica(nome, recebimentoAnual, gastoMedicos));
            } else {
                System.out.print("Numero Empregados: ");
                Integer numeroEmpregados = scanner.nextInt();
                scanner.nextLine();
                listaContribuintes.add(new PessoaJuridica(nome, recebimentoAnual, numeroEmpregados));
            }

        }
        Double totalImpostos = 0.0;
        for (Contribuinte contribuinte: listaContribuintes) {
            System.out.printf("%s  $ : %.2f%n", contribuinte.getNome(), contribuinte.imposto());
            totalImpostos += contribuinte.imposto();
        }

        System.out.printf("TOTAL IMPOSTOS $ %.2f%n", totalImpostos);

        scanner.close();
    }
}