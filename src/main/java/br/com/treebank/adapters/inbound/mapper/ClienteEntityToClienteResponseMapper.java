package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.ClienteEntity;
import br.com.treebank.adapters.inbound.response.ClienteResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityToClienteResponseMapper {
    public ClienteResponse toResponse(ClienteEntity clienteEntity) {
        ClienteResponse clienteResponse = new ClienteResponse();
        BeanUtils.copyProperties(clienteEntity, clienteResponse);
        return clienteResponse;
    }
}
