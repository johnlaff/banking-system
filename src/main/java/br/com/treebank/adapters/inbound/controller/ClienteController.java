package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.mapper.ClienteEntityToClienteMapper;
import br.com.treebank.adapters.inbound.mapper.ClienteRequestToClienteMapper;
import br.com.treebank.adapters.inbound.mapper.ClienteEntityToClienteResponseMapper;
import br.com.treebank.adapters.inbound.request.ClienteRequest;
import br.com.treebank.adapters.inbound.response.ClienteResponse;
import br.com.treebank.application.core.domain.Cliente;
import br.com.treebank.application.ports.in.ClienteServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
@Tag(name = "Cliente", description = "Gerenciamento de clientes")
public class ClienteController {
    private final ClienteServicePort clienteServicePort;
    private final ClienteRequestToClienteMapper clienteRequestToClienteMapper;
    private final ClienteEntityToClienteResponseMapper clienteEntityToClienteResponseMapper;
    private final ClienteEntityToClienteMapper clienteEntityToClienteMapper;

    @PostMapping
    @Operation(summary = "Criar novo cliente", description = "Cria um novo cliente com os dados fornecidos")
    public ClienteResponse salvarCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequestToClienteMapper.mapper(clienteRequest);
        Cliente savedCliente = clienteServicePort.salvar(cliente);
        return clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(savedCliente));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID", description = "Retorna um cliente baseado no ID fornecido")
    public ClienteResponse buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteServicePort.buscarPorId(id);
        if (cliente == null) {
            return null;
        }
        return clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(cliente));
    }

    @GetMapping
    @Operation(summary = "Listar todos os clientes", description = "Retorna uma lista de todos os clientes")
    public List<ClienteResponse> listarTodos() {
        return clienteServicePort.listarTodos()
                .stream()
                .map(cliente -> clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(cliente)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente", description = "Atualiza os dados de um cliente existente")
    public ClienteResponse atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequestToClienteMapper.mapper(clienteRequest);
        cliente.setId(id);
        Cliente updatedCliente = clienteServicePort.atualizar(cliente);
        return clienteEntityToClienteResponseMapper.toResponse(clienteEntityToClienteMapper.toEntity(updatedCliente));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cliente", description = "Deleta um cliente existente baseado no ID fornecido")
    public void deletarCliente(@PathVariable Long id) {
        clienteServicePort.deletarPorId(id);
    }
}
