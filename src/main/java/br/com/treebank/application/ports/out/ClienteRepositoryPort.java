package br.com.treebank.application.ports.out;

import br.com.treebank.application.core.domain.Cliente;

import java.util.List;

public interface ClienteRepositoryPort {
    Cliente salvar(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    Cliente atualizar(Cliente cliente);
    void deletarPorId(Long id);
}
