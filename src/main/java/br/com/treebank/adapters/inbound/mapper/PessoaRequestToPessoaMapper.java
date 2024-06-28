package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.request.PessoaRequest;
import br.com.treebank.application.core.domain.Pessoa;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PessoaRequestToPessoaMapper {
    public Pessoa mapper(PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaRequest, pessoa);
        return pessoa;
    }
}
