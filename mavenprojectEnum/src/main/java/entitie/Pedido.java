/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitie;

import entities.enums.OrderStatus;
import java.util.Date;

/**
 *
 * @author leandro
 */
public class Pedido {
    private Integer id;
    private Date moment;
    private OrderStatus status;

    public Pedido() {
    }
  
    public Pedido(Integer id, Date moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", moment=" + moment + ", status=" + status + '}';
    }
    
    
}
