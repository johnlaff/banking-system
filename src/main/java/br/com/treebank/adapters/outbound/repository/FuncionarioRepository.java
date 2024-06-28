package br.com.treebank.adapters.outbound.repository;

import br.com.treebank.adapters.inbound.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
}
