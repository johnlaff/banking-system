package br.com.treebank.adapters.inbound.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgenciaResponse {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private Long gerenteId;
}