package br.com.treebank.adapters.inbound.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest extends PessoaRequest {
    private String tipoCliente;
}
