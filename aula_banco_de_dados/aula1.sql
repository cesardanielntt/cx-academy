-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --

create database if not exists cxacademy;
use cxacademy;

create table estado (
	id integer primary key auto_increment,
    uf varchar(2),
    nome varchar(100)
);

create table cidade (
	id integer primary key auto_increment,
    nome varchar(100),
    estado_id integer,
    foreign key (estado_id) references estado(id)
);

insert into estado(uf, nome) values
	('PI', 'piauí'),
    ('SP', 'são paulo'),
    ('RJ', 'Rio de Janeiro'),
    ('MG', 'Minas Gerais'),
    ('SC', 'Santa Catarina'),
    ('AM', 'Amazonas');


insert into cidade(nome, estado_id) values
	('picos', 1),
    ('são sebastião', 3),
    ('Maceió', 3),
    ('Sorocaba', 6),
    ('Cuiabá', 5),
    ('Niterói', 3);
    
select * from estado;

select e.uf, e.nome, c.nome from estado e
join cidade c on e.id = c.estado_id;






