package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.PessoaEntity;
import br.com.treebank.adapters.inbound.response.PessoaResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PessoaEntityToPessoaResponseMapper {
    public PessoaResponse toResponse(PessoaEntity pessoaEntity) {
        PessoaResponse pessoaResponse = new PessoaResponse();
        BeanUtils.copyProperties(pessoaEntity, pessoaResponse);
        return pessoaResponse;
    }
}
