# 🎓 Portal de Estágios – Projeto Final de Linguagem de Programação II

Este projeto tem como objetivo desenvolver um Portal de Estágios que conecta estudantes, empresas e administradores em uma plataforma web moderna e integrada.
A aplicação é composta por um backend RESTful em Java (Spring Boot) e uma SPA (Single Page Application) desenvolvida com framework JavaScript (React).

## 📘 Sumário
 - 🎯 Objetivo do Projeto
 - 👥 Perfis de Usuário
 - ⚙️ Requisitos Funcionais
 - 💻 Arquitetura da Solução
 - 🧩 Tecnologias Utilizadas
 - 🚀 Instruções de Execução
 - 📊 Funcionalidades Extras
 - 📈 Dashboard e Estatísticas
 - 🌐 Hospedagem (opcional)
 - 🧑‍💻 Equipe de Desenvolvimento


## 🎯 Objetivo do Projeto

O Portal de Estágios visa simplificar o processo de conexão entre empresas que ofertam vagas de estágio e estudantes que buscam oportunidades.
Além de facilitar o cadastro e a busca de vagas, o sistema fornece painéis personalizados, controle de acesso e estatísticas administrativas.

## 👥 Perfis de Usuário
Perfil	Descrição	Permissões
Administrador	Gerencia áreas de interesse, usuários e estatísticas do portal.	CRUD completo de todas as entidades + Dashboard.
Empresa	Cadastra vagas, visualiza inscritos e encerra vagas.	CRUD de vagas e acesso ao painel da empresa.
Estudante	Cadastra-se, busca vagas e realiza inscrições.	CRUD de perfil e inscrições em vagas.

## ⚙️ Requisitos Funcionais
1. Cadastro e autenticação
 - Login individual para estudantes, empresas e administradores.
 - Senhas criptografadas.

2. Áreas de interesse (Admin)
  - CRUD completo, acessível apenas por administradores.

3. Cadastro de empresas
  - Campos: nome, CNPJ, e-mail, telefone, endereço, área(s) de atuação.
  - Após o cadastro, podem criar vagas.

4. Cadastro de estudantes
  - Campos: nome, CPF, curso, e-mail, telefone e áreas de interesse.

5. Ofertas de vagas
 - Campos: título, descrição, área, localização, modalidade (remoto/presencial/híbrido), carga horária e requisitos.
 - Criadas apenas por empresas logadas.
 - Listagem pública filtrada por áreas de interesse dos estudantes.

6. Inscrição em vagas
 - Estudantes podem se inscrever em qualquer vaga aberta.
 - Uma vaga pode ter múltiplos candidatos.

7. Painel personalizado
 - Estudante: vagas relacionadas ao perfil.
 - Empresa: candidatos inscritos em suas vagas.
 - Administrador: visão geral com estatísticas.

8. Encerramento de vagas
 - Empresa pode encerrar vagas, bloqueando novas inscrições.

9. Dashboard administrativo

Estatísticas:
 - Número de empresas cadastradas
 - Número de estudantes
 - Vagas abertas e encerradas
 - Gráfico: vagas por área

## 💻 Arquitetura da Solução - BackEnd
O projeto é organizado da seguinte forma:

```
src
└── main
    ├── java
    │   └── br
    │       └── com
    │           └── portalestagios
    │               ├── PortalEstagiosApplication.java
    │               ├── controller
    │               │   ├── AreaOfInterestController.java
    │               │   └── UserController.java
    │               ├── entity
    │               │   ├── AreaOfInterest.java
    │               │   ├── Company.java
    │               │   ├── JobOffer.java
    │               │   └── Usuario.java
    │               ├── repository
    │               │   ├── AreaOfInterestRepository.java
    │               │   ├── CompanyRepository.java
    │               │   ├── JobOfferRepository.java
    │               │   └── UsuarioRepository.java
    │               ├── dao
    │               │   ├── AreaOfInterestDAO.java
    │               │   ├── CompanyDAO.java
    │               │   ├── JobOfferDAO.java
    │               │   └── UserDAO.java
    │               └── service
    │                   ├── AreaOfInterestService.java
    │                   ├── JobOfferService.java
    │                   └── UserService.java
    └── resources
        └── application.properties
```

### Instalação

1. Clone o repositório:
   ```
   git clone <(https://github.com/Danibart54/Projeto-Ps2)>
   ```

2. Navegue até o diretório do projeto:
   ```
   cd portal-estagios
   ```

3. Compile o projeto usando Maven:
   ```
   mvn clean install
   ```

### Execução

Para executar a aplicação, utilize o seguinte comando:

```
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## FrontEnd

Visão geral
...

Estrutura do Front...
Paginas/Rotas...

Chamadas API(exemplos)...

### Instalação 
1. Entre na pasta dedicada ao FrontEnd
```
cd frontend
```
2. Baixe 
```
npm install
```
3. Rode
```
npm run dev
```
## 🧠 Funcionalidades Inovadoras

Além das funcionalidades obrigatórias, o **Portal de Estágios** inclui propostas de inovação que agregam valor à experiência do usuário e ampliam as possibilidades da plataforma:

1. **Integração com Google Maps**
   - Exibe a localização exata da vaga dentro da página de detalhes.  
   - Permite que o estudante visualize rotas, distância e tempo estimado até o local da empresa.  
   - Implementado via **API do Google Maps**, integrada ao endereço cadastrado pela empresa.

2. **Geração Automática de Currículo em PDF**
   - Cada estudante pode gerar seu currículo automaticamente com base nas informações preenchidas no perfil.  
   - O documento é exportado em formato **PDF** com layout profissional, contendo dados pessoais, curso, áreas de interesse e histórico de candidaturas.

3. **Simulador de Entrevista Interativo**
   - Ferramenta voltada ao preparo dos estudantes para entrevistas reais.  
   - Oferece perguntas aleatórias e feedback de desempenho (textual ou gamificado).  
   - Pode ser expandido futuramente com **IA** para análise de respostas e sugestões de aprimoramento.

