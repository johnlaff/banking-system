package br.com.treebank.application.service;

import br.com.treebank.application.port.in.ClienteUseCase;
import br.com.treebank.application.port.out.ClienteRepository;
import br.com.treebank.application.port.out.PessoaRepository;
import br.com.treebank.domain.Cliente;
import br.com.treebank.domain.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteUseCase {
    private final ClienteRepository clienteRepository;
    private final PessoaRepository pessoaRepository;

    public ClienteService(ClienteRepository clienteRepository, PessoaRepository pessoaRepository) {
        this.clienteRepository = clienteRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        // Criar uma nova entrada na tabela Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(cliente.getPessoa().getNome());
        pessoa.setEndereco(cliente.getPessoa().getEndereco());
        pessoa.setTelefone(cliente.getPessoa().getTelefone());
        pessoa.setEmail(cliente.getPessoa().getEmail());
        pessoa.setDataNascimento(cliente.getPessoa().getDataNascimento());

        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        // Definir o ID da pessoa no cliente
        cliente.setClientId(savedPessoa.getPessoaId());

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Atualizar a tabela Pessoa
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa.setNome(cliente.getPessoa().getNome());
        pessoa.setEndereco(cliente.getPessoa().getEndereco());
        pessoa.setTelefone(cliente.getPessoa().getTelefone());
        pessoa.setEmail(cliente.getPessoa().getEmail());
        pessoa.setDataNascimento(cliente.getPessoa().getDataNascimento());

        pessoaRepository.save(pessoa);

        // Atualizar a tabela Cliente
        existingCliente.setTipoCliente(cliente.getTipoCliente());

        return clienteRepository.save(existingCliente);
    }

    @Override
    public void deleteCliente(Long id) {
        // Remover o cliente
        clienteRepository.deleteById(id);

        // Remover a pessoa correspondente
        pessoaRepository.deleteById(id);
    }
}
