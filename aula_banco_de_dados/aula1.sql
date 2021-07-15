-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --

CREATE DATABASE cxacademy;
USE cxacademy;

CREATE TABLE pessoa(
	id int primary key auto_increment,
    nome varchar(100),
    cpf varchar(11)
);

CREATE TABLE telefone(
	id int primary key auto_increment,
    numero varchar(20),
    pessoa_id int,
    foreign key (pessoa_id) references pessoa(id)
);

SELECT * FROM pessoa; 

INSERT INTO pessoa (nome, cpf) values ('Maria','2556');
SELECT * FROM pessoa;

INSERT INTO pessoa (nome, cpf) values ('Joao','4569713');
SELECT * FROM pessoa;

INSERT INTO pessoa SET nome = 'Joao' ,cpf = '4565';