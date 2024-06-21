package br.com.treebank.infrastructure.adapter.repository;

import br.com.treebank.application.port.out.PessoaRepository;
import br.com.treebank.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepository {
}
