package br.com.treebank.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.treebank.infrastructure.adapter.repository")
public class SpringConfig {
}
