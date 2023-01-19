/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenprojectpedidoprodutos;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import enums.StatusPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author leandro
 */
public class MavenprojectPedidoProdutos {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        
        System.out.println("------=====Programa Pedidos=====------");

        Cliente cliente1 = new Cliente("Alex Green", "alex@email.com", new SimpleDateFormat("dd/MM/yyyy").parse("15/03/1985"));
        Produto tv = new Produto("TV", 1000.00);
        Produto mouse = new Produto("Mouse", 40.00);

        Pedido pedido = new Pedido(StatusPedido.PROCESSING, cliente1);

        pedido.addItem(new ItemPedido(1, tv));
        pedido.addItem(new ItemPedido(2, mouse));

        
        pedido.resumoPedido();

    }
}
