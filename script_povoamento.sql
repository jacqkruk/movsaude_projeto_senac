USE db_movsaudemental;

INSERT INTO paciente (nome, cpf, email, telefone, data_nascimento) VALUES 
('Alan dos Reis', '512.374.039-28', 'alanreis@slb.com.br', '(44)99263-2386', '1960-03-10'),
('Gabriel Matos', '592.561.959-50', 'matosgabriel@ytbrasil.com','(44)92590-4846', '1999-11-10'),
('Luciano Cardoso', '043.588.309-78', 'luciano@ytbrasil.com.br', '(41)98211-1830', '1974-06-15'),
('Maethe dos Reis', '043.588.309-78', 'maethereis@dedicasa.com', '(41)98211-1830', '1996-05-25'),
('Ana Letícia dos Santos', '296.136.109-52', 'anasantos@email.com', '(41)99236-9568', '1977-07-27');

INSERT INTO funcionario (nome, cpf, email, telefone, data_nascimento, setor) VALUES
('Jenifer Araújo', '114.983.279-74', 'jessicaaraujo@psiatitude.com', '(43)99391-6051', '1999-08-19', 'psicologia'),
('Stephany Carvalho', '755.916.049-27', 'esthecarvalho@psiatitude.com', '(43)99363-9482', '1988-05-07', 'psicologia'),
('Ana Vonsbeker', '157.640.529-04', 'anabonassa@psiatitude.com', '(41)99839-6652', '1996-11-14', 'psicologia'),
('Nilce de Lima', '629.636.599-38', 'nilcemoretto@psiatitude.com', '(45)98710-7898', '1980-08-31', 'psicologia'),
('Leonardo Pereira', '169.792.589-82', 'leonmartins@psiatitude.com', '(41)98271-9849', '1983-07-21', 'psicologia'),
('Cristine Aguilera', '533.419.039-25', 'crisaguilera@clinicatitude.com', '(41)98763-2413', '1989-01-22', 'financeiro'),
('Mirian Almeida', '183.211.769-33', 'mirianalmeida@clinicatitude.com', '(46)99574-9539', '1980-03-17', 'financeiro');

INSERT INTO usuario (nome, login, senha, perfil) VALUES 
('Jenifer Araújo', 'jenifer', MD5('2386'), 'admin'),
('Stephany Carvalho', 'stephany', MD5('4846'), 'psi'),
('Cristine Aguilera', 'cris', MD5('1830'), 'fin'),
('Ana Vonsbeker', 'ana', MD5('1830'), 'psi');
