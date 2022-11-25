/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectdateantigo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author leandro
 */
public class MavenprojectDateAntigo {

    public static void main(String[] args) throws ParseException {
        System.out.println("Date Fromato Antigo!");

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date date1 = new Date();

        System.out.println("date1 " + simpleDateFormat2.format(date1));

        Date date2 = new Date(System.currentTimeMillis());

        System.out.println("date2 " + simpleDateFormat2.format(date2));

        Date date3 = new Date(0L);

        System.out.println("date3 " + simpleDateFormat2.format(date3));

        Date date4 = new Date(1000L * 60L * 60L * 5L);

        System.out.println("date4 " + simpleDateFormat2.format(date4));

        Date date5 = simpleDateFormat1.parse("22/11/2022");

        System.out.println("date5 " + simpleDateFormat2.format(date5));

        Date date6 = simpleDateFormat2.parse("22/11/2022 18:00:35");

        System.out.println("date6 " + simpleDateFormat2.format(date6));
        
        Date date7 = Date.from(Instant.parse("2022-11-22T18:00:35Z"));
        
        System.out.println("date7 " + simpleDateFormat2.format(date7));
        
        System.out.println("date4 " + simpleDateFormat3.format(date4));
        
        System.out.println("date1 " + date1);

        
    }
}
