package br.com.treebank.application.ports.out;

import br.com.treebank.application.core.domain.Funcionario;

import java.util.List;

public interface FuncionarioRepositoryPort {
    Funcionario salvar(Funcionario funcionario);
    Funcionario buscarPorId(Long id);
    List<Funcionario> listarTodos();
    Funcionario atualizar(Funcionario funcionario);
    void deletarPorId(Long id);
}
