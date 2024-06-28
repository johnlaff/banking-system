# TreeBank

## Descrição do Projeto

TreeBank é um sistema bancário desenvolvido utilizando a Arquitetura Hexagonal em Java com Spring Boot. Este projeto tem como objetivo demonstrar as vantagens da Arquitetura Hexagonal ao construir uma aplicação modular, de fácil manutenção e escalável.

## Arquitetura Hexagonal

### Vantagens

- **Independência de Frameworks**: A aplicação é construída de maneira que o núcleo do negócio (domínio) é independente de qualquer framework. Isso facilita a troca de tecnologias no futuro.
- **Facilidade de Testes**: Com a separação clara entre o núcleo da aplicação e as interfaces, torna-se mais fácil escrever testes unitários para o domínio sem dependências externas.
- **Manutenção e Evolução**: A modularidade proporcionada pela arquitetura hexagonal permite que partes da aplicação sejam modificadas ou substituídas sem impactar o restante do sistema.
- **Portabilidade**: A lógica de negócio pode ser facilmente adaptada para diferentes interfaces (web, console, desktop) apenas criando novos adaptadores.

### Estrutura de Pacotes

- **adapters**
  - **inbound**
    - `entity` - Entidades de persistência de dados.
    - `mapper` - Classes de mapeamento entre entidades e domínios.
    - `request` - DTOs para receber dados das requisições.
    - `controller` - Controladores para gerenciar as rotas da aplicação.
  - **outbound**
    - `repository` - Interfaces de repositórios para persistência de dados.
    - Adaptadores que implementam as interfaces dos repositórios.
- **application**
  - **core**
    - `domain` - Classes de domínio da aplicação.
    - `exception` - Classes de exceção customizadas.
    - `service` - Serviços de negócio.
  - **ports**
    - `in` - Interfaces dos serviços usados pelos controladores.
    - `out` - Interfaces dos adaptadores de persistência.
- **config**
  - Configurações da aplicação, como Swagger.

## Fluxo da Aplicação

1. **Requisição**: A aplicação recebe uma requisição HTTP através dos controladores localizados em `adapters.inbound.controller`.
2. **Validação**: Os dados da requisição são validados utilizando as anotações do Jakarta Validation.
3. **Mapeamento**: Os DTOs de requisição são mapeados para as classes de domínio utilizando os mappers em `adapters.inbound.mapper`.
4. **Serviço**: As classes de domínio são passadas para os serviços de negócio em `application.core.service`, que contêm a lógica principal da aplicação.
5. **Persistência**: Os serviços chamam os adaptadores de persistência localizados em `adapters.outbound`, que implementam as interfaces definidas em `application.ports.out`.
6. **Resposta**: Os resultados são mapeados de volta para os DTOs de resposta e retornados ao cliente.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.0
- Spring Data JPA
- Hibernate
- Flyway
- Microsoft SQL Server
- Lombok
- SpringDoc OpenAPI (Swagger)

## Configuração do Ambiente

### Pré-requisitos

- Java 17 ou superior
- Maven
- Banco de dados Microsoft SQL Server

### Passos para Configuração

1. **Clone o repositório**

   ```bash
   git clone https://github.com/seu-usuario/treebank.git
   cd treebank
   ```

2. **Configure o banco de dados**

   Crie um banco de dados no Microsoft SQL Server e configure as variáveis de ambiente no arquivo `application.properties`:

   ```properties
   spring.datasource.url=${DB_URL}
   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
   spring.datasource.driverClassName=${DB_DRIVER}

   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

   springdoc.api-docs.path=/api-docs
   springdoc.swagger-ui.path=/swagger-ui.html
   ```

3. **Execute a aplicação**

   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a documentação da API**

   Acesse `http://localhost:8080/swagger-ui.html` para visualizar e interagir com a documentação da API.

## Endpoints Principais

### Cliente

- **POST** `/cliente`
  - Cria um novo cliente.
- **GET** `/cliente/{id}`
  - Busca um cliente pelo ID.
- **GET** `/cliente`
  - Lista todos os clientes.
- **PUT** `/cliente/{id}`
  - Atualiza os dados de um cliente existente.
- **DELETE** `/cliente/{id}`
  - Deleta um cliente existente.

### Agência

- **POST** `/agencia`
  - Cria uma nova agência.
- **GET** `/agencia/{id}`
  - Busca uma agência pelo ID.
- **GET** `/agencia`
  - Lista todas as agências.
- **PUT** `/agencia/{id}`
  - Atualiza os dados de uma agência existente.
- **DELETE** `/agencia/{id}`
  - Deleta uma agência existente.

### Funcionário

- **POST** `/funcionario`
  - Cria um novo funcionário.
- **GET** `/funcionario/{id}`
  - Busca um funcionário pelo ID.
- **GET** `/funcionario`
  - Lista todos os funcionários.
- **PUT** `/funcionario/{id}`
  - Atualiza os dados de um funcionário existente.
- **DELETE** `/funcionario/{id}`
  - Deleta um funcionário existente.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.