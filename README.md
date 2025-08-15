# Cadastro de Vendedores em Angular e Spring Boot

Projeto final do módulo do **BootCamp FullStack Dev Júnior** com foco na integração de **Angular** no frontend e **Spring Boot** no backend.
O objetivo é gerenciar vendedores, permitindo **cadastrar**, **listar**, **editar** e **remover** registros.
A aplicação conta com **validações** no frontend e backend, consumo de **API REST** e uso de **formulário reativo** no Angular.


## Tecnologias Utilizadas

### Frontend

![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge\&logo=angular\&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge\&logo=typescript\&logoColor=white)
![HTML](https://img.shields.io/badge/HTML-E34F26?style=for-the-badge\&logo=html5\&logoColor=white)
![CSS](https://img.shields.io/badge/CSS-1572B6?style=for-the-badge\&logo=css3\&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge\&logo=bootstrap\&logoColor=white)

* **ng-bootstrap**: Bootstrap adaptado para Angular

### Backend

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge\&logo=java\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge\&logo=springboot\&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2%20Database-007DB8?style=for-the-badge\&logo=h2\&logoColor=white)

* **Java**: 24
* **Spring Boot**: 3.5.4
* **Spring Boot DevTools**: Ferramentas de desenvolvimento
* **Spring Web**: Criação de APIs REST
* **Spring Data JPA**: Persistência de dados
* **H2 Database**: Banco de dados em memória
* **Validation**: Validações no backend



## Autor

* [@FelipePaterni](https://www.github.com/FelipePaterni)



## Aprendizados

Esse projeto consolidou conceitos de:

* Criação de **CRUD** completo com Angular e Spring Boot
* Consumo de **API REST** no frontend
* Uso de **Spring Data JPA** para persistência
* **Validações** em ambos os lados (frontend/backend)
* Integração de **Bootstrap** com Angular via ng-bootstrap
* Estruturação de repositório **mono repo**
* Organização do fluxo de trabalho com **GitHub Projects** (Kanban)
* Boas práticas de commits e gestão de issues no GitHub


## Funcionalidades

* **Cadastrar** vendedor
* **Listar** todos os vendedores
* **Editar** dados de um vendedor
* **Excluir** vendedor
* **Validações**:

  * Nome com no mínimo 5 caracteres
  * Salário maior que zero
  * Bonificação entre 0% e 100%
* **Seeding** automático com 3 vendedores iniciais (`data.sql`)

## Endpoints Backend

* **GET** `/sellers` → Lista todos os vendedores
* **GET** `/sellers/{id}` → Busca vendedor por ID
* **POST** `/sellers` → Cadastra vendedor
* **PUT** `/sellers/{id}` → Atualiza vendedor
* **DELETE** `/sellers/{id}` → Remove vendedor

## Screenshots

![Home](https://i.imgur.com/6A0BI7E.png)
![Vendedores](https://i.imgur.com/nJLfEmq.png)



## Como Usar

### 1. Clone o repositório

```bash
git clone https://github.com/FelipePaterni/Cadastro-Vendedores.git
```

### 2. Backend

```bash
cd backend-vendedores
./mvnw spring-boot:run
```

Acesse: **[http://localhost:8080](http://localhost:8080)**

### 3. Frontend

```bash
cd frontend-vendedores
npm install
ng serve -o
```

Acesse: **[http://localhost:4200](http://localhost:4200)**
