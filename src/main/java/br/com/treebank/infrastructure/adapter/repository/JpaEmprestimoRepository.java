package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.EmprestimoRepository;
import br.com.treebank.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEmprestimoRepository extends JpaRepository<Emprestimo, Long>, EmprestimoRepository {
}
