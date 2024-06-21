package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.FuncionarioRepository;
import br.com.treebank.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFuncionarioRepository extends JpaRepository<Funcionario, Long>, FuncionarioRepository {
}
