# Bootcamp GFT Start #2: Desenvolvendo um sistema de gerenciamento de pessoas com API REST e Spring Boot

Neste sistema foi desenvolvido uma API básica de cadastro de pessoa, utilizando algumas tecnologias e ferramentas:

- Java
- Spring Boot
- Spring initialzr
- Lombok
- Mapstruct
- GIT/GITHUB

E também foram abordados alguns tópicos:

- Criação de modelo de dados com armazenamento em memória com o H2
- Desenvolvimento de operações CRUD básicas
- Utilização de boas práticas acerca de desenvolvimento baseado em código limpo, boas práticas e aplicação destes 
seguindo o modelo arquitetural REST 
- Desenvolvimento de testes unitários para validação de funcionalidades
- Controle de versão da aplicação através da utilização do Git e armazenado no GITHUB
- Implantação do sistema na nuvem através do Heroku

## Para executar o projeto

`mvn spring-boot:run`

## Para consumir a API, basta acessar o seguinte endpoint(após o comando acima)

`http://localhost:8080/api/v1/persons/`

## Pré-requisitos

- Java 11 ou superior
- Maven 3.6.3 ou superior
