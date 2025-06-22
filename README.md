# 🦸‍♂️ Super-Heróis API + Frontend Angular

Este projeto é um sistema CRUD completo de Super-Heróis, com backend desenvolvido em **Spring Boot** (Java) e frontend feito com Angular.

---

## 📌 Descrição do Projeto

### Backend (Java Spring Boot)

API RESTful com as seguintes operações:

✅ Listagem de todos os heróis (GET)  
✅ Consulta de herói por ID (GET)  
✅ Cadastro de novo herói (POST)  
✅ Atualização de herói (PUT)  
✅ Exclusão de herói (DELETE)  

> Incluindo regras de negócio como validação de nome único para heróis e mensagens de resposta personalizadas usando `ResponseEntity`.

---

### Frontend (Angular 14+ Standalone Components)

Interface Web funcional para:

✅ Listagem de heróis  
✅ Cadastro de novo herói  
✅ Atualização de herói  
✅ Exclusão de herói  

> O front-end consome os endpoints da API utilizando **HttpClient** e **services Angular**.
> Apesar dos meus Conhecimentos basicos em Angular, tentei da melhor forma fazer o desafio

---

## 🛠️ Tecnologias Utilizadas

### Backend
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Banco de Dados:MySQL
- Swagger/OpenAPI (Documentação das rotas)

### Frontend
- Angular 14+ com Standalone Components
- TypeScript
- Angular Material (opcional)
- HttpClient para consumo da API

---

## 🚀 Como Executar o Projeto

### Backend

1. Clone o repositório
2. Abra o projeto em sua IDE (IntelliJ ou VS Code)
3. Configure o banco de dados(arquivo dele no repositorio)
4. Rode o projeto:

