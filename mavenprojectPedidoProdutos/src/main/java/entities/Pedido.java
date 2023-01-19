/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import enums.StatusPedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author leandro
 */
public class Pedido {

    private Date moment;
    private StatusPedido status;

    private List<ItemPedido> itemsPedido = new ArrayList<ItemPedido>();

    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(StatusPedido status, Cliente cliente) {
        this.moment = new Date();
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMoment() {
        return moment;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void addItem(ItemPedido item) {
        itemsPedido.add(item);
    }

    public void removeItem(ItemPedido item) {
        itemsPedido.remove(item);
    }

    public double total() {
        double soma = 0;

        for (ItemPedido itemPedido : itemsPedido) {
            soma += itemPedido.subtotal();
        }

        return soma;

    }

    public void resumoPedido() {
        System.out.println("Resumo do pedido");
        System.out.println("Data/Hora do pedido " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(this.getMoment()));
        System.out.println("Status do pedido " + this.getStatus());
        System.out.println(this.cliente);
        for (ItemPedido itemPedido : itemsPedido) {
            System.out.println(itemPedido);
        }
        System.out.println("Preço Total : " + this.total());
    }

}
