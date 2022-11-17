/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectcalculodata;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author leandro
 */
public class MavenprojectCalculoData {

    public static void main(String[] args) {
        System.out.println("Calculos com Datas");

        LocalDate d04 = LocalDate.parse("2022-11-17");
        LocalDateTime d05 = LocalDateTime.parse("2022-11-17T20:14:26");
        Instant d06 = Instant.parse("2022-11-17T20:15:26Z");

        LocalDate pastWeekLocalDate = d04.minusDays(3);
        LocalDate nextWeekLocalDate = d04.plusDays(4);
        LocalDate plusYearsLocalDate = d04.plusYears(4);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        System.out.println("plusYearsLocalDate = " + plusYearsLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(3);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(4);
        LocalDateTime plusYearsLocalDateTime = d05.plusYears(4);
        LocalDateTime plusHourLocalDateTime = d05.plusHours(2);

        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
        System.out.println("plusYearsLocalDateTime = " + plusYearsLocalDateTime);
        System.out.println("plusHourLocalDateTime = " + plusHourLocalDateTime);
        
        Instant pastInstant = d06.minus(7, ChronoUnit.DAYS);
        
        System.out.println("pastInstant = " + pastInstant);
        
        Duration t1 = Duration.between(pastInstant, d06);
        System.out.println("t1 = " + t1.toHours());
        
        Duration t2 = Duration.between(nextWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        System.out.println("t2 = " + t2.toDays());
    }
}
