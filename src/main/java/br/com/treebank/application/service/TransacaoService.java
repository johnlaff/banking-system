package br.com.treebank.application.service;

import br.com.treebank.application.port.in.TransacaoUseCase;
import br.com.treebank.application.port.out.TransacaoRepository;
import br.com.treebank.domain.Transacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService implements TransacaoUseCase {
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public List<Transacao> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    @Override
    public Transacao getTransacaoById(Long id) {
        return transacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Transacao não encontrada"));
    }

    @Override
    public Transacao createTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    @Override
    public Transacao updateTransacao(Long id, Transacao transacao) {
        Transacao existingTransacao = transacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Transacao não encontrada"));
        existingTransacao.setConta(transacao.getConta());
        existingTransacao.setTipoConta(transacao.getTipoConta());
        existingTransacao.setValor(transacao.getValor());
        existingTransacao.setDataTransacao(transacao.getDataTransacao());
        return transacaoRepository.save(existingTransacao);
    }

    @Override
    public void deleteTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }
}
