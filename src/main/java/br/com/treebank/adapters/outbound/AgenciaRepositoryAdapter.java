package br.com.treebank.adapters.outbound;

import br.com.treebank.adapters.inbound.entity.AgenciaEntity;
import br.com.treebank.adapters.inbound.entity.FuncionarioEntity;
import br.com.treebank.adapters.inbound.mapper.AgenciaEntityToAgenciaMapper;
import br.com.treebank.adapters.inbound.mapper.AgenciaEntityToAgenciaResponseMapper;
import br.com.treebank.adapters.inbound.mapper.FuncionarioEntityToFuncionarioMapper;
import br.com.treebank.adapters.inbound.response.AgenciaResponse;
import br.com.treebank.adapters.outbound.repository.AgenciaRepository;
import br.com.treebank.adapters.outbound.repository.FuncionarioRepository;
import br.com.treebank.application.core.domain.Agencia;
import br.com.treebank.application.ports.out.AgenciaRepositoryPort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgenciaRepositoryAdapter implements AgenciaRepositoryPort {
    private final AgenciaRepository agenciaRepository;
    private final AgenciaEntityToAgenciaMapper agenciaMapper;
    private final AgenciaEntityToAgenciaResponseMapper agenciaResponseMapper;
    private final FuncionarioEntityToFuncionarioMapper funcionarioMapper;
    private final FuncionarioRepository funcionarioRepository;

    public AgenciaRepositoryAdapter(AgenciaRepository agenciaRepository, AgenciaEntityToAgenciaMapper agenciaMapper, AgenciaEntityToAgenciaResponseMapper agenciaResponseMapper, FuncionarioEntityToFuncionarioMapper funcionarioMapper, FuncionarioRepository funcionarioRepository) {
        this.agenciaRepository = agenciaRepository;
        this.agenciaMapper = agenciaMapper;
        this.agenciaResponseMapper = agenciaResponseMapper;
        this.funcionarioMapper = funcionarioMapper;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Agencia salvar(Agencia agencia) {
        AgenciaEntity agenciaEntity = agenciaMapper.toEntity(agencia);
        if (agencia.getGerente() != null && agencia.getGerente().getId() != null) {
            FuncionarioEntity gerenteEntity = funcionarioRepository.findById(agencia.getGerente().getId()).orElse(null);
            if (gerenteEntity != null) {
                agenciaEntity.setGerente(gerenteEntity);
            }
        }
        agenciaEntity = agenciaRepository.save(agenciaEntity);
        return agenciaMapper.toDomain(agenciaEntity);
    }

    @Override
    public Agencia buscarPorId(Long id) {
        AgenciaEntity agenciaEntity = agenciaRepository.findById(id).orElse(null);
        if (agenciaEntity == null) {
            return null;
        }
        return agenciaMapper.toDomain(agenciaEntity);
    }

    @Override
    public List<Agencia> listarTodos() {
        return agenciaRepository.findAll()
                .stream()
                .map(agenciaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Agencia atualizar(Agencia agencia) {
        AgenciaEntity agenciaEntity = agenciaRepository.findById(agencia.getId()).orElse(null);
        if (agenciaEntity == null) {
            return null;
        }
        BeanUtils.copyProperties(agencia, agenciaEntity);
        if (agencia.getGerente() != null) {
            agenciaEntity.setGerente(funcionarioMapper.toEntity(agencia.getGerente()));
        }
        agenciaEntity = agenciaRepository.save(agenciaEntity);
        return agenciaMapper.toDomain(agenciaEntity);
    }

    @Override
    public void deletarPorId(Long id) {
        agenciaRepository.deleteById(id);
    }
}
