package br.com.treebank.application.port.in;

import br.com.treebank.domain.Conta;

import java.util.List;

public interface ContaUseCase {
    List<Conta> getAllContas();
    Conta getContaById(Long id);
    Conta createConta(Conta conta);
    Conta updateConta(Long id, Conta conta);
    void deleteConta(Long id);
}
