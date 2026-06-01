# 🏋️ API Academia Spring

API REST desenvolvida com **Spring Boot** para gerenciamento de academias, permitindo o controle de alunos, exercícios, treinos e avaliações físicas de forma organizada e escalável.

O projeto foi construído utilizando boas práticas de desenvolvimento back-end, arquitetura em camadas e persistência de dados com JPA/Hibernate.

---

## 🚀 Funcionalidades

### 👤 Gestão de Alunos

* Cadastro de alunos
* Consulta de alunos
* Atualização de dados
* Remoção de registros

### 💪 Gestão de Exercícios

* Cadastro de exercícios
* Associação com grupos musculares
* Consulta e gerenciamento de exercícios

### 📋 Gestão de Treinos

* Criação de treinos personalizados
* Associação de exercícios aos treinos
* Consulta e manutenção dos treinos

### 📏 Avaliações Físicas

* Registro de avaliações físicas
* Histórico de acompanhamento dos alunos

### 📄 Paginação

* Listagem paginada dos recursos da API
* Controle de quantidade de registros por página
* Melhor desempenho em consultas com grandes volumes de dados

### 🔄 Operações CRUD

Todas as entidades possuem operações completas de:

* Create
* Read
* Update
* Delete

---

## 🛠 Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

---

## 🏗 Arquitetura do Projeto

```text
src/main/java
├── controller
├── service
├── dto
├── database
│   ├── model
│   └── repository
```

### Responsabilidades das Camadas

| Camada     | Responsabilidade                     |
| ---------- | ------------------------------------ |
| Controller | Receber e responder requisições HTTP |
| Service    | Implementar regras de negócio        |
| DTO        | Transferência de dados               |
| Repository | Comunicação com o banco de dados     |
| Model      | Representação das entidades          |

---

## ⚙️ Configuração do Banco de Dados

Configure o arquivo `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/gym
    username: seu_usuario
    password: sua_senha

  jpa:
    hibernate:
      ddl-auto: update
```

---

## ▶️ Como Executar o Projeto

### Clonar o Repositório

```bash
git clone https://github.com/Dragonedev/api-academia-spring.git
```

### Entrar na Pasta do Projeto

```bash
cd api-academia-spring
```

### Executar a Aplicação

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

---

## 📚 Exemplos de Endpoints

### Listar Exercícios

```http
GET /v1/exercicios
```

### Listar Exercícios com Paginação

```http
GET /v1/exercicios?page=0&size=10
```

### Buscar Exercício por ID

```http
GET /v1/exercicios/{id}
```

### Cadastrar Exercício

```http
POST /v1/exercicios
```

Exemplo de Body:

```json
{
  "nome": "Supino Reto",
  "grupoMuscular": "Peito"
}
```

### Atualizar Exercício

```http
PUT /v1/exercicios/{id}
```

### Remover Exercício

```http
DELETE /v1/exercicios/{id}
```

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de praticar e consolidar conhecimentos em:

* Desenvolvimento de APIs REST com Spring Boot;
* Persistência de dados utilizando JPA e Hibernate;
* Arquitetura em camadas;
* Paginação de resultados;
* Boas práticas de desenvolvimento back-end.

---

## 👨‍💻 Autor

**Eduardo Dragone Pinheiro Corrêa**

Desenvolvedor Java em formação, com foco em desenvolvimento back-end utilizando Spring Boot.
