-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 2 --
-- ----------------------------------------------------- --

create database cxacademia

use cxacademia;


Create TABLE Médico (
id integer primary key auto_increment,
NomeMédico varchar (100)
);

CREATE TABLE Paciente (
id integer primary key auto_increment,
NomePaciente varchar (100),
Médico_id integer,
foreign key (Médico_id) references Médico(id)
);

CREATE TABLE Consulta (
id integer primary key auto_increment,
TipoConsulta varchar (20),
Horário varchar (20),
Médico_id integer,
foreign key (Médico_id) references Médico(id)
);

SELECT * FROM Médico;

insert into Médico (NomeMédico) values ('Adriano'), ('Cristina'), ('Bruno'), ('Angelica'), ('Tiago');

SELECT * FROM Paciente;

insert into Paciente (NomePaciente, Médico_id) values ('Bruna', 1), ('Sandro', 4), ('Cristiano', 2), ('Vinícius', 5), ('Daniela', 3);

SELECT * FROM Consulta;

insert into Consulta (TipoConsulta, Horário, Médico_id) values ('Urologista', '10:11', 3), ('Clinico Geral', '18:45', 5), ('Psicologo', '11:12', 1), ('Odontologista', '09:50', 2), ('Pediatra', '20:10', 4);

SELECT m.NomeMédico, p.NomePaciente, c.TipoConsulta, c.Horário
FROM Médico m
INNER JOIN Paciente p 
ON m.id = p.Médico_id
INNER JOIN Consulta c
ON m.id = c.Médico_id;

SELECT m.NomeMédico, COUNT(*) as Qnt FROM Paciente p LEFT JOIN Médico m ON p.id = m.id GROUP BY Médico_id;