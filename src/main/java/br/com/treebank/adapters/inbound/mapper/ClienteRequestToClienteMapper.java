package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.request.ClienteRequest;
import br.com.treebank.application.core.domain.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClienteRequestToClienteMapper {

    public Cliente mapper(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequest, cliente);
        return cliente;
    }
}
