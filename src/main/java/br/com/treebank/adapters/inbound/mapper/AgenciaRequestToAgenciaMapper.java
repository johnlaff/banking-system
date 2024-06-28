package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.request.AgenciaRequest;
import br.com.treebank.application.core.domain.Agencia;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AgenciaRequestToAgenciaMapper {
    public Agencia mapper(AgenciaRequest agenciaRequest) {
        Agencia agencia = new Agencia();
        BeanUtils.copyProperties(agenciaRequest, agencia);
        return agencia;
    }
}
