/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author leandro
 */
public class ProdutoImportado extends Produto {
    private Double taxasCustomizadas;

    public ProdutoImportado() {
    }

    public ProdutoImportado(Double taxasCustomizadas, String nome, Double preco) {
        super(nome, preco);
        this.taxasCustomizadas = taxasCustomizadas;
    }

    public Double getTaxasCustomizadas() {
        return taxasCustomizadas;
    }

    public void setTaxasCustomizadas(Double taxasCustomizadas) {
        this.taxasCustomizadas = taxasCustomizadas;
    }
    
    public Double precoTotal() {
        return this.getPreco() + this.getTaxasCustomizadas();
    }

    @Override
    public String etiquetaPreco() {
        return this.getNome() + " $ " + String.format("%.2f", this.precoTotal()) + " (Taxa Customizada: $ " + String.format("%.2f", this.getTaxasCustomizadas()) + ")";
    }
    
    
    
}
