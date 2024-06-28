package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.mapper.AgenciaEntityToAgenciaMapper;
import br.com.treebank.adapters.inbound.mapper.AgenciaRequestToAgenciaMapper;
import br.com.treebank.adapters.inbound.mapper.AgenciaEntityToAgenciaResponseMapper;
import br.com.treebank.adapters.inbound.request.AgenciaRequest;
import br.com.treebank.adapters.inbound.response.AgenciaResponse;
import br.com.treebank.application.core.domain.Agencia;
import br.com.treebank.application.core.domain.Funcionario;
import br.com.treebank.application.ports.in.AgenciaServicePort;
import br.com.treebank.application.ports.in.FuncionarioServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agencia")
@AllArgsConstructor
public class AgenciaController {
    private final AgenciaServicePort agenciaServicePort;
    private final FuncionarioServicePort funcionarioServicePort;
    private final AgenciaRequestToAgenciaMapper agenciaRequestToAgenciaMapper;
    private final AgenciaEntityToAgenciaResponseMapper agenciaEntityToAgenciaResponseMapper;
    private final AgenciaEntityToAgenciaMapper agenciaEntityToAgenciaMapper;

    @PostMapping
    public AgenciaResponse salvarAgencia(@RequestBody AgenciaRequest agenciaRequest) {
        Agencia agencia = agenciaRequestToAgenciaMapper.mapper(agenciaRequest);
        if (agenciaRequest.getGerenteId() != null) {
            Funcionario gerente = funcionarioServicePort.buscarPorId(agenciaRequest.getGerenteId());
            agencia.setGerente(gerente);
        }
        Agencia savedAgencia = agenciaServicePort.salvar(agencia);
        return agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(savedAgencia));
    }

    @GetMapping("/{id}")
    public AgenciaResponse buscarPorId(@PathVariable Long id) {
        Agencia agencia = agenciaServicePort.buscarPorId(id);
        if (agencia == null) {
            return null;
        }
        return agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(agencia));
    }

    @GetMapping
    public List<AgenciaResponse> listarTodos() {
        return agenciaServicePort.listarTodos()
                .stream()
                .map(agencia -> agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(agencia)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public AgenciaResponse atualizarAgencia(@PathVariable Long id, @RequestBody AgenciaRequest agenciaRequest) {
        Agencia agencia = agenciaRequestToAgenciaMapper.mapper(agenciaRequest);
        agencia.setId(id);
        if (agenciaRequest.getGerenteId() != null) {
            Funcionario gerente = funcionarioServicePort.buscarPorId(agenciaRequest.getGerenteId());
            agencia.setGerente(gerente);
        }
        Agencia updatedAgencia = agenciaServicePort.atualizar(agencia);
        return agenciaEntityToAgenciaResponseMapper.toResponse(agenciaEntityToAgenciaMapper.toEntity(updatedAgencia));
    }

    @DeleteMapping("/{id}")
    public void deletarAgencia(@PathVariable Long id) {
        agenciaServicePort.deletarPorId(id);
    }
}
