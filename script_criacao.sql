CREATE DATABASE db_movsaudemental;
USE db_movsaudemental;

CREATE TABLE paciente (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20),
    email VARCHAR(45),
    telefone VARCHAR(15),
    data_nascimento DATE,
    cadastro_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE usuario (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(20),
    senha VARCHAR(45),
    perfil VARCHAR(15),
    PRIMARY KEY (id)
);

CREATE TABLE funcionario (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20),
    email VARCHAR(45),
    telefone VARCHAR(15),
    data_nascimento DATE,
    setor varchar(20),
    PRIMARY KEY (id)
);
