package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.PessoaEntity;
import br.com.treebank.application.core.domain.Pessoa;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PessoaEntityToPessoaMapper {
    public Pessoa toDomain(PessoaEntity pessoaEntity) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaEntity, pessoa);
        return pessoa;
    }

    public PessoaEntity toEntity(Pessoa pessoa) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        BeanUtils.copyProperties(pessoa, pessoaEntity);
        return pessoaEntity;
    }
}
