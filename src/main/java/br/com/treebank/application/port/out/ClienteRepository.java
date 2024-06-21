package br.com.treebank.application.port.out;

import br.com.treebank.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    List<Cliente> findAll();
    Optional<Cliente> findById (Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}
