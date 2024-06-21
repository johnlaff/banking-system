package br.com.treebank.application.port.in;

import br.com.treebank.domain.PagamentoEmprestimo;

import java.util.List;

public interface PagamentoEmprestimoUseCase {
    List<PagamentoEmprestimo> getAllPagamentoEmprestimos();
    PagamentoEmprestimo getPagamentoEmprestimoById(Long id);
    PagamentoEmprestimo createPagamentoEmprestimo(PagamentoEmprestimo pagamentoEmprestimo);
    PagamentoEmprestimo updatePagamentoEmprestimo(Long id, PagamentoEmprestimo pagamentoEmprestimo);
    void deletePagamentoEmprestimo(Long id);
}
