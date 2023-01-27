package entities;

public class PessoaFisica extends Contribuinte {

    private Double gastoMedicos;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastoMedicos) {
        super(nome, rendaAnual);
        this.gastoMedicos = gastoMedicos;
    }

    public Double getGastoMedicos() {
        return gastoMedicos;
    }

    public void setGastoMedicos(Double gastoMedicos) {
        this.gastoMedicos = gastoMedicos;
    }

    @Override
    public Double imposto() {
        double impostoBasico = 0.0;
        if(this.getRendaAnual() < 20000.0) {
            impostoBasico += this.getRendaAnual() * 0.15;
        } else {
            impostoBasico += this.getRendaAnual() * 0.25;
        }
        impostoBasico = impostoBasico - (this.getGastoMedicos() * 0.5);

        if(impostoBasico < 0.0) {
            impostoBasico = 0.0;
        }
        
        return impostoBasico;
    }
}
