package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.entity.FuncionarioEntity;
import br.com.treebank.adapters.inbound.mapper.AgenciaRequestToAgenciaMapper;
import br.com.treebank.adapters.inbound.mapper.AgenciaEntityToAgenciaResponseMapper;
import br.com.treebank.adapters.inbound.mapper.AgenciaEntityToAgenciaMapper;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioMapper;
import br.com.treebank.adapters.inbound.request.AgenciaRequest;
import br.com.treebank.adapters.inbound.response.AgenciaResponse;
import br.com.treebank.adapters.outbound.repository.FuncionarioRepository;
import br.com.treebank.application.core.domain.Agencia;
import br.com.treebank.application.ports.in.AgenciaServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agencia")
@AllArgsConstructor
@Tag(name = "Agencia", description = "Gerenciamento de agências")
public class AgenciaController {
    private final AgenciaServicePort agenciaServicePort;
    private final AgenciaRequestToAgenciaMapper agenciaRequestToAgenciaMapper;
    private final AgenciaEntityToAgenciaResponseMapper agenciaEntityToAgenciaResponseMapper;
    private final AgenciaEntityToAgenciaMapper agenciaEntityToAgenciaMapper;
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioEntityToFuncionarioMapper funcionarioEntityToFuncionarioMapper;

    @PostMapping
    @Operation(summary = "Criar nova agência", description = "Cria uma nova agência com os dados fornecidos")
    public AgenciaResponse salvarAgencia(@Valid @RequestBody AgenciaRequest agenciaRequest) {
        Agencia agencia = agenciaRequestToAgenciaMapper.mapper(agenciaRequest);
        FuncionarioEntity gerenteEntity = funcionarioRepository.findById(agenciaRequest.getGerenteId()).orElse(null);
        agencia.setGerente(funcionarioEntityToFuncionarioMapper.toDomain(gerenteEntity));
        Agencia savedAgencia = agenciaServicePort.salvar(agencia);
        return agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(savedAgencia));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar agência por ID", description = "Retorna uma agência baseada no ID fornecido")
    public AgenciaResponse buscarPorId(@PathVariable Long id) {
        Agencia agencia = agenciaServicePort.buscarPorId(id);
        if (agencia == null) {
            return null;
        }
        return agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(agencia));
    }

    @GetMapping
    @Operation(summary = "Listar todas as agências", description = "Retorna uma lista de todas as agências")
    public List<AgenciaResponse> listarTodos() {
        return agenciaServicePort.listarTodos()
                .stream()
                .map(agencia -> agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(agencia)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar agência", description = "Atualiza os dados de uma agência existente")
    public AgenciaResponse atualizarAgencia(@PathVariable Long id, @Valid @RequestBody AgenciaRequest agenciaRequest) {
        Agencia agencia = agenciaRequestToAgenciaMapper.mapper(agenciaRequest);
        agencia.setId(id);
        Agencia updatedAgencia = agenciaServicePort.atualizar(agencia);
        return agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(updatedAgencia));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar agência", description = "Deleta uma agência existente baseada no ID fornecido")
    public void deletarAgencia(@PathVariable Long id) {
        agenciaServicePort.deletarPorId(id);
    }
}
