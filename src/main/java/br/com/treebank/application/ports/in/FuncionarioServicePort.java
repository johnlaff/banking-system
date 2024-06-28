package br.com.treebank.application.ports.in;

import br.com.treebank.application.core.domain.Funcionario;

import java.util.List;

public interface FuncionarioServicePort {
    Funcionario salvar(Funcionario funcionario);
    Funcionario buscarPorId(Long id);
    List<Funcionario> listarTodos();
    Funcionario atualizar(Funcionario funcionario);
    void deletarPorId(Long id);
}
