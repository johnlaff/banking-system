package br.com.treebank.application.service;

import br.com.treebank.application.port.in.EmprestimoUseCase;
import br.com.treebank.application.port.out.EmprestimoRepository;
import br.com.treebank.domain.Emprestimo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService implements EmprestimoUseCase {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public List<Emprestimo> getAllEmprestimos() {
        return emprestimoRepository.findAll();
    }

    @Override
    public Emprestimo getEmprestimoById(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));
    }

    @Override
    public Emprestimo createEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    @Override
    public Emprestimo updateEmprestimo(Long id, Emprestimo emprestimo) {
        Emprestimo existingEmprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));
        existingEmprestimo.setCliente(emprestimo.getCliente());
        existingEmprestimo.setValorEmprestimo(emprestimo.getValorEmprestimo());
        existingEmprestimo.setDataInicio(emprestimo.getDataInicio());
        existingEmprestimo.setDataTermino(emprestimo.getDataTermino());
        existingEmprestimo.setTaxaJuros(emprestimo.getTaxaJuros());
        return emprestimoRepository.save(existingEmprestimo);
    }

    @Override
    public void deleteEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
