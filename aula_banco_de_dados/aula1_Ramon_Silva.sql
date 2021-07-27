<<<<<<< HEAD
-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --
 
--  Francisco Ramon Da Silva Holanda ---

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





-- parte 2

create table paciente (
	id integer primary key auto_increment,
    nome varchar(100),
    cpf varchar(11)
);

create table medico (
	id integer primary key auto_increment,
    nome varchar(100),
    cm varchar(50)
);

create table consulta (
	id integer primary key auto_increment,
    data_hora datetime,
    medico_id int(11),
    paciente_id int(11),
    foreign key(medico_id) references medico(id),
    foreign key(paciente_id) references paciente(id)
);

insert into paciente(nome, cpf) values
	("César", "12345678"),
    ("Paulo", "1247555"),
    ("Amanda", "865716");
    
insert into medico(nome, cm) values 
	("Henrique", "Sua Saúde"),
    ("Oscar", "Boa Vida"),
    ("Jaqueline", "Good Life");
    
insert into consulta(data_hora, paciente_id, medico_id) values
	("2021-07-25 14:00", 1, 3),
    ("2021-07-28 15:00", 3, 2),
    ("2021-08-01 09:00", 2, 3),
    ("2021-08-10 12:00", 3, 2),
    ("2021-08-15 17:00", 1, 2),
    ("2021-08-30 16:00", 2, 1);

select * from paciente;
select * from medico;

-- lista pacientes de acordo com os médicos
select p.nome as "Pacientes", p.cpf, m.nome as "Médico", m.cm "Clinica Médica" from paciente p
join consulta c on p.id = c.paciente_id 
join medico m on m.id = c.medico_id;

-- lista médicos de acordo com os pacientes
select m.nome as "Médico", m.cm "Clinica Médica", p.nome as "Pacientes", p.cpf from medico m
join consulta c on m.id = c.medico_id 
join paciente p on p.id = c.paciente_id;


-- lista os médicos e o número de seus respectivos pacientes
select m.nome, m.cm as 'Clinica Médica', count(p.id) as "Número de Pacientes" from medico m
join consulta c on m.id = c.medico_id
join paciente p on p.id = c.paciente_id
group by (m.id);







=======
-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --
<<<<<<<< HEAD:aula_banco_de_dados/aula1_Ramon_Silva.sql
 
--  Francisco Ramon Da Silva Holanda ---
========
>>>>>>>> feature_ramon_silva:aula_banco_de_dados/aula1.sql

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



>>>>>>> feature_ramon_silva
