package br.com.treebank.application.port.out;

import br.com.treebank.domain.Cartao;

import java.util.List;
import java.util.Optional;

public interface CartaoRepository {
    List<Cartao> findAll();
    Optional<Cartao> findById(Long Id);
    Cartao save (Cartao cartao);
    void deleteById(Long id);
}
