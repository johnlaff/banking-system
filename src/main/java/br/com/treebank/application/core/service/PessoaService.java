package br.com.treebank.application.core.service;

import br.com.treebank.application.core.domain.Pessoa;
import br.com.treebank.application.ports.in.PessoaServicePort;
import br.com.treebank.application.ports.out.PessoaRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PessoaService implements PessoaServicePort {
    private final PessoaRepositoryPort pessoaRepositoryPort;

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepositoryPort.salvar(pessoa);
    }

    @Override
    public Pessoa buscarPorId(Long id) {
        return pessoaRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Pessoa> listarTodos() {
        return pessoaRepositoryPort.listarTodos();
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        return pessoaRepositoryPort.atualizar(pessoa);
    }

    @Override
    public void deletarPorId(Long id) {
        pessoaRepositoryPort.deletarPorId(id);
    }
}
