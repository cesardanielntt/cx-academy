use cxacademy;
-- create table pessoa (
-- 	id int not null auto_increment,
--     nome varchar(100),
--     cpf varchar(11),
--     primary key(id)
-- );
-- create table telefone (
-- 	id int not null auto_increment,
--     numero varchar(20),
--     pessoa_id int,
--     primary key(id),
--     foreign key(pessoa_id) references pessoa(id)
-- );

INSERT INTO pessoa (nome, cpf) VALUES ('Maria', '1111');
INSERT INTO telefone (numero, pessoa_id) VALUES ('1111', 1);
INSERT INTO pessoa (nome, cpf) VALUES ('João', '2222');
INSERT INTO telefone (numero, pessoa_id) VALUES ('2222', 2);
INSERT INTO pessoa (nome, cpf) VALUES ('Pedro', '3333');
INSERT INTO telefone (numero, pessoa_id) VALUES ('3311', 3);
INSERT INTO telefone (numero, pessoa_id) VALUES ('3322', 3);
INSERT INTO telefone (numero, pessoa_id) VALUES ('3333', 3);
INSERT INTO pessoa (nome, cpf) VALUES ('Mary', '4444');
INSERT INTO telefone (numero, pessoa_id) VALUES ('4444', 4);

SELECT * FROM pessoa p;
SELECT p.nome, p.cpf, t.numero FROM pessoa p
JOIN telefone t ON p.id = t.pessoa_id;
SELECT * FROM telefone p;
SELECT t.numero FROM telefone t;
SELECT * FROM pessoa p JOIN telefone t ON t.pessoa_id = p.id;
SELECT p.nome AS Nome, p.cpf AS CPF, t.numero AS Telefone
FROM pessoa p JOIN telefone t ON t.pessoa_id = p.id;
SELECT p.nome AS Nome, p.cpf AS CPF, t.numero AS Telefone
FROM pessoa p JOIN telefone t ON t.pessoa_id = p.id
WHERE p.cpf = '3333';

-- UPDATE pessoa SET nome = 'Maria Silva' WHERE cpf = '1111';
-- UPDATE pessoa SET nome = 'João Pedro' WHERE cpf = '2222';
-- UPDATE pessoa SET nome = 'Pedro Souza' WHERE cpf = '3333';
-- UPDATE pessoa SET nome = 'Mary Lee' WHERE cpf = '4444';
-- UPDATE telefone SET numero = '11-1111' WHERE id = 1;
-- UPDATE telefone SET numero = '9999'; -- sem WHERE