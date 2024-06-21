package br.com.treebank.application.port.out;

import br.com.treebank.domain.Emprestimo;

import java.util.List;
import java.util.Optional;

public interface EmprestimoRepository {
    List<Emprestimo> findAll();
    Optional<Emprestimo> findById (Long id);
    Emprestimo save(Emprestimo emprestimo);
    void deleteById(Long id);
}
