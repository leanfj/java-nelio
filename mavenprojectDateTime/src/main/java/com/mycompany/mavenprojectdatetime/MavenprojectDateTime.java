/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectdatetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author leandro
 */
public class MavenprojectDateTime {

    public static void main(String[] args) {
        LocalDate d01 = LocalDate.now();

        System.out.println("LocalDate " + d01);

        LocalDateTime d02 = LocalDateTime.now();

        System.out.println("LocalDateTime " + d02);

        Instant d03 = Instant.now();

        System.out.println("Instant " + d03);

        LocalDate d04 = LocalDate.parse("2022-11-14");

        System.out.println("LocalDate D04 " + d04);

        LocalDateTime d05 = LocalDateTime.parse("2022-11-14T22:04:55");

        System.out.println("LocalDateTime D05 " + d05);

        Instant d06 = Instant.parse("2022-11-14T22:04:55Z");

        System.out.println("Instant D06 " + d06);

        Instant d07 = Instant.parse("2020-02-29T01:23:06Z");

        System.out.println("Instant D07 " + d07);
        // So funciona no java 17 pra cima
        // A utilização de um format para o instant necessita de entrar com a definicação do time zone
        
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        System.out.println("d07 " + formato3.format(d07));
        
        DateTimeFormatter formato01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d08 = LocalDate.parse("20/07/2022", formato01);
        
        System.out.println("d08 "  + d08);
        
        System.out.println("d04 " + d04.format(formato01));
        System.out.println("d04 " + formato01.format(d04));
        
        DateTimeFormatter format04 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter format05 = DateTimeFormatter.ISO_INSTANT;
        
        System.out.println("d05 " + d05.format(format04)); 
        
        System.out.println("d06 " + format05.format(d06));
    }
}