package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.AgenciaEntity;
import br.com.treebank.adapters.inbound.entity.FuncionarioEntity;
import br.com.treebank.application.core.domain.Agencia;
import br.com.treebank.application.core.domain.Funcionario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AgenciaEntityToAgenciaMapper {
    public Agencia toDomain(AgenciaEntity agenciaEntity) {
        Agencia agencia = new Agencia();
        BeanUtils.copyProperties(agenciaEntity, agencia);
        if (agenciaEntity.getGerente() != null) {
            Funcionario gerente = new Funcionario();
            BeanUtils.copyProperties(agenciaEntity.getGerente(), gerente);
            agencia.setGerente(gerente);
        }
        return agencia;
    }

    public AgenciaEntity toEntity(Agencia agencia) {
        AgenciaEntity agenciaEntity = new AgenciaEntity();
        BeanUtils.copyProperties(agencia, agenciaEntity);
        if (agencia.getGerente() != null) {
            FuncionarioEntity gerenteEntity = new FuncionarioEntity();
            BeanUtils.copyProperties(agencia.getGerente(), gerenteEntity);
            agenciaEntity.setGerente(gerenteEntity);
        }
        return agenciaEntity;
    }
}