package br.com.treebank.application.port.out;

import br.com.treebank.domain.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {
    List<Funcionario> findAll();
    Optional<Funcionario> findById(Long id);
    Funcionario save(Funcionario funcionario);
    void deleteById(Long id);
}
