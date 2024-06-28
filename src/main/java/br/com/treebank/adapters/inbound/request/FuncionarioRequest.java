package br.com.treebank.adapters.inbound.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FuncionarioRequest extends PessoaRequest {

    @NotBlank(message = "Cargo é obrigatório")
    @Size(max = 50, message = "Cargo deve ter no máximo 50 caracteres")
    private String cargo;

    @NotNull(message = "ID da agência é obrigatório")
    private Long agenciaId;
}
