package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.ClienteRepository;
import br.com.treebank.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepository {
}
