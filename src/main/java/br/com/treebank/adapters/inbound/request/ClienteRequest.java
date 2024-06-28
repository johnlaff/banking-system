package br.com.treebank.adapters.inbound.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClienteRequest extends PessoaRequest {

    @NotBlank(message = "Tipo de cliente é obrigatório")
    @Size(max = 20, message = "Tipo de cliente deve ter no máximo 20 caracteres")
    private String tipoCliente;
}
