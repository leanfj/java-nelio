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
public abstract class Forma {
    
    
    private Color cor;

    public Forma(Color cor) {
        this.cor = cor;
    }
    
    public abstract Double area();

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
    
    
}
