-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --

/*Exercicio 1 ao 5*/

create database cxacademy;

use cxacademy;
 
create table estado (
id integer primary key auto_increment,
uf varchar (2),
nome varchar (100)
);

create table cidade (
id integer primary key auto_increment,
nome varchar (100),
estado_id integer,
foreign key (estado_id) references estado(id)
);

select * from estado;
select * from cidade;

insert into estado (uf, nome) values ('SC', 'Santa Catarina');
insert into estado (uf, nome) values ('SP', 'São Paulo');
insert into estado (uf, nome) values ('RJ', 'Rio de Janeiro');
insert into estado (uf, nome) values ('AC', 'Acre');

insert into cidade (nome, estado_id) values ('Joinville', '1');
insert into cidade (nome, estado_id) values ('Suzano', '2');
insert into cidade (nome, estado_id) values ('Niterói', '3');
insert into cidade (nome, estado_id) values ('Rio Branco', '4');

/*relatório com a lista de estados*/
select nome from estado; 
/* relatório que liste as cidades conforme o estado informado*/
select nome, estado_id from cidade; 

-----------------------------------------------------------------
create table paciente (
id integer primary key auto_increment,
nome varchar (100),
cpf varchar (11)
);

create table medico (
id integer primary key auto_increment,
nome varchar (100),
cm varchar (100)
);

create table consulta (
id integer primary key auto_increment,
datahora datetime,
medico_id integer,
paciente_id integer,
foreign key (medico_id) references medico(id),
foreign key (paciente_id) references paciente(id)
);

/*relatório com a lista de pacientes*/
select nome from paciente;

insert into paciente (nome, cpf) values ('Paulo', '92269410092');
insert into paciente (nome, cpf) values ('Roberto', '21214158072');
insert into paciente (nome, cpf) values ('João', '74023944092');
insert into paciente (nome, cpf) values ('Khaue', '24083795042');

/*relatório com a lista de medicos*/
select nome from medico;
select * from medico;
insert into medico (nome, cm) values ('Rafael', '70368056090');
insert into medico (nome, cm) values ('Fabiano', '13421443092');
insert into medico (nome, cm) values ('Carlos', '18562888036');
insert into medico (nome, cm) values ('Daniel', '61189622009');

insert into consulta (datahora, medico_id, paciente_id) values ('2022-03-15 13:30', 2, 1);
insert into consulta (datahora, medico_id, paciente_id) values ('2022-05-16 13:30', 3, 4);
insert into consulta (datahora, medico_id, paciente_id) values ('2022-06-17 13:30', 4, 3);

select * from consulta; 












