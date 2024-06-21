package br.com.treebank.application.port.in;

import br.com.treebank.domain.Transacao;

import java.util.List;

public interface TransacaoUseCase {
    List<Transacao> getAllTransacoes();
    Transacao getTransacaoById(Long id);
    Transacao createTransacao(Transacao transacao);
    Transacao updateTransacao(Long id, Transacao transacao);
    void deleteTransacao(Long id);
}
