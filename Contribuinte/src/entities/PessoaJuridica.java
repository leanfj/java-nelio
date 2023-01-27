package entities;

public class PessoaJuridica extends Contribuinte {
    private Integer numeroEmpregados;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroEmpregados) {
        super(nome, rendaAnual);
        this.numeroEmpregados = numeroEmpregados;
    }

    public Integer getNumeroEmpregados() {
        return numeroEmpregados;
    }

    public void setNumeroEmpregados(Integer numeroEmpregados) {
        this.numeroEmpregados = numeroEmpregados;
    }

    @Override
    public Double imposto() {
        if(this.getNumeroEmpregados() > 10) {
            return this.getRendaAnual() * 0.14;
        } else {
            return this.getRendaAnual() * 0.16;
        }
    }
}
