package br.com.treebank.application.port.out;

import br.com.treebank.domain.Pessoa;
import java.util.List;
import java.util.Optional;

public interface PessoaRepository {
    List<Pessoa> findAll();
    Optional<Pessoa> findById(Long id);
    Pessoa save(Pessoa pessoa);
    void deleteById(Long id);
}
