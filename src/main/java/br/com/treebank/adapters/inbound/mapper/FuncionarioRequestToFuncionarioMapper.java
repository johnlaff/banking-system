package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.request.FuncionarioRequest;
import br.com.treebank.application.core.domain.Funcionario;
import br.com.treebank.application.core.domain.Agencia;
import br.com.treebank.application.ports.in.AgenciaServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioRequestToFuncionarioMapper {

    private final AgenciaServicePort agenciaServicePort;

    public FuncionarioRequestToFuncionarioMapper(AgenciaServicePort agenciaServicePort) {
        this.agenciaServicePort = agenciaServicePort;
    }

    public Funcionario mapper(FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioRequest, funcionario);

        if (funcionarioRequest.getAgenciaId() != null) {
            Agencia agencia = agenciaServicePort.buscarPorId(funcionarioRequest.getAgenciaId());
            funcionario.setAgencia(agencia);
        }

        return funcionario;
    }
}