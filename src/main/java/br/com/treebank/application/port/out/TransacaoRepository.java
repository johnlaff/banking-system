package br.com.treebank.application.port.out;

import br.com.treebank.domain.Transacao;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository {
    List<Transacao> findAll();
    Optional<Transacao> findById(Long id);
    Transacao save(Transacao transacao);
    void deleteById(Long id);
}
