CREATE DATABASE cxacademy;

CREATE TABLE estado (
id integer primary key auto_increment,
nome varchar(100),
uf varchar(2)
);

CREATE TABLE cidade (
id integer primary key auto_increment,
nome varchar(100),
estado_id integer,
foreign key (estado_id) references estado(id)
);

INSERT INTO estado (Nome, UF) values ('Paraná', 'PR'), ('São Paulo', 'SP'),('Rio de Janeiro', 'RJ');
INSERT INTO estado (Nome, UF) values ('Ceará', 'CE'), ('Pernambuco', 'PE');
select * from estado;
INSERT INTO cidade (Nome, Estado_id) values ('Curitiba', 1), ('Osásco', 2),('São Gonçalo', 3);
INSERT INTO cidade (Nome, Estado_id) values ('Fortaleza', 4), ('Refice', 5);

SELECT cidade.nome, estado.nome
FROM estado JOIN cidade
ON estado.id = cidade.estado_id;


