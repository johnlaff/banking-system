package br.com.treebank.adapters.inbound.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgenciaRequest {
    private String nome;
    private String endereco;
    private String telefone;
    private Long gerenteId;
}
