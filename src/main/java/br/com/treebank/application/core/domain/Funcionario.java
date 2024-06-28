package br.com.treebank.application.core.domain;

public class Funcionario extends Pessoa {
    private String cargo;
    private Agencia agencia;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
}
