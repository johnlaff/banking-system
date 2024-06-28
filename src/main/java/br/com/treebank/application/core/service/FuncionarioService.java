package br.com.treebank.application.core.service;

import br.com.treebank.application.core.domain.Funcionario;
import br.com.treebank.application.ports.in.FuncionarioServicePort;
import br.com.treebank.application.ports.out.FuncionarioRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FuncionarioService implements FuncionarioServicePort {
    private final FuncionarioRepositoryPort funcionarioRepositoryPort;

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepositoryPort.salvar(funcionario);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return funcionarioRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarioRepositoryPort.listarTodos();
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario) {
        return funcionarioRepositoryPort.atualizar(funcionario);
    }

    @Override
    public void deletarPorId(Long id) {
        funcionarioRepositoryPort.deletarPorId(id);
    }
}
