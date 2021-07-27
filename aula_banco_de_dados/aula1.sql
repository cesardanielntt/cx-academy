-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --

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


----------------------------------------------


create database if not exists cxacademy;
use cxacademy;

create table if not exists paciente (
	id int not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(11),
    primary key(id)
);

create table if not exists medico (
	id int not null auto_increment,
    nome varchar(100) not null,
    crm varchar(50),
    primary key(id)
);

create table if not exists consulta (
	id int not null auto_increment,
    datahora datetime,
    fk_medico_id int,
	fk_paciente_id int,
    primary key(id),
    foreign key(fk_medico_id) references medico(id),
    foreign key(fk_paciente_id) references paciente(id)
);

insert into paciente (nome, cpf) values ("Marcio", "1111"),
("Marcia", "1112"),
("Leandro", "1113"),
("Mateus", "1114");

insert into medico (nome, crm) values ("Dr. Parker", "2111"),
("Dr. Lucio", "2112"),
("Dra. Debora", "2113"),
("Dra. Ravenna", "2114");

insert into consulta (datahora, fk_medico_id, fk_paciente_id) values (SYSDATE(), 1, 4),
(SYSDATE(), 4, 2),
(SYSDATE(), 2, 4),
(SYSDATE(), 3, 4),
(SYSDATE(), 1, 3),
(SYSDATE(), 2, 1),
(SYSDATE(), 1, 1),
(SYSDATE(), 2, 2),
(SYSDATE(), 3, 3);

select * from paciente;

select * from medico;

select p.nome as paciente, m.nome as medico from paciente p
	join consulta c on c.fk_paciente_id = p.id
    join medico m on m.id = fk_medico_id
where m.id = 1; -- Using Dr. Parker as example

select p.nome as paciente, m.nome as medico from paciente p
	join consulta c on c.fk_paciente_id = p.id
    join medico m on m.id = fk_medico_id
where p.id = 2; -- Using Marcia as example

select m.nome as medico, count(p.id) as numero_consultas from medico m
	join consulta c on m.id = fk_medico_id
	join paciente p on p.id = fk_paciente_id
group by(m.id);



