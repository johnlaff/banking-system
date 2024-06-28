package br.com.treebank.adapters.outbound;

import br.com.treebank.adapters.inbound.entity.FuncionarioEntity;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioMapper;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioResponseMapper;
import br.com.treebank.adapters.outbound.repository.FuncionarioRepository;
import br.com.treebank.application.core.domain.Funcionario;
import br.com.treebank.application.ports.out.FuncionarioRepositoryPort;
import br.com.treebank.adapters.inbound.response.FuncionarioResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FuncionarioRepositoryAdapter implements FuncionarioRepositoryPort {
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioEntityToFuncionarioMapper funcionarioMapper;
    private final FuncionarioEntityToFuncionarioResponseMapper funcionarioResponseMapper;

    public FuncionarioRepositoryAdapter(FuncionarioRepository funcionarioRepository, FuncionarioEntityToFuncionarioMapper funcionarioMapper, FuncionarioEntityToFuncionarioResponseMapper funcionarioResponseMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
        this.funcionarioResponseMapper = funcionarioResponseMapper;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        FuncionarioEntity funcionarioEntity = funcionarioMapper.toEntity(funcionario);
        funcionarioEntity = funcionarioRepository.save(funcionarioEntity);
        return funcionarioMapper.toDomain(funcionarioEntity);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        FuncionarioEntity funcionarioEntity = funcionarioRepository.findById(id).orElse(null);
        if (funcionarioEntity == null) {
            return null;
        }
        return funcionarioMapper.toDomain(funcionarioEntity);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionarioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario) {
        FuncionarioEntity funcionarioEntity = funcionarioRepository.findById(funcionario.getId()).orElse(null);
        if (funcionarioEntity == null) {
            return null;
        }
        BeanUtils.copyProperties(funcionario, funcionarioEntity);
        funcionarioEntity = funcionarioRepository.save(funcionarioEntity);
        return funcionarioMapper.toDomain(funcionarioEntity);
    }

    @Override
    public void deletarPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
