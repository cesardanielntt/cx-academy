CREATE TABLE Médico (
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
TipoConsulta varchar (100),
Horário varchar (100),
Médico_id integer,
foreign key (Médico_id) references Médico(id)
);


INSERT INTO Médico (NomeMédico) values ('Ricardo'), ('Camila'), ('Diego'), ('Leticia');

select * from Médico;

INSERT INTO Paciente (NomePaciente, médico_id) values ('Brenda', 1), ('Alexandre', 2), ('André', 3), ('Barbara', 4);

select * from Paciente;

INSERT INTO Consulta (TipoConsulta, médico_id, Horário) values ('Cardiologista', 4, 14.30), ('Nutricionista', 3, 10.15),('Clínico geral', 2, 09.0),('Oftalmologista', 1, 10.40);

select * from Consulta;


SELECT m.NomeMédico, p.NomePaciente, c.TipoConsulta, c.Horário
FROM Médico m
INNER JOIN Paciente p 
ON m.id = p.Médico_id
INNER JOIN Consulta c
ON m.id = c.Médico_id;

SELECT m.NomeMédico, COUNT(*) as Qnt FROM Paciente p LEFT JOIN Médico m ON p.id = m.id GROUP BY Médico_id;