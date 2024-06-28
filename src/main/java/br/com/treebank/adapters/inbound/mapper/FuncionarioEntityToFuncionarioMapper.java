package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.AgenciaEntity;
import br.com.treebank.adapters.inbound.entity.FuncionarioEntity;
import br.com.treebank.application.core.domain.Agencia;
import br.com.treebank.application.core.domain.Funcionario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioEntityToFuncionarioMapper {
    public Funcionario toDomain(FuncionarioEntity funcionarioEntity) {
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioEntity, funcionario);
        if (funcionarioEntity.getAgencia() != null) {
            Agencia agencia = new Agencia();
            BeanUtils.copyProperties(funcionarioEntity.getAgencia(), agencia);
            funcionario.setAgencia(agencia);
        }
        return funcionario;
    }

    public FuncionarioEntity toEntity(Funcionario funcionario) {
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
        BeanUtils.copyProperties(funcionario, funcionarioEntity);
        if (funcionario.getAgencia() != null) {
            AgenciaEntity agenciaEntity = new AgenciaEntity();
            BeanUtils.copyProperties(funcionario.getAgencia(), agenciaEntity);
            funcionarioEntity.setAgencia(agenciaEntity);
        }
        return funcionarioEntity;
    }
}
