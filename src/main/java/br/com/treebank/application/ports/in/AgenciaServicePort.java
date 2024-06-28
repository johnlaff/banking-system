package br.com.treebank.application.ports.in;

import br.com.treebank.application.core.domain.Agencia;

import java.util.List;

public interface AgenciaServicePort {
    Agencia salvar(Agencia agencia);
    Agencia buscarPorId(Long id);
    List<Agencia> listarTodos();
    Agencia atualizar(Agencia agencia);
    void deletarPorId(Long id);
}
