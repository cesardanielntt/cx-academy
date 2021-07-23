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

INSERT INTO medico (nome, crm) VALUES('Antonio','000000658');
INSERT INTO medico (nome, crm) VALUES('Victor','000000411');
INSERT INTO medico (nome, crm) VALUES('Catharina','000000487');

INSERT INTO paciente (nome, cpf) VALUES('Jonas','15425485645');
INSERT INTO paciente (nome, cpf) VALUES('Rodrigo','47455452168');
INSERT INTO paciente (nome, cpf) VALUES('Beto','22254548451');

INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (1,3, SYSDATE());
INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (1,1, SYSDATE());
INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (3,3, SYSDATE());
INSERT INTO consulta (paciente_id, medico_id, datahora) VALUES (2,1, SYSDATE());

-- SELECTS --

SELECT * FROM medico;
SELECT * FROM paciente;
SELECT * from consulta;

SELECT paciente.nome as Pacientes -- Médico Antonio --
FROM medico, paciente, consulta
WHERE medico.id = consulta.medico_id AND paciente.id = consulta.paciente_id 
AND medico.nome = 'Antonio';

SELECT medico.nome as Médicos-- Paciente Jonas --
FROM medico, paciente, consulta
WHERE medico.id = consulta.medico_id AND paciente.id = consulta.paciente_id 
AND paciente.nome = 'Jonas';

SELECT COUNT(nome) as QtdDePacientes
FROM (SELECT paciente.nome -- Quantidade de pacientes do médico Antonio --
FROM medico, paciente, consulta
WHERE medico.id = consulta.medico_id AND paciente.id = consulta.paciente_id 
AND medico.nome = 'Antonio') as retorno;