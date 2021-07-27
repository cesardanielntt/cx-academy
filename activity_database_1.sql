create database if not exists cxacademy;
use cxacademy;


create table if not exists estado (
	id int not null auto_increment,
    uf char(2) not null,
    nome varchar(100) not null,
    primary key(id)
);

create table if not exists cidade (
	id int not null auto_increment,
    nome varchar(100) not null,
    fk_estado_id int,
    primary key(id)
);

insert into estado (uf, nome) values ("PR", "Parana"),
("SP", "Sao Paulo"),
("RJ", "Rio de Janeiro"),
("BA", "Bahia"),
("MG", "Minas Gerais");

insert into cidade (nome, fk_estado_id) values ("Curitiba", 1),
("Joinville", 1),
("Campinas", 2),
("Sao Paulo", 2),
("Rio de Janeiro", 3),
("Niteroi", 3),
("Salvador", 4),
("Itabuna", 4),
("Uberlandia", 5),
("Belo Horizonte", 5);

select * from estado;

select * from cidade
where fk_estado_id = 1; -- Using Curitiba as example

-- select * from cidade
-- where fk_estado_id = 2;

-- select * from cidade
-- where fk_estado_id = 3;

-- select * from cidade
-- where fk_estado_id = 4;

-- select * from cidade
-- where fk_estado_id = 5;