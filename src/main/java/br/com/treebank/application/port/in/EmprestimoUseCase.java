package br.com.treebank.application.port.in;

import br.com.treebank.domain.Emprestimo;

import java.util.List;

public interface EmprestimoUseCase {
    List<Emprestimo> getAllEmprestimos();
    Emprestimo getEmprestimoById(Long id);
    Emprestimo createEmprestimo(Emprestimo emprestimo);
    Emprestimo updateEmprestimo(Long id, Emprestimo emprestimo);
    void deleteEmprestimo(Long id);
}
