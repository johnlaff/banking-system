package br.com.treebank.application.port.out;

import br.com.treebank.domain.Conta;

import java.util.List;
import java.util.Optional;

public interface ContaRepository {
    List<Conta> findAll();
    Optional<Conta> findById (Long id);
    Conta save(Conta conta);
    void deleteById(Long id);
}
