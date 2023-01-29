/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.exceptions.DomainException;

/**
 *
 * @author leandro
 */
public class Conta {

    private Integer numero;
    private String proprietario;
    private double saldo;
    private double limiteSaque;

    public Conta() {
    }

    public Conta(Integer numero, String proprietario, double saldo, double limiteSaque) {
        this.numero = numero;
        this.proprietario = proprietario;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public double getLimiteSaque() {
        return this.limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public double getSaldo() {
        return this.saldo;
    }
    
    public void deposito(double valor) {

        this.saldo += valor;
        System.out.printf("Novo saldo: $ %.2f após o depósito no valor de $ %.2f \n", this.getSaldo(), valor);
    }

    public void saque(double valor) throws DomainException {
        if (valor > this.saldo) {
            throw new DomainException("Saldo insuficiente");
        }
        if (valor > this.limiteSaque) {
            throw new DomainException("Valor de saque maior que limite");
        }
        this.saldo -= valor;
        System.out.printf("Novo saldo: %.2f após o saque no valor de $ %.2f \n", this.getSaldo(), valor);
    }
}
