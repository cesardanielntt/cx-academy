-- Criar tabelas Médico, Paciente e Consulta
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
Horário TIME,
Médico_id integer,
foreign key (Médico_id) references Médico(id)
);

-- Relatório com a lista de médicos E INSERSÃO
INSERT INTO Médico (NomeMédico) values ('Ricardo'), ('Camila'), ('Diego'), ('Leticia');
select * from Médico;

-- Popular as tabelas com alguns pacientes e médicos
INSERT INTO Paciente (NomePaciente, médico_id) values ('Brenda', 1), ('Alexandre', 2), ('André', 3), ('Barbara', 4);
INSERT INTO Paciente (NomePaciente, médico_id) values ('Joao', 1), ('Alex', 2), ('And', 3), ('Barbie', 4);

-- Relatório com a lista de pacientes
select * from Paciente;

-- Inserindo consultas
INSERT INTO Consulta (TipoConsulta, médico_id, Horário) values ('Cardiologista', 4, '14:30:00'), ('Nutricionista', 3, '15:00:00'),('Clínico geral', 2, '09:00:00'),('Oftalmologista', 1, '10:40:00');
select * from Consulta;

-- Relatório com a lista de pacientes conforme o médico informado
SELECT m.NomeMédico, p.NomePaciente, c.TipoConsulta, c.Horário
FROM Médico m
INNER JOIN Paciente p 
ON m.id = p.Médico_id
INNER JOIN Consulta c
ON m.id = c.Médico_id;

-- Relatório com a quantidade de pacientes que cada médico possui
SELECT m.NomeMédico, COUNT(*) as Qnt FROM Paciente p LEFT JOIN Médico m ON p.id = m.id GROUP BY Médico_id;









