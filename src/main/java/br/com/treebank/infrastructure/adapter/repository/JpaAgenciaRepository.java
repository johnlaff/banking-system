package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.AgenciaRepository;
import br.com.treebank.domain.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAgenciaRepository extends JpaRepository<Agencia, Long>, AgenciaRepository {
}
