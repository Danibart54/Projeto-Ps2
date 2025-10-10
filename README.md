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

💻 Arquitetura da Solução
em desenvolvimento...
