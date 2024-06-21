package br.com.treebank.application.port.in;

import br.com.treebank.domain.Funcionario;

import java.util.List;

public interface FuncionarioUseCase {
    List<Funcionario> getAllFuncionarios();
    Funcionario getFuncionarioById(Long id);
    Funcionario createFuncionario(Funcionario funcionario);
    Funcionario updateFuncionario(Long id, Funcionario funcionario);
    void deleteFuncionario(Long id);
}
