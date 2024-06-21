package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.PagamentoEmprestimoRepository;
import br.com.treebank.domain.PagamentoEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPagamentoEmprestimoRepository extends JpaRepository<PagamentoEmprestimo, Long>, PagamentoEmprestimoRepository {
}
