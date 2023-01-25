/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author leandro
 */
public class ProdutoUsado extends Produto {

    private Date dataFabricacao;

    public ProdutoUsado() {
    }

    public ProdutoUsado(Date dataFabricacao, String nome, Double preco) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public double calculoDepreciacao() {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dataFabricacao);
        int anoFabricacao = calendario.get(Calendar.YEAR);

        calendario.setTime(new Date());

        int anoAtual = calendario.get(Calendar.YEAR);

        int diferencaAnos = anoAtual - anoFabricacao;

        double depreciacao = 0.0;

        for (int i = 1; i <= diferencaAnos; i++) {
            if(i > 5) {
                break;
            }
            depreciacao += 0.1;
        }
        return this.getPreco() * depreciacao;

    }

    @Override
    public String etiquetaPreco() {
        return this.getNome() + " (usado) $ " 
                + String.format("%.2f", this.getPreco() - this.calculoDepreciacao()) 
                + " Preço Original: " + String.format("%.2f", this.getPreco()) 
                + " Data de fabricação: " + new SimpleDateFormat("dd/MM/yyyy").format(this.getDataFabricacao());
    }

}
