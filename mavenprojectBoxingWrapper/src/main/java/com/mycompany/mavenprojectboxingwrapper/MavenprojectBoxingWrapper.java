/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectboxingwrapper;

/**
 *
 * @author leandro
 */
public class MavenprojectBoxingWrapper {

    public static void main(String[] args) {
        
        int x = 20;
        
        //Boxing colocando no obejto na heap o valor vindo do primitivo da stack
        Object obj = x;
        
        System.out.println("object -> " + obj);
        
        //Unboxing fazendo o casting para receber o valor do objeto que esta na heap para o primitivo na stack
        int y = (int) obj;
        
        System.out.println("y casting -> " + y);
        
        //Wrapper class para realizar o boxing e unboxing de forma mais natural, wrapper class para cada tipo primitivo
        
        Integer z = x;
        
        //Vindo de uma wrapper class não precisamos fazer o casting
        y = z;
        
        System.out.println("y wrapper-> " + y);
        
        //Wrapper class aceitam valor nulo sendo inportante para entidades nos bancos que adimitem nulo
        
        
        
    }
}
