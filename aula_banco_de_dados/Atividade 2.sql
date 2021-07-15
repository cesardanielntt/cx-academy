CREATE DATABASE hospital;

-- CREATES --

CREATE TABLE medico(
	id int PRIMARY KEY auto_increment,
    nome VARCHAR(100),
    crm VARCHAR(50)
);

CREATE TABLE paciente(
	id int PRIMARY KEY auto_increment,
    nome VARCHAR(100),
    cpf VARCHAR(11)
);

CREATE TABLE consulta(
	id int PRIMARY KEY auto_increment,
    datahora DATETIME,
    medico_id int,
    paciente_id int,
    FOREIGN KEY (medico_id) REFERENCES medico(id),
    FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

-- INSERTS -- 

INSERT INTO medico (nome, crm) VALUES('Gustavo','000000123');
INSERT INTO medico (nome, crm) VALUES('Hugo','000000456');
INSERT INTO medico (nome, crm) VALUES('Rodolfo','000000789');

INSERT INTO paciente (nome, cpf) VALUES('Pedro','12345678912');
INSERT INTO paciente (nome, cpf) VALUES('Ana','98765432198');
INSERT INTO paciente (nome, cpf) VALUES('Mariana','12345698712');

INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (1,3, SYSDATE());
INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (1,1, SYSDATE());
INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (3,3, SYSDATE());
INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (2,1, SYSDATE());

-- SELECTS --

SELECT * FROM medico;
SELECT * FROM paciente;
SELECT * from consulta;

SELECT paciente.nome as Pacientes -- Médico Gustavo --
FROM medico, paciente, consulta
WHERE medico.id = consulta.medico_id AND paciente.id = consulta.paciente_id 
AND medico.nome = 'Gustavo';

SELECT medico.nome as Médicos-- Paciente Pedro --
FROM medico, paciente, consulta
WHERE medico.id = consulta.medico_id AND paciente.id = consulta.paciente_id 
AND paciente.nome = 'Pedro';

SELECT COUNT(nome) as QtdDePacientes
FROM (SELECT paciente.nome -- Quantidade de pacientes do médico Gustavo --
FROM medico, paciente, consulta
WHERE medico.id = consulta.medico_id AND paciente.id = consulta.paciente_id 
AND medico.nome = 'Gustavo') as retorno;