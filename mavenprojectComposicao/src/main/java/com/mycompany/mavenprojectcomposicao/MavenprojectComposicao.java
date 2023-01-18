/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectcomposicao;

import entidades.ContratoPorHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.LevelTrabalhador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class MavenprojectComposicao {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatoDeData = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com o nome do departamento");
        String nomeDepartamento = scanner.nextLine();

        System.out.println("Entre com os dados do trabalhador");

        System.out.println("Nome: ");
        String nomeTrabalhador = scanner.nextLine();

        System.out.println("Level: ");
        String levelTrabalhador = scanner.nextLine();

        System.out.println("Salário base :");
        double salarioBase = scanner.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, LevelTrabalhador.valueOf(levelTrabalhador), salarioBase, new Departamento(nomeDepartamento));

        System.out.println("Quantos contratos o trabalhador " + trabalhador.getNome() + " poussui ?");

        int contratos = scanner.nextInt();
        
        for (int i = 1; i <= contratos; i++) {
            System.out.println("Dados do contrato #" + i);
            
            System.out.println("Data (DD/MM/AAAA) :");
            Date dataContrato = formatoDeData.parse(scanner.next());
            
            System.out.println("Valor por hora :");
            double valorPorHora = scanner.nextDouble();
            
            System.out.println("Duração em horas :");
            Integer duracao = scanner.nextInt();
            
            ContratoPorHora contratoPorHora = new ContratoPorHora(dataContrato, valorPorHora, duracao);
            
            trabalhador.adicionarContrato(contratoPorHora);
            //System.out.println("Valor Contrato" + contratoPorHora.valorTotal());
        }
        
        System.out.println("Entre com o ano/mês de referencia para calculo do pagamento :");
        String anoReferencia = scanner.next();
        
        String mes = anoReferencia.substring(0, 2);
        int mesConvertido = Integer.parseInt(mes);
        
        String ano = anoReferencia.substring(3);
        int anoConvertido = Integer.parseInt(ano);
        
        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        
        String pagamento = String.format("%.2f", trabalhador.pagamento(anoConvertido, mesConvertido));
        System.out.println("Pagamento: " + anoReferencia + " : " + pagamento);
        
        scanner.close();

    }
}
