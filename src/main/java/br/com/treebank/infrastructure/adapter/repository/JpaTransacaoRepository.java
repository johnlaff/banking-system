package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.TransacaoRepository;
import br.com.treebank.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTransacaoRepository extends JpaRepository<Transacao, Long>, TransacaoRepository {
}
