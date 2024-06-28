package br.com.treebank.application.core.service;

import br.com.treebank.application.core.domain.Agencia;
import br.com.treebank.application.ports.in.AgenciaServicePort;
import br.com.treebank.application.ports.out.AgenciaRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AgenciaService implements AgenciaServicePort {
    private final AgenciaRepositoryPort agenciaRepositoryPort;

    @Override
    public Agencia salvar(Agencia agencia) {
        return agenciaRepositoryPort.salvar(agencia);
    }

    @Override
    public Agencia buscarPorId(Long id) {
        return agenciaRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Agencia> listarTodos() {
        return agenciaRepositoryPort.listarTodos();
    }

    @Override
    public Agencia atualizar(Agencia agencia) {
        return agenciaRepositoryPort.atualizar(agencia);
    }

    @Override
    public void deletarPorId(Long id) {
        agenciaRepositoryPort.deletarPorId(id);
    }
}
