/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectenum;

import entitie.Pedido;
import entities.enums.OrderStatus;
import java.util.Date;

/**
 *
 * @author leandro
 */
public class MavenprojectEnum {

    public static void main(String[] args) {
        Pedido pedido = new Pedido(1080, new Date(), OrderStatus.AGUARDANDO_PAGAMENTO);
        
        System.out.println("Pedido" + pedido);
        
        OrderStatus os1 = OrderStatus.ENTREGUE;
        OrderStatus os2 = OrderStatus.valueOf("ENTREGUE");
        
        System.out.println("os1 " + os1);
        System.out.println("os2 " + os2);
    }
}
