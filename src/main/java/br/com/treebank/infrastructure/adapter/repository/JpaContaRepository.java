package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.ContaRepository;
import br.com.treebank.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaContaRepository extends JpaRepository<Conta, Long>, ContaRepository {
}
