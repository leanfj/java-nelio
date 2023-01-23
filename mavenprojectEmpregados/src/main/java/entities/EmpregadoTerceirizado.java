/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author leandro
 */
public class EmpregadoTerceirizado extends Empregado {
    private Double cargaAdicional;

    public EmpregadoTerceirizado(Double cargaAdicional) {
        this.cargaAdicional = cargaAdicional;
    }

    public EmpregadoTerceirizado(Double cargaAdicional, String nome, Integer horas, Double valorPorHora) {
        super(nome, horas, valorPorHora);
        this.cargaAdicional = cargaAdicional;
    }

    public Double getCargaAdicional() {
        return cargaAdicional;
    }

    public void setCargaAdicional(Double cargaAdicional) {
        this.cargaAdicional = cargaAdicional;
    }
    
    @Override
    public final Double pagamento() {
        return super.pagamento() + this.cargaAdicional * 1.1;
    }
}
