package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.CartaoRepository;
import br.com.treebank.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCartaoRepository extends JpaRepository<Cartao, Long>, CartaoRepository {
}
