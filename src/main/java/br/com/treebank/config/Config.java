package br.com.treebank.config;

import br.com.treebank.adapters.outbound.AgenciaRepositoryAdapter;
import br.com.treebank.adapters.outbound.ClienteRepositoryAdapter;
import br.com.treebank.adapters.outbound.FuncionarioRepositoryAdapter;
import br.com.treebank.adapters.outbound.PessoaRepositoryAdapter;
import br.com.treebank.adapters.outbound.repository.ClienteRepository;
import br.com.treebank.adapters.outbound.repository.FuncionarioRepository;
import br.com.treebank.adapters.outbound.repository.PessoaRepository;
import br.com.treebank.adapters.outbound.repository.AgenciaRepository;
import br.com.treebank.application.core.service.ClienteService;
import br.com.treebank.application.core.service.FuncionarioService;
import br.com.treebank.application.core.service.PessoaService;
import br.com.treebank.application.core.service.AgenciaService;
import br.com.treebank.application.ports.out.ClienteRepositoryPort;
import br.com.treebank.application.ports.out.FuncionarioRepositoryPort;
import br.com.treebank.application.ports.out.PessoaRepositoryPort;
import br.com.treebank.application.ports.out.AgenciaRepositoryPort;
import br.com.treebank.adapters.inbound.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public PessoaService pessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        return new PessoaService(pessoaRepositoryPort);
    }

    @Bean
    public ClienteService clienteService(ClienteRepositoryPort clienteRepositoryPort) {
        return new ClienteService(clienteRepositoryPort);
    }

    @Bean
    public FuncionarioService funcionarioService(FuncionarioRepositoryPort funcionarioRepositoryPort) {
        return new FuncionarioService(funcionarioRepositoryPort);
    }

    @Bean
    public AgenciaService agenciaService(AgenciaRepositoryPort agenciaRepositoryPort) {
        return new AgenciaService(agenciaRepositoryPort);
    }

    @Bean
    public PessoaRepositoryPort pessoaRepositoryPort(PessoaRepository pessoaRepository) {
        return new PessoaRepositoryAdapter(pessoaRepository);
    }

    @Bean
    public ClienteRepositoryPort clienteRepositoryPort(ClienteRepository clienteRepository) {
        return new ClienteRepositoryAdapter(clienteRepository);
    }

    @Bean
    public FuncionarioRepositoryPort funcionarioRepositoryPort(FuncionarioRepository funcionarioRepository, FuncionarioEntityToFuncionarioMapper funcionarioMapper, FuncionarioEntityToFuncionarioResponseMapper funcionarioResponseMapper) {
        return new FuncionarioRepositoryAdapter(funcionarioRepository, funcionarioMapper, funcionarioResponseMapper);
    }

    @Bean
    public AgenciaRepositoryPort agenciaRepositoryPort(AgenciaRepository agenciaRepository, AgenciaEntityToAgenciaMapper agenciaMapper, AgenciaEntityToAgenciaResponseMapper agenciaResponseMapper, FuncionarioEntityToFuncionarioMapper funcionarioMapper, FuncionarioRepository funcionarioRepository) {
        return new AgenciaRepositoryAdapter(agenciaRepository, agenciaMapper, agenciaResponseMapper, funcionarioMapper, funcionarioRepository);
    }
}
