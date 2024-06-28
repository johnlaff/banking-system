package br.com.treebank.adapters.outbound.repository;

import br.com.treebank.adapters.inbound.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
