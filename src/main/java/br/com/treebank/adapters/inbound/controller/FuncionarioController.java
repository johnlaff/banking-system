package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.mapper.FuncionarioRequestToFuncionarioMapper;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioResponseMapper;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioMapper;
import br.com.treebank.adapters.inbound.request.FuncionarioRequest;
import br.com.treebank.adapters.inbound.response.FuncionarioResponse;
import br.com.treebank.application.core.domain.Funcionario;
import br.com.treebank.application.ports.in.FuncionarioServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
@Tag(name = "Funcionario", description = "Gerenciamento de funcionários")
public class FuncionarioController {
    private final FuncionarioServicePort funcionarioServicePort;
    private final FuncionarioRequestToFuncionarioMapper funcionarioRequestToFuncionarioMapper;
    private final FuncionarioEntityToFuncionarioResponseMapper funcionarioEntityToFuncionarioResponseMapper;
    private final FuncionarioEntityToFuncionarioMapper funcionarioEntityToFuncionarioMapper;

    @PostMapping
    @Operation(summary = "Criar novo funcionário", description = "Cria um novo funcionário com os dados fornecidos")
    public FuncionarioResponse salvarFuncionario(@Valid @RequestBody FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = funcionarioRequestToFuncionarioMapper.mapper(funcionarioRequest);
        Funcionario savedFuncionario = funcionarioServicePort.salvar(funcionario);
        return funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(savedFuncionario));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar funcionário por ID", description = "Retorna um funcionário baseado no ID fornecido")
    public FuncionarioResponse buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioServicePort.buscarPorId(id);
        if (funcionario == null) {
            return null;
        }
        return funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(funcionario));
    }

    @GetMapping
    @Operation(summary = "Listar todos os funcionários", description = "Retorna uma lista de todos os funcionários")
    public List<FuncionarioResponse> listarTodos() {
        return funcionarioServicePort.listarTodos()
                .stream()
                .map(funcionario -> funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(funcionario)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar funcionário", description = "Atualiza os dados de um funcionário existente")
    public FuncionarioResponse atualizarFuncionario(@PathVariable Long id, @Valid @RequestBody FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = funcionarioRequestToFuncionarioMapper.mapper(funcionarioRequest);
        funcionario.setId(id);
        Funcionario updatedFuncionario = funcionarioServicePort.atualizar(funcionario);
        return funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(updatedFuncionario));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar funcionário", description = "Deleta um funcionário existente baseado no ID fornecido")
    public void deletarFuncionario(@PathVariable Long id) {
        funcionarioServicePort.deletarPorId(id);
    }
}
