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
public class Circulo extends Forma {
    private Double raio;

    public Circulo(Double raio, Color cor) {
        super(cor);
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }
    
    @Override
    public Double area() {
        return Math.PI * (this.raio * this.raio);
    }
    
    
}
