/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectcalendar;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author leandro
 */
public class MavenprojectCalendar {

    public static void main(String[] args) {
        System.out.println("Date Calendar!");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date data1 = Date.from(Instant.parse("2022-11-22T21:48:35Z"));

        System.out.println("data1 " + simpleDateFormat.format(data1));

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(data1);

        calendar.add(Calendar.HOUR, 10);
        
        data1 = calendar.getTime();

        System.out.println("data1 " + simpleDateFormat.format(data1));
        
        
        Integer minutes = calendar.get(Calendar.MINUTE);
        
        System.out.println("minutes " + minutes);
        
        Integer month = calendar.get(Calendar.MONTH);
        
        System.out.println("month " + month);

    }
}
