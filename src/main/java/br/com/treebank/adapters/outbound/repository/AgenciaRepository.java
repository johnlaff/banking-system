package br.com.treebank.adapters.outbound.repository;

import br.com.treebank.adapters.inbound.entity.AgenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<AgenciaEntity, Long> {
}
