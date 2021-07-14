-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --

DROP DATABASE cxacademy; 

CREATE DATABASE cxacademy;

USE cxacademy;

CREATE TABLE estado (
	id integer primary key auto_increment,
    uf varchar(2),
    nome varchar(100)
    );
    
CREATE TABLE cidade (
	id integer primary key auto_increment,
    nome varchar(100),
    estado_id integer,
    foreign key (estado_id) references estado(id)
    );

INSERT INTO estado (uf, nome)
VALUES
	('PR', 'Parana'),
	('SP', 'Sao Paulo'),
	('RJ', 'Rio de Janeiro');
    
INSERT INTO cidade (nome, estado_id)
VALUES
	('Curitiba', (SELECT id FROM estado WHERE uf = "PR")),
	('Foz do Iguacu', (SELECT id FROM estado WHERE uf = "PR")),
	('Cascavel', (SELECT id FROM estado WHERE uf = "PR")),
    ('Sao Paulo', (SELECT id FROM estado WHERE uf = "SP")),
    ('Rio de Janeiro', (SELECT id FROM estado WHERE uf = "RJ"));

SELECT nome AS Cidade FROM cidade WHERE estado_id = (SELECT id FROM estado WHERE uf = "PR");

CREATE TABLE paciente (
	id integer primary key auto_increment,
    nome varchar(100),
    cpf varchar(11)
);

CREATE TABLE medico (
	id integer primary key auto_increment,
    nome varchar(100),
    crm varchar(50)
);

CREATE TABLE consulta (
	id integer primary key auto_increment,
    datahora datetime,
    medico_id integer,
    foreign key (medico_id) references medico(id),
    paciente_id integer,
    foreign key (paciente_id) references paciente(id)
);

INSERT INTO paciente (nome, cpf)
VALUES
	('Paulo', '3333325689'),
	('Felipe', '2222225689'),
	('Gustavo', '1111125689'),
    ('Jessyca', '55464568689'),
    ('Priscilla', '4444445689');
    
INSERT INTO medico (nome, crm)
VALUES
	('Freitas', '4651'),
	('Nabuco', '4685'),
	('Lorenzo', '8975'),
    ('Luna', '6534'),
    ('Igor', '8546');
    
INSERT INTO consulta (datahora, medico_id, paciente_id)
VALUES
	('2021-08-20 14:00:00', (SELECT id FROM medico WHERE nome = "Freitas"), (SELECT id FROM paciente WHERE nome = "Paulo")),
	('2021-08-20 14:00:00', (SELECT id FROM medico WHERE nome = "Nabuco"), (SELECT id FROM paciente WHERE nome = "Felipe")),
	('2021-08-20 14:00:00', (SELECT id FROM medico WHERE nome = "Nabuco"), (SELECT id FROM paciente WHERE nome = "Gustavo")),
    ('2021-08-20 14:00:00', (SELECT id FROM medico WHERE nome = "Luna"), (SELECT id FROM paciente WHERE nome = "Jessyca")),
    ('2021-08-20 14:00:00', (SELECT id FROM medico WHERE nome = "Igor"), (SELECT id FROM paciente WHERE nome = "Priscilla"));
    
SELECT nome AS Pacientes FROM paciente;

SELECT nome AS Medicos FROM medico;

SELECT p.nome AS Paciente FROM medico m INNER JOIN consulta c ON c.medico_id = m.id INNER JOIN paciente p ON c.paciente_id = p.id WHERE m.nome = 'Nabuco';

SELECT m.nome AS Medico FROM paciente p INNER JOIN consulta c ON c.paciente_id = p.id INNER JOIN medico m ON c.medico_id = m.id WHERE p.nome = 'Jessyca';

SELECT m.nome AS Medico, count(medico_id) AS "Quantidade de Pacientes" FROM medico m INNER JOIN consulta c ON m.id = c.medico_id GROUP BY m.nome;

SELECT p.nome AS Paciente, m.nome AS Medico FROM medico m INNER JOIN consulta c ON c.medico_id = m.id INNER JOIN paciente p ON c.paciente_id = p.id GROUP BY p.nome;