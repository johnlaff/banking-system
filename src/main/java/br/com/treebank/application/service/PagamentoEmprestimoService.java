package br.com.treebank.application.service;

import br.com.treebank.application.port.in.PagamentoEmprestimoUseCase;
import br.com.treebank.application.port.out.PagamentoEmprestimoRepository;
import br.com.treebank.domain.PagamentoEmprestimo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoEmprestimoService implements PagamentoEmprestimoUseCase {
    private final PagamentoEmprestimoRepository pagamentoEmprestimoRepository;

    public PagamentoEmprestimoService(PagamentoEmprestimoRepository pagamentoEmprestimoRepository) {
        this.pagamentoEmprestimoRepository = pagamentoEmprestimoRepository;
    }

    @Override
    public List<PagamentoEmprestimo> getAllPagamentoEmprestimos() {
        return pagamentoEmprestimoRepository.findAll();
    }

    @Override
    public PagamentoEmprestimo getPagamentoEmprestimoById(Long id) {
        return pagamentoEmprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pagamento de emprestimo não encontrado"));
    }

    @Override
    public PagamentoEmprestimo createPagamentoEmprestimo(PagamentoEmprestimo pagamentoEmprestimo) {
        return pagamentoEmprestimoRepository.save(pagamentoEmprestimo);
    }

    @Override
    public PagamentoEmprestimo updatePagamentoEmprestimo(Long id, PagamentoEmprestimo pagamentoEmprestimo) {
        PagamentoEmprestimo existingPagamentoEmprestimo = pagamentoEmprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pagamento de emprestimo não encontrado"));
        existingPagamentoEmprestimo.setEmprestimo(pagamentoEmprestimo.getEmprestimo());
        existingPagamentoEmprestimo.setValorPagamento(pagamentoEmprestimo.getValorPagamento());
        existingPagamentoEmprestimo.setDataPagamento(pagamentoEmprestimo.getDataPagamento());
        return pagamentoEmprestimoRepository.save(existingPagamentoEmprestimo);
    }

    @Override
    public void deletePagamentoEmprestimo(Long id) {
        pagamentoEmprestimoRepository.deleteById(id);
    }
}
