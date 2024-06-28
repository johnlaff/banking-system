package br.com.treebank.application.ports.in;

import br.com.treebank.application.core.domain.Pessoa;

import java.util.List;

public interface PessoaServicePort {
    Pessoa salvar(Pessoa pessoa);
    Pessoa buscarPorId(Long id);
    List<Pessoa> listarTodos();
    Pessoa atualizar(Pessoa pessoa);
    void deletarPorId(Long id);
}
