/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author leandro
 */
public class BussinesAccount extends Account {
    private Double loanLimit;

    public BussinesAccount() {
        super();
    }

    public BussinesAccount(Double loanLimit, Integer number, String holder, Double balance) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return this.loanLimit;
    }

    public void loan(Double amount) {
        if(amount <= this.loanLimit) {
            //this.deposit(amount);
            this.balance += amount - 10;
        }
    }
    
    
    
}
