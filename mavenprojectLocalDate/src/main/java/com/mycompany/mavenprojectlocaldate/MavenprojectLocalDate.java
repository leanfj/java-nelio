/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectlocaldate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author leandro
 */
public class MavenprojectLocalDate {

    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:25");
        Instant d06 = Instant.parse("2022-07-20T01:30:25Z");
        
        LocalDate r01 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r02 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r03 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r04 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r01 " + r01);
        System.out.println("r02 " + r02);
        System.out.println("r03 " + r03);
        System.out.println("r04 " + r04);
    }
}
