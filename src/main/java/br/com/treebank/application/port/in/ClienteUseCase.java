package br.com.treebank.application.port.in;

import br.com.treebank.domain.Cliente;

import java.util.List;

public interface ClienteUseCase {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
}
