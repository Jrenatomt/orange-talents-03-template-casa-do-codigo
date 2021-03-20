INSERT INTO tb_categoria (nome) Values ('ação');
INSERT INTO tb_autor (nome, email, descricao, data_cadastro) Values ('renato', 'Jrenato@gmail.com', 'descriao', TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z');
INSERT INTO tb_pais (nome) Values ('Brasil');
INSERT INTO tb_pais (nome) Values ('Argentina');
INSERT INTO tb_pais (nome) Values ('Chile');
INSERT INTO tb_estado (nome, pais_id) Values ('São Paulo', 1);
INSERT INTO tb_estado (nome, pais_id) Values ('Buenos Aires', 2);