package br.com.treebank.application.port.out;

import br.com.treebank.domain.Agencia;

import java.util.List;
import java.util.Optional;

public interface AgenciaRepository {
    List<Agencia> findAll();
    Optional<Agencia> findById(Long id);
    Agencia save(Agencia agencia);
    void deleteById(Long id);
}
