create database cxacademy;
use cxacademy;

CREATE TABLE Estado (
id integer primary key auto_increment,
Nome varchar (100),
Uf varchar (100)
);

CREATE TABLE Cidade (
id integer primary key auto_increment,
Nome varchar (20),
Estado_id integer,
foreign key (Estado_id) references Estado(id)
);


INSERT INTO Estado (Nome, UF) values ('Paraná', 'PR'), ('São Paulo', 'SP'),('Rio de Janeiro', 'RJ');

select * from Estado;


INSERT INTO Cidade (Nome, Estado_id) values ('Curitiba', 1), ('Osásco', 2),('São Gonçalo', 3);

select * from Cidade;

select cidade.nome, estado.nome
from estado join cidade
on estado.id= cidade.estado_id ; 

select * from cidade ;


