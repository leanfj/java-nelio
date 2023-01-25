/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.enums.Color;

/**
 *
 * @author leandro
 */
public class Retangulo extends Forma {

    private Double largura;
    private Double altura;

    public Retangulo(Double largura, Double altura, Color cor) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }
    
    @Override
    public Double area() {
        return this.largura * this.altura;
    }
    
}
