package br.com.treebank.application.ports.out;

import br.com.treebank.application.core.domain.Pessoa;

import java.util.List;

public interface PessoaRepositoryPort {
    Pessoa salvar(Pessoa pessoa);
    Pessoa buscarPorId(Long id);
    List<Pessoa> listarTodos();
    Pessoa atualizar(Pessoa pessoa);
    void deletarPorId(Long id);
}