package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.mapper.PessoaRequestToPessoaMapper;
import br.com.treebank.adapters.inbound.mapper.PessoaEntityToPessoaResponseMapper;
import br.com.treebank.adapters.inbound.mapper.PessoaEntityToPessoaMapper;
import br.com.treebank.adapters.inbound.request.PessoaRequest;
import br.com.treebank.adapters.inbound.response.PessoaResponse;
import br.com.treebank.application.core.domain.Pessoa;
import br.com.treebank.application.ports.in.PessoaServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
@Tag(name = "Pessoa", description = "Gerenciamento de pessoas")
public class PessoaController {
    private final PessoaServicePort pessoaServicePort;
    private final PessoaRequestToPessoaMapper pessoaRequestToPessoaMapper;
    private final PessoaEntityToPessoaResponseMapper pessoaEntityToPessoaResponseMapper;
    private final PessoaEntityToPessoaMapper pessoaEntityToPessoaMapper;

    @PostMapping
    @Operation(summary = "Criar nova pessoa", description = "Cria uma nova pessoa com os dados fornecidos")
    public PessoaResponse salvarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaRequestToPessoaMapper.mapper(pessoaRequest);
        Pessoa savedPessoa = pessoaServicePort.salvar(pessoa);
        return pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(savedPessoa));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pessoa por ID", description = "Retorna uma pessoa baseada no ID fornecido")
    public PessoaResponse buscarPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaServicePort.buscarPorId(id);
        if (pessoa == null) {
            return null;
        }
        return pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(pessoa));
    }

    @GetMapping
    @Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista de todas as pessoas")
    public List<PessoaResponse> listarTodos() {
        return pessoaServicePort.listarTodos()
                .stream()
                .map(pessoa -> pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(pessoa)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pessoa", description = "Atualiza os dados de uma pessoa existente")
    public PessoaResponse atualizarPessoa(@PathVariable Long id, @Valid @RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaRequestToPessoaMapper.mapper(pessoaRequest);
        pessoa.setId(id);
        Pessoa updatedPessoa = pessoaServicePort.atualizar(pessoa);
        return pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(updatedPessoa));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pessoa", description = "Deleta uma pessoa existente baseada no ID fornecido")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaServicePort.deletarPorId(id);
    }
}
