package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.mapper.FuncionarioRequestToFuncionarioMapper;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioResponseMapper;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioMapper;
import br.com.treebank.adapters.inbound.request.FuncionarioRequest;
import br.com.treebank.adapters.inbound.response.FuncionarioResponse;
import br.com.treebank.application.core.domain.Funcionario;
import br.com.treebank.application.ports.in.FuncionarioServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioController {
    private final FuncionarioServicePort funcionarioServicePort;
    private final FuncionarioRequestToFuncionarioMapper funcionarioRequestToFuncionarioMapper;
    private final FuncionarioEntityToFuncionarioResponseMapper funcionarioEntityToFuncionarioResponseMapper;
    private final FuncionarioEntityToFuncionarioMapper funcionarioEntityToFuncionarioMapper;

    @PostMapping
    public FuncionarioResponse salvarFuncionario(@RequestBody @Valid FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = funcionarioRequestToFuncionarioMapper.mapper(funcionarioRequest);
        Funcionario savedFuncionario = funcionarioServicePort.salvar(funcionario);
        return funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(savedFuncionario));
    }

    @GetMapping("/{id}")
    public FuncionarioResponse buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioServicePort.buscarPorId(id);
        if (funcionario == null) {
            return null;
        }
        return funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(funcionario));
    }

    @GetMapping
    public List<FuncionarioResponse> listarTodos() {
        return funcionarioServicePort.listarTodos()
                .stream()
                .map(funcionario -> funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(funcionario)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public FuncionarioResponse atualizarFuncionario(@PathVariable Long id, @RequestBody @Valid FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = funcionarioRequestToFuncionarioMapper.mapper(funcionarioRequest);
        funcionario.setId(id);
        Funcionario updatedFuncionario = funcionarioServicePort.atualizar(funcionario);
        return funcionarioEntityToFuncionarioResponseMapper.toResponse(funcionarioEntityToFuncionarioMapper.toEntity(updatedFuncionario));
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id) {
        funcionarioServicePort.deletarPorId(id);
    }
}
