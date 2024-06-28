package br.com.treebank.adapters.inbound.mapper;

import br.com.treebank.adapters.inbound.entity.AgenciaEntity;
import br.com.treebank.adapters.inbound.response.AgenciaResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AgenciaEntityToAgenciaResponseMapper {
    public AgenciaResponse toResponse(AgenciaEntity agenciaEntity) {
        AgenciaResponse agenciaResponse = new AgenciaResponse();
        BeanUtils.copyProperties(agenciaEntity, agenciaResponse);
        if (agenciaEntity.getGerente() != null) {
            agenciaResponse.setGerenteId(agenciaEntity.getGerente().getId());
        }
        return agenciaResponse;
    }
}
