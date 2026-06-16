# 🚀 QueroSala - Backend

Sistema desenvolvido para gerenciamento de salas corporativas e reservas, com integração de dados climáticos em tempo real para auxiliar na tomada de decisão e planejamento de utilização dos ambientes.

---

# 📖 Sobre o Projeto

O QueroSala é uma API REST desenvolvida com Java e Spring Boot que permite o gerenciamento completo de salas corporativas.

Além das operações de CRUD, o sistema realiza integração com uma API externa de previsão do tempo, fornecendo informações climáticas atualizadas diretamente para a aplicação.

O projeto foi criado com foco em aplicar boas práticas utilizadas no mercado, incluindo arquitetura em camadas, DTOs, tratamento global de exceções, validação de dados e integração com serviços externos.

---

# 🛠️ Tecnologias Utilizadas

### Backend

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Hibernate
* Bean Validation
* Lombok

### Banco de Dados

* PostgreSQL

### Build

* Maven

### Integrações

* Open-Meteo API

---

# 📂 Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```text
src/main/java

├── controller
├── service
├── repository
├── dto
├── entity
├── exception
└── config
```

## Responsabilidades

### Controller

Responsável por receber e responder requisições HTTP.

### Service

Contém as regras de negócio da aplicação.

### Repository

Responsável pela comunicação com o banco de dados.

### DTO

Objetos utilizados para entrada e saída de dados.

### Entity

Representação das tabelas do banco.

### Exception

Tratamento centralizado de erros da aplicação.

---

# 📋 Funcionalidades

## Gestão de Salas

* Cadastrar salas
* Buscar todas as salas
* Buscar sala por ID
* Buscar salas por andar
* Atualizar salas
* Excluir salas

## Gestão de Reservas

* Criar reservas
* Consultar reservas
* Atualizar reservas
* Cancelar reservas

## Clima

* Consultar temperatura atual
* Consultar velocidade do vento
* Consultar previsão para 7 dias
* Integração com API externa

---

# 📋 Regras de Negócio

## Salas

* Toda sala deve possuir nome.
* Toda sala deve possuir capacidade válida.
* Toda sala deve possuir um andar informado.
* Não é permitido cadastrar dados inválidos.

## Reservas

* Uma reserva deve estar vinculada a uma sala existente.
* Não é possível reservar uma sala inexistente.
* Os dados da reserva são validados antes da persistência.
* Reservas podem ser alteradas ou canceladas.

## Clima

* O sistema consulta dados meteorológicos em tempo real.
* A previsão é exibida para os próximos 7 dias.
* O sistema trata falhas de comunicação com a API externa.
* Os dados recebidos são convertidos para DTOs antes do envio ao frontend.

---

# 🔄 Endpoints

## Salas

| Método | Endpoint       | Descrição              |
| ------ | -------------- | ---------------------- |
| GET    | /salas         | Listar salas           |
| GET    | /salas/{id}    | Buscar sala por ID     |
| GET    | /salas?andar=1 | Buscar salas por andar |
| POST   | /salas         | Cadastrar sala         |
| PUT    | /salas/{id}    | Atualizar sala         |
| DELETE | /salas/{id}    | Excluir sala           |

---

# 📝 Exemplo de Cadastro

## Request

```json
{
  "nome": "Sala Reunião Alpha",
  "capacidade": 12,
  "andar": 3
}
```

## Response

```json
{
  "mensagem": "Sala cadastrada com sucesso"
}
```

---

# ✅ Validações

O sistema utiliza Bean Validation para garantir a integridade dos dados.

Exemplos:

* Nome obrigatório
* Capacidade obrigatória
* Andar obrigatório
* Campos inválidos retornam erro de validação

---

# ⚠️ Tratamento Global de Exceções

A aplicação utiliza:

```java
@RestControllerAdvice
```

para centralizar o tratamento de erros.

## Exceções tratadas

* Erros de validação
* Regras de negócio
* Recursos não encontrados
* Erros inesperados

## Exemplo de resposta

```json
{
  "mensagem": "Sala não encontrada",
  "status": "BAD_REQUEST",
  "dataHora": "2026-06-16T10:00:00"
}
```

---

# 🗄️ Banco de Dados

## Configuração

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/querosala

spring.datasource.username=postgres

spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
```

---

# ▶️ Como Executar

## Clonar o projeto

```bash
git clone https://github.com/HiuriMR/querosala.git
```

## Entrar na pasta

```bash
cd querosala
```

## Executar aplicação

```bash
./mvnw spring-boot:run
```

Ou execute diretamente pela IntelliJ IDEA.

---

# ⭐ Diferenciais do Projeto

* Arquitetura em camadas.
* Utilização de DTOs.
* API REST seguindo boas práticas HTTP.
* Tratamento global de exceções.
* Bean Validation.
* Integração com API externa.
* Persistência com PostgreSQL.
* Separação entre regras de negócio e camada web.
* Código organizado para escalabilidade e manutenção.

---

# 🎯 Objetivos de Aprendizado

Este projeto foi desenvolvido para aprofundar conhecimentos em:

* Java Moderno
* Spring Boot
* APIs REST
* JPA e Hibernate
* PostgreSQL
* Integrações externas
* Boas práticas de arquitetura
* Tratamento de exceções
* Validação de dados

---

# 👨‍💻 Autor

**Hiuri Marques Rocha**

Desenvolvedor Java

* Java
* Spring Boot
* APIs REST
* PostgreSQL
* Git & GitHub

