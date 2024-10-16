# Curso Spring Security da DIO
#### Professor: [Gleyson Sampaio](https://github.com/glysns)
Projeto desenvolvido durante a execução do **Curso Adicionando Segurança em uma API REST com Spring Security** da [DIO](https://dio.me).

## Estrutura de pacotes do projeto

| Pacote          | Descrição                                                                    |
| --------------- | ---------------------------------------------------------------------------- |
| config          | Classes de configuração.                                                     |
| controller      | Classes que gerenciam as requisições da API                                  | 
| dto             | Classes para transferencia de dados                                          |
| init            | Contém a classe StartApplication que popula a base de dados na inicialização |
| model           | Entidades do domínio da aplicação                                            |
| repository      | Inteface de acesso a base de dados                                           |
| security        | Classes relacionadas a segurança da aplicação                                |
| service         | Classes com regras de negócio                                                |

## Tecnologias utilizadas

- Spring Boot 3
- Spring Security
- Java 21
- ModelMapper
- Lombok
- H2 Database
- Springdoc (Swagger)
- Json Web Token

## Migração para Spring Boot 3
No curso foi utilizado o Spring Boot 2.5.5 com Java 8, portanto foram necessárias algumas modificações para realizar a migração. 

Alguns pontos importantes:

- Não é mais necessário extender a classe WebSecurityConfigurerAdapter na classe de configuração de segurança
- O método configure foi renomeado para securityFilterChain e anotado com @Bean
- A biblioteca jjwt precisou ser atualizada para a versão 0.12.6
- A entidade User agora implementa a interface UserDetails
- Foi criada a classe AutenticacaoService que implementa a interface UserDetailsService
- Dependências do javax foram modificadas para jakarta

## Documentação Swagger
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
