-- Pedro Henrique Alves de Souza --

CREATE DATABASE cxacademy;

-- CREATES --

CREATE TABLE estado(
	id int PRIMARY KEY auto_increment,
    uf VARCHAR(2),
    nome VARCHAR(100)
);

CREATE TABLE cidade(
	id int PRIMARY KEY auto_increment,
    nome VARCHAR(100),
    estado_id int,
    FOREIGN KEY (estado_id) REFERENCES estado(id)
);

-- INSERTS --

INSERT INTO estado (uf, nome) VALUES('SC','Santa Catarina');
INSERT INTO estado (uf, nome) VALUES('MG','Minas Gerais');
INSERT INTO estado (uf, nome) VALUES('PR','Paraná');
INSERT INTO estado (uf, nome) VALUES('GO','Goiás');

INSERT INTO cidade (nome, estado_id) VALUES('Blumenau','1');
INSERT INTO cidade (nome, estado_id) VALUES('Belo Horizonte','2');
INSERT INTO cidade (nome, estado_id) VALUES('Curitiba','3');
INSERT INTO cidade (nome, estado_id) VALUES('Goiânia','4');

-- SELECTS

SELECT * FROM estado;
SELECT * FROM cidade WHERE estado_id = 4;