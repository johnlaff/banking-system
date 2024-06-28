package br.com.treebank.application.ports.in;

import br.com.treebank.application.core.domain.Cliente;

import java.util.List;

public interface ClienteServicePort {
    Cliente salvar(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    Cliente atualizar(Cliente cliente);
    void deletarPorId(Long id);
}
