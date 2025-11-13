-- 1) Usuários (colunas explicitadas para evitar ordem errada)
INSERT INTO usuario (id, nome, email, senha, perfil) VALUES
  (1, 'Admin Master', 'admin@portal.com', 'admin123', 'ADMIN'),
  (2, 'Tech Solutions LTDA', 'contato@techsolutions.com', 'empresa123', 'EMPRESA'),
  (3, 'CodeWave Ltda', 'hr@codewave.com', 'empresa123', 'EMPRESA'),
  (4, 'Ana Souza', 'ana.souza@email.com', 'aluno123', 'ESTUDANTE'),
  (5, 'João Lima', 'joao.lima@email.com', 'aluno123', 'ESTUDANTE'),
  (6, 'José Pedro', 'pedrotkatchuk@gmail.com', 'AlunoMack', 'ESTUDANTE');

-- 2) Áreas de interesse (note: tabela criada pelo Hibernate é `area_interesse`)
INSERT INTO area_interesse (id, nome) VALUES
  (1, 'Desenvolvimento de Software'),
  (2, 'Design UX/UI'),
  (3, 'Marketing Digital'),
  (4, 'Engenharia Elétrica'),
  (5, 'Administração');

-- 3) Empresas (vinculadas a usuário_id)
INSERT INTO empresa (id, usuario_id, nome, cnpj, email, telefone, endereco) VALUES
  (1, 2, 'Tech Solutions LTDA', '12.345.678/0001-90', 'contato@techsolutions.com', '(11) 99999-0000', 'Rua A, 123'),
  (2, 3, 'CodeWave Ltda', '98.765.432/0001-11', 'hr@codewave.com', '(11) 98888-1111', 'Av B, 456');

-- 4) Estudantes (vinculados a usuário_id)
INSERT INTO estudante (id, usuario_id, nome, cpf, curso, email, telefone) VALUES
  (1, 4, 'Ana Souza', '123.456.789-00', 'Ciência da Computação', 'ana.souza@email.com', '(11) 97777-2222'),
  (2, 5, 'João Lima', '987.654.321-00', 'Engenharia de Software', 'joao.lima@email.com', '(11) 96666-3333'),
  (3, 6, 'José Pedro', '111.222.333-44', 'Sistemas de Informação', 'pedrotkatchuk@gmail.com', '(11) 95555-4444');

-- 5) Vagas (referenciando empresa_id e area_id)
INSERT INTO vaga (id, titulo, descricao, localizacao, modalidade, carga_horaria, requisitos, encerrada, empresa_id, area_id) VALUES
  (1, 'Desenvolvedor Java Jr', 'Vaga para desenvolvedor Java', 'São Paulo', 'Presencial', '40h', 'Java, Spring Boot', FALSE, 1, 1),
  (2, 'Estágio em UX/UI', 'Auxiliar no design de interfaces', 'Remoto', 'Remoto', '20h', 'Figma, noções de UX', FALSE, 2, 2);

-- Vagas públicas adicionais
INSERT INTO vaga (id, titulo, descricao, localizacao, modalidade, carga_horaria, requisitos, encerrada, empresa_id, area_id) VALUES
  (3, 'Estágio em Marketing Digital', 'Auxílio em campanhas e redes sociais', 'Remoto', 'Remoto', '20h', 'Noções de marketing, redes sociais', FALSE, 1, 3),
  (4, 'Estágio em Engenharia Elétrica', 'Suporte em projetos elétricos', 'Campinas', 'Presencial', '30h', 'Circuitos, elétrica básica', FALSE, 2, 4),
  (5, 'Auxiliar Administrativo', 'Rotinas administrativas e apoio', 'São Paulo', 'Presencial', '40h', 'Pacote Office, organização', FALSE, 1, 5);

-- 6) Relacionamentos empresa ↔ área (tabela criada pelo Hibernate: empresa_areas_atuacao)
INSERT INTO empresa_areas_atuacao (areas_atuacao_id, empresa_id) VALUES
  (1, 1),
  (2, 2);

-- 7) Relacionamentos estudante ↔ interesses (tabela: estudante_interesses)
INSERT INTO estudante_interesses (estudante_id, interesses_id) VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (1, 2),
  (3, 5);

-- 8) Inscrições (especificando id para manter previsibilidade)
INSERT INTO inscricao (id, estudante_id, vaga_id) VALUES
  (1, 1, 1),
  (2, 2, 1),
  (3, 3, 2);
