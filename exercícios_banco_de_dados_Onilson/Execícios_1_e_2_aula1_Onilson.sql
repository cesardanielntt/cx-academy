-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --
 ------- Nome: Onilson Cardoso -------

CREATE DATABASE cxacademy;

USE cxacademy;

-- ----------------------------------------------------- --

--- Exercício 01 ---


create table Estado (
	id integer primary key auto_increment,
    uf varchar (2),
    nome varchar (100)
);

create table Cidade (
	id integer primary key auto_increment,
    nome varchar (100),
    estado_id integer,
	foreign key (estado_id) references estado(id)
);

Insert Into Estado (uf, nome) value ('GO', 'GOIAS');
Insert Into Estado (uf, nome) value ('SP', 'SAO PAULO');
Insert Into Estado (uf, nome) value ('PR', 'PARANA');
Insert Into Estado (uf, nome) value ('MG', 'MINAS GERAIS');

Select * from Estado; -- relatório com a lista de estados

Insert Into Cidade (nome, estado_id) value ('GOIANIA', '1');
Insert Into Cidade (nome, estado_id) value ('OSASCO', '2');
Insert Into Cidade (nome, estado_id) value ('CURITIBA', '3');
Insert Into Cidade (nome, estado_id) value ('PARACATU', '4');

Select * from Cidade;

SELECT c.nome, e.uf FROM Cidade c -- relatório que lista as cidades conforme o estado informado
JOIN Estado e ON c.estado_id = e.id;

------------------------------------------------------------

--- Exercício 02 ---


Create table Médico (
	id int primary key auto_increment,
    nomeMédico varchar (100),
    crm varchar (50)
);

Create table Consulta (
	id int primary key auto_increment,
	datahora DATETIME,
    nomeMédico_id int,
    nomePaciente_id int,
    foreign key (nomeMédico_id) references Médico(id),
    foreign key (nomePaciente_id) references Paciente(id)
);

Create table Paciente (
	id int primary key auto_increment,
    nomePaciente varchar (100),
    cpf varchar (11),
    nomeMédico_id int,
    foreign key (nomeMédico_id) references Médico(id)
);

Insert Into Médico (nomeMédico, crm) value ('Wagner', '11111');
Insert Into Médico (nomeMédico, crm) value ('Joao', '2222');
Insert Into Médico (nomeMédico, crm) value ('Lucia', '3333');
Insert Into Médico (nomeMédico, crm) value ('Wanessa', '4444');

Insert Into Paciente (nomePaciente, cpf) value ('Carlos', '1010');
Insert Into Paciente (nomePaciente, cpf) value ('Maria', '2020');
Insert Into Paciente (nomePaciente, cpf) value ('Julia', '3030');
Insert Into Paciente (nomePaciente, cpf) value ('Antonio', '4040');

Insert Into Consulta (nomeMédico_id, nomePaciente_id, datahora) value ('1', '1', '2021/05/10 10:00:00');
Insert Into Consulta (nomeMédico_id, nomePaciente_id, datahora) value ('2', '2', '2021/06/08 11:00:00');
Insert Into Consulta (nomeMédico_id, nomePaciente_id, datahora) value ('3', '3', '2021/04/01 13:00:00');
Insert Into Consulta (nomeMédico_id, nomePaciente_id, datahora) value ('4', '4', '2021/06/22 14:00:00');


Select * from Consulta;

Select * from Paciente;

Select * from Médico;


select p.nomePaciente, c.nomeMédico_id from Paciente p join Consulta c
on p.id = c.id;

select c.nomeMédico_id, m.nomePaciente as Paciente
From Paciente m Join Consulta c on m.id = c.id;

SELECT m.nomeMédico_id, COUNT(*) as Qnt FROM Paciente p LEFT JOIN Consulta m 
ON p.id = m.id GROUP BY nomeMédico_id;











      
