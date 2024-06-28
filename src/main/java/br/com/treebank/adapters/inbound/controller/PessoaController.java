package br.com.treebank.adapters.inbound.controller;

import br.com.treebank.adapters.inbound.mapper.PessoaEntityToPessoaMapper;
import br.com.treebank.adapters.inbound.mapper.PessoaRequestToPessoaMapper;
import br.com.treebank.adapters.inbound.mapper.PessoaEntityToPessoaResponseMapper;
import br.com.treebank.adapters.inbound.request.PessoaRequest;
import br.com.treebank.adapters.inbound.response.PessoaResponse;
import br.com.treebank.application.core.domain.Pessoa;
import br.com.treebank.application.ports.in.PessoaServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {
    private final PessoaServicePort pessoaServicePort;
    private final PessoaRequestToPessoaMapper pessoaRequestToPessoaMapper;
    private final PessoaEntityToPessoaResponseMapper pessoaEntityToPessoaResponseMapper;
    private final PessoaEntityToPessoaMapper pessoaEntityToPessoaMapper;

    @PostMapping
    public PessoaResponse salvarPessoa(@RequestBody @Valid PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaRequestToPessoaMapper.mapper(pessoaRequest);
        Pessoa savedPessoa = pessoaServicePort.salvar(pessoa);
        return pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(savedPessoa));
    }

    @GetMapping("/{id}")
    public PessoaResponse buscarPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaServicePort.buscarPorId(id);
        if (pessoa == null) {
            return null;
        }
        return pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(pessoa));
    }

    @GetMapping
    public List<PessoaResponse> listarTodos() {
        return pessoaServicePort.listarTodos()
                .stream()
                .map(pessoa -> pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(pessoa)))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PessoaResponse atualizarPessoa(@PathVariable Long id, @RequestBody @Valid PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaRequestToPessoaMapper.mapper(pessoaRequest);
        pessoa.setId(id);
        Pessoa updatedPessoa = pessoaServicePort.atualizar(pessoa);
        return pessoaEntityToPessoaResponseMapper.toResponse(pessoaEntityToPessoaMapper.toEntity(updatedPessoa));
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaServicePort.deletarPorId(id);
    }
}
