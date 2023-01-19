/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author leandro
 */
public class ItemPedido {

    private Integer quantity;
    private double price;

    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantity, Produto produto) {
        this.quantity = quantity;
        this.produto = produto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public double subtotal() {
        return this.produto.getPrice() * this.quantity;
    }

    @Override
    public String toString() {
        return "Produto " 
                    + this.getProduto().getName() 
                    + ", Preço Unitário: $" 
                    + String.format("%.2f", this.getProduto().getPrice())
                    + ", Quantidade: " 
                    + this.getQuantity() 
                    + ", SubTotal: " 
                    + String.format("%.2f", this.subtotal());
    }
}
