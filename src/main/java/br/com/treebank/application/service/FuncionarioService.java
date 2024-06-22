package br.com.treebank.application.service;

import br.com.treebank.application.port.in.FuncionarioUseCase;
import br.com.treebank.application.port.out.FuncionarioRepository;
import br.com.treebank.application.port.out.PessoaRepository;
import br.com.treebank.domain.Funcionario;
import br.com.treebank.domain.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements FuncionarioUseCase {
    private final FuncionarioRepository funcionarioRepository;
    private final PessoaRepository pessoaRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, PessoaRepository pessoaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
    }

    @Override
    public Funcionario createFuncionario(Funcionario funcionario) {
        // Criar uma nova entrada na tabela Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(funcionario.getPessoa().getNome());
        pessoa.setEndereco(funcionario.getPessoa().getEndereco());
        pessoa.setTelefone(funcionario.getPessoa().getTelefone());
        pessoa.setEmail(funcionario.getPessoa().getEmail());
        pessoa.setDataNascimento(funcionario.getPessoa().getDataNascimento());

        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        // Definir o ID da pessoa no funcionário
        funcionario.setFuncionarioId(savedPessoa.getPessoaId());

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario updateFuncionario(Long id, Funcionario funcionario) {
        Funcionario existingFuncionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        // Atualizar a tabela Pessoa
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa.setNome(funcionario.getPessoa().getNome());
        pessoa.setEndereco(funcionario.getPessoa().getEndereco());
        pessoa.setTelefone(funcionario.getPessoa().getTelefone());
        pessoa.setEmail(funcionario.getPessoa().getEmail());
        pessoa.setDataNascimento(funcionario.getPessoa().getDataNascimento());

        pessoaRepository.save(pessoa);

        // Atualizar a tabela Funcionario
        existingFuncionario.setCargo(funcionario.getCargo());
        existingFuncionario.setAgencia(funcionario.getAgencia());

        return funcionarioRepository.save(existingFuncionario);
    }

    @Override
    public void deleteFuncionario(Long id) {
        // Remover o funcionário
        funcionarioRepository.deleteById(id);

        // Remover a pessoa correspondente
        pessoaRepository.deleteById(id);
    }
}
