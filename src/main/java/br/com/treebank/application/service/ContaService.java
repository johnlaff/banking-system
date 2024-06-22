package br.com.treebank.application.service;

import br.com.treebank.application.port.in.ContaUseCase;
import br.com.treebank.application.port.out.ContaRepository;
import br.com.treebank.domain.Conta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService implements ContaUseCase {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    @Override
    public Conta getContaById(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    @Override
    public Conta createConta(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    public Conta updateConta(Long id, Conta conta) {
        Conta existingConta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        existingConta.setCliente(conta.getCliente());
        existingConta.setTipoConta(conta.getTipoConta());
        existingConta.setSaldo(conta.getSaldo());
        existingConta.setDataAbertura(conta.getDataAbertura());
        return contaRepository.save(existingConta);
    }

    @Override
    public void deleteConta(Long id) {
        contaRepository.deleteById(id);
    }
}
