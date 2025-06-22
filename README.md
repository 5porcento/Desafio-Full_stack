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
3. Configure o banco de dados(arquivo dele no repositorio, ja com alguns Herois para teste)
4. Rode o projeto:


## Sobre o Uso de DTOs, Mappers, Lombok e a Integração com o Front-end

Durante o desenvolvimento desta aplicação, foquei em criar um Back-end 100% funcional, utilizando Spring Boot, com todas as operações básicas de um CRUD: listagem, cadastro, edição e exclusão de super-heróis.
Uso de DTOs e Mappers ✅

Optei por utilizar DTOs (Data Transfer Objects) para garantir uma melhor separação entre as entidades JPA e os dados que trafegam nas requisições da API.
Com isso:

    Evitei a exposição direta das entidades para o cliente.

    Tive maior controle sobre os campos enviados e recebidos.

    Pude criar respostas mais amigáveis e personalizadas.

O Mapper, por sua vez (classe NewMapper), foi o responsável por transformar as entidades nos DTOs de resposta e vice-versa, de forma simples e centralizada.


###Uso do Lombok 

Para agilizar o desenvolvimento e manter o código limpo e enxuto, fiz uso extensivo do Lombok, uma biblioteca que gosto bastante e que me ajuda a:

    Gerar automaticamente os getters, setters, construtores, métodos equals/hashCode, etc.

    Evitar repetição de código.

    Manter as classes mais objetivas e fáceis de ler.

Anotações como @Data, @Builder, @NoArgsConstructor e @AllArgsConstructor foram bastante utilizadas ao longo das entidades.

### Sobre o Front-end... 

Infelizmente, por conta de imprevistos pessoais e acadêmicos durante o período de entrega, não consegui concluir 100% a implementação do Front-end em Angular como havia planejado.

Minha ideia era criar uma interface com listagem, cadastro, edição e exclusão de heróis, consumindo diretamente os endpoints da API.
Iniciei a configuração do projeto Angular, ajustei o app.config.ts, preparei as rotas e comecei a estruturar os serviços HTTP com o HttpClientModule, mas o tempo foi curto e precisei priorizar a finalização do Back-end.
