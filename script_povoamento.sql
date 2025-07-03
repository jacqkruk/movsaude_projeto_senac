-- Este script contém dados fictícios para fins educacionais.
-- Nenhum CPF, telefone ou email representa uma pessoa real.

USE db_movsaudemental;

INSERT INTO paciente (nome, cpf, email, telefone, data_nascimento) VALUES 
('Alan dos Reis', '000.000.000-00', 'alanreis@example.com', '(00)90000-0000', '1960-03-10'),
('Gabriel Matos', '123.456.789-00', 'matosgabriel@example.com','(11)98888-8888', '1999-11-10'),
('Luciano Cardoso', '111.111.111-11', 'luciano@example.com', '(31)95555-5555', '1974-06-15'),
('Maethe dos Reis', '999.999.999-99', 'maethereis@example.com', '(55)93333-3333', '1996-05-25'),
('Ana Letícia dos Santos', '222.333.444-55', 'anasantos@example.com', '(99)97777-7777', '1977-07-27');

INSERT INTO funcionario (nome, cpf, email, telefone, data_nascimento, setor) VALUES
('Jenifer Araújo', '000.000.000-00', 'jenifer.araujo@example.com', '(00)90000-0000', '1999-08-19', 'psicologia'),
('Stephany Carvalho', '123.456.789-00', 'stephany.carvalho@example.com', '(11)98888-8888', '1988-05-07', 'psicologia'),
('Ana Vonsbeker', '111.111.111-11', 'ana.vonsbecker@example.com', '(99)97777-7777', '1996-11-14', 'psicologia'),
('Nilce de Lima', '999.999.999-99', 'nilce.lima@example.com', '(21)96666-6666', '1980-08-31', 'psicologia'),
('Leonardo Pereira', '321.654.987-00', 'leonardo.pereira@example.com', '(31)95555-5555', '1983-07-21', 'psicologia'),
('Cristine Aguilera', '222.333.444-55', 'cris.aguilera@example.com', '(41)94444-4444', '1989-01-22', 'financeiro'),
('Mirian Almeida', '888.777.666-11', 'mirian.almeida@example.com', '(55)93333-3333', '1980-03-17', 'financeiro');

INSERT INTO usuario (nome, login, senha, perfil) VALUES 
('Jenifer Araújo', 'jenifer', MD5('2386'), 'admin'),
('Stephany Carvalho', 'stephany', MD5('4846'), 'psi'),
('Cristine Aguilera', 'cris', MD5('1830'), 'fin'),
('Ana Vonsbeker', 'ana', MD5('1830'), 'psi');
