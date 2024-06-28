package br.com.treebank.adapters.outbound.repository;

import br.com.treebank.adapters.inbound.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
