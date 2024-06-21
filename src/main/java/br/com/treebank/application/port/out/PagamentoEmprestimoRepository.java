package br.com.treebank.application.port.out;

import br.com.treebank.domain.PagamentoEmprestimo;

import java.util.List;
import java.util.Optional;

public interface PagamentoEmprestimoRepository {
    List<PagamentoEmprestimo> findAll();
    Optional<PagamentoEmprestimo> findById(Long id);
    PagamentoEmprestimo save (PagamentoEmprestimo pagamentoEmprestimo);
    void deleteById();
}
