/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import entidades.enums.LevelTrabalhador;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author leandro
 */
public class Trabalhador {

    private String nome;
    private LevelTrabalhador level;
    private Double salarioBase;

    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, LevelTrabalhador level, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.level = level;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LevelTrabalhador getLevel() {
        return level;
    }

    public void setLevel(LevelTrabalhador level) {
        this.level = level;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }

    public void adicionarContrato(ContratoPorHora contrato) {
        this.contratos.add(contrato);
    }

    public void removerContrato(ContratoPorHora contrato) {
        this.contratos.remove(contrato);
    }

    public Double pagamento(Integer ano, Integer mes) {
        double soma = this.salarioBase;
        Calendar calendario = Calendar.getInstance();
        for (ContratoPorHora contrato : contratos) {
            calendario.setTime(contrato.getData());
            int ano_contrato = calendario.get(Calendar.YEAR);
            int mes_contrato = 1 + calendario.get(Calendar.MONTH);

            if (ano == ano_contrato && mes == mes_contrato) {
                soma += contrato.valorTotal();
            }
        }

        return soma;
    }

}
