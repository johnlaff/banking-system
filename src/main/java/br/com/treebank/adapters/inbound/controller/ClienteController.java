package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.mapper.ClienteEntityToClienteMapper;
import br.com.treebank.adapters.inbound.mapper.ClienteRequestToClienteMapper;
import br.com.treebank.adapters.inbound.mapper.ClienteEntityToClienteResponseMapper;
import br.com.treebank.adapters.inbound.request.ClienteRequest;
import br.com.treebank.adapters.inbound.response.ClienteResponse;
import br.com.treebank.application.core.domain.Cliente;
import br.com.treebank.application.ports.in.ClienteServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private final ClienteServicePort clienteServicePort;
    private final ClienteRequestToClienteMapper clienteRequestToClienteMapper;
    private final ClienteEntityToClienteResponseMapper clienteEntityToClienteResponseMapper;
    private final ClienteEntityToClienteMapper clienteEntityToClienteMapper;

    @PostMapping
    public ClienteResponse salvarCliente(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequestToClienteMapper.mapper(clienteRequest);
        Cliente savedCliente = clienteServicePort.salvar(cliente);
        return clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(savedCliente));
    }

    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteServicePort.buscarPorId(id);
        if (cliente == null) {
            return null;
        }
        return clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(cliente));
    }

    @GetMapping
    public List<ClienteResponse> listarTodos() {
        return clienteServicePort.listarTodos()
                .stream()
                .map(cliente -> clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(cliente)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequestToClienteMapper.mapper(clienteRequest);
        cliente.setId(id);
        Cliente updatedCliente = clienteServicePort.atualizar(cliente);
        return clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(updatedCliente));
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteServicePort.deletarPorId(id);
    }
}
