# API Academia Spring

API REST desenvolvida com Spring Boot para gerenciamento de academia, permitindo o controle de alunos, exercícios, treinos e avaliações físicas.

---

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## Funcionalidades

- Cadastro de alunos
- Cadastro de exercícios
- Cadastro de treinos
- Avaliações físicas
- Operações CRUD completas
- Integração com banco de dados MySQL

---

## Estrutura do Projeto

```text
src/main/java
├── controller
├── service
├── dto
├── database
│   ├── model
│   └── repository
```

---

## Configuração do Banco de Dados

Configure o arquivo `application.yml`:

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/gym
    username: seu_usuario
    password: sua_senha
```

---

## Como Executar o Projeto

### Clonar o repositório

```bash
git clone https://github.com/Dragonedev/api-academia-spring.git
```

### Entrar na pasta do projeto

```bash
cd api-academia-spring
```

### Executar a aplicação

```bash
./mvnw spring-boot:run
```

---

## Endpoints

### Exercícios

```http
GET /v1/exercicios
```

Lista todos os exercícios cadastrados.

```http
POST /v1/exercicios
```

Cadastra um novo exercício.

Exemplo de body:

```json
{
  "nome": "Supino Reto",
  "grupoMuscular": "Peito"
}
```

---

## Autor

Desenvolvido por Eduardo Dragone.
