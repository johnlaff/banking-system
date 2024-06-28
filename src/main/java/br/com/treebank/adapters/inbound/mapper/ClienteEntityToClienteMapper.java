package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.ClienteEntity;
import br.com.treebank.application.core.domain.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityToClienteMapper {
    public Cliente toDomain(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteEntity, cliente);
        return cliente;
    }

    public ClienteEntity toEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        BeanUtils.copyProperties(cliente, clienteEntity);
        return clienteEntity;
    }
}
