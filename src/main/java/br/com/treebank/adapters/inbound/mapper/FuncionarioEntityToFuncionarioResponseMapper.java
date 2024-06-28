package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.FuncionarioEntity;
import br.com.treebank.adapters.inbound.response.FuncionarioResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioEntityToFuncionarioResponseMapper {
    public FuncionarioResponse toResponse(FuncionarioEntity funcionarioEntity) {
        FuncionarioResponse funcionarioResponse = new FuncionarioResponse();
        BeanUtils.copyProperties(funcionarioEntity, funcionarioResponse);
        if (funcionarioEntity.getAgencia() != null) {
            funcionarioResponse.setAgenciaId(funcionarioEntity.getAgencia().getId());
        }
        return funcionarioResponse;
    }
}