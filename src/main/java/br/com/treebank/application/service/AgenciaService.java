package br.com.treebank.application.service;

import br.com.treebank.application.port.in.AgenciaUseCase;
import br.com.treebank.application.port.out.AgenciaRepository;
import br.com.treebank.domain.Agencia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaService implements AgenciaUseCase {
    private final AgenciaRepository agenciaRepository;

    public AgenciaService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public List<Agencia> getAllAgencias() {
        return agenciaRepository.findAll();
    }

    @Override
    public Agencia getAgenciaById(Long id) {
        return agenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agencia não encontrada"));
    }

    @Override
    public Agencia createAgencia(Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    @Override
    public Agencia updateAgencia(Long id, Agencia agencia) {
        Agencia existingAgencia = agenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agencia não encontrada"));
        existingAgencia.setNome(agencia.getNome());
        existingAgencia.setEndereco(agencia.getEndereco());
        existingAgencia.setTelefone(agencia.getTelefone());
        existingAgencia.setGerente(agencia.getGerente());
        return agenciaRepository.save(existingAgencia);
    }

    @Override
    public void deleteAgencia(Long id) {
        agenciaRepository.deleteById(id);
    }
}
