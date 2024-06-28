package br.com.treebank.application.core.domain;

public class Cliente extends Pessoa {
    private String tipoCliente;

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
