package br.com.treebank.adapters.outbound;

import br.com.treebank.adapters.inbound.entity.ClienteEntity;
import br.com.treebank.adapters.outbound.repository.ClienteRepository;
import br.com.treebank.application.core.domain.Cliente;
import br.com.treebank.application.ports.out.ClienteRepositoryPort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {
    private final ClienteRepository clienteRepository;

    public ClienteRepositoryAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        BeanUtils.copyProperties(cliente, clienteEntity);
        clienteEntity = clienteRepository.save(clienteEntity);
        BeanUtils.copyProperties(clienteEntity, cliente);
        return cliente;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElse(null);
        if (clienteEntity == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteEntity, cliente);
        return cliente;
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(clienteEntity -> {
                    Cliente cliente = new Cliente();
                    BeanUtils.copyProperties(clienteEntity, cliente);
                    return cliente;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        ClienteEntity clienteEntity = clienteRepository.findById(cliente.getId()).orElse(null);
        if (clienteEntity == null) {
            return null;
        }
        BeanUtils.copyProperties(cliente, clienteEntity);
        clienteEntity = clienteRepository.save(clienteEntity);
        BeanUtils.copyProperties(clienteEntity, cliente);
        return cliente;
    }

    @Override
    public void deletarPorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
