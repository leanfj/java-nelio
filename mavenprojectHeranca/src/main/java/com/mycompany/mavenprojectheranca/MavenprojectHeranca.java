/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectheranca;

import entities.BussinesAccount;

/**
 *
 * @author leandro
 */
public class MavenprojectHeranca {

    public static void main(String[] args) {
        System.out.println("Herança Account!");
        
        BussinesAccount bussinesAccount = new BussinesAccount();
        
        bussinesAccount.getBalance();
    }
}
