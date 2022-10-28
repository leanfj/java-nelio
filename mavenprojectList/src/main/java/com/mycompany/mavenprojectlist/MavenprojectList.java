/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectlist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author leandro
 */
public class MavenprojectList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("Leandro");
        list.add("Lucas");
        list.add("Antônio");

        list.add(1, "Carlos");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //list.remove("Lucas");
        //list.remove(2);
        list.removeIf(item -> item.charAt(0) == 'L');
        System.out.println("--------");
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("Procurar elemento Carlos " + list.indexOf("Carlos"));
        System.out.println("Procurar elemento Leandro " + list.indexOf("Leandro"));

        
        List<String> result = list.stream().filter(item -> item.charAt(0) == 'A').collect(Collectors.toList());
    
        for(String item: result) {
            System.out.println(item);
        }
        
        String name = list.stream().filter(item -> item.charAt(0) == 'C').findFirst().orElse(null);
        
        System.out.println(" Achar o primeiro com C  " + name);
    }
}
