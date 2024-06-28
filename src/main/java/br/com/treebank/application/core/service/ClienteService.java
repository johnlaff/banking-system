package br.com.treebank.application.core.service;

import br.com.treebank.application.core.domain.Cliente;
import br.com.treebank.application.ports.in.ClienteServicePort;
import br.com.treebank.application.ports.out.ClienteRepositoryPort;

import java.util.List;

public class ClienteService implements ClienteServicePort {
    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteService(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepositoryPort.salvar(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepositoryPort.listarTodos();
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return clienteRepositoryPort.atualizar(cliente);
    }

    @Override
    public void deletarPorId(Long id) {
        clienteRepositoryPort.deletarPorId(id);
    }
}
