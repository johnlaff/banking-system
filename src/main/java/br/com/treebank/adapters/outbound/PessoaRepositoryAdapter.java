package br.com.treebank.adapters.outbound;

import br.com.treebank.adapters.inbound.entity.PessoaEntity;
import br.com.treebank.adapters.outbound.repository.PessoaRepository;
import br.com.treebank.application.core.domain.Pessoa;
import br.com.treebank.application.ports.out.PessoaRepositoryPort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {
    private final PessoaRepository pessoaRepository;

    public PessoaRepositoryAdapter(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        BeanUtils.copyProperties(pessoa, pessoaEntity);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        BeanUtils.copyProperties(pessoaEntity, pessoa);
        return pessoa;
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(id).orElse(null);
        if (pessoaEntity == null) {
            return null;
        }
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaEntity, pessoa);
        return pessoa;
    }

    @Override
    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll().stream()
                .map(pessoaEntity -> {
                    Pessoa pessoa = new Pessoa();
                    BeanUtils.copyProperties(pessoaEntity, pessoa);
                    return pessoa;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(pessoa.getId()).orElse(null);
        if (pessoaEntity == null) {
            return null;
        }
        BeanUtils.copyProperties(pessoa, pessoaEntity);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        BeanUtils.copyProperties(pessoaEntity, pessoa);
        return pessoa;
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepository.deleteById(id);
    }
}
