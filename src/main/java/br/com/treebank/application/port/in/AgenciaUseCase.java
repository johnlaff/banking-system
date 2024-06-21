package br.com.treebank.application.port.in;

import br.com.treebank.domain.Agencia;

import java.util.List;

public interface AgenciaUseCase {
    List<Agencia> getAllAgencias();
    Agencia getAgenciaById(Long id);
    Agencia createAgencia(Agencia agencia);
    Agencia updateAgencia(Long id, Agencia agencia);
    void deleteAgencia(Long id);
}
