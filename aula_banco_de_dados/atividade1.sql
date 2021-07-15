-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --
create database cxacademia
use cxacademia

create table estado (
	id int primary key auto_increment,
    nome varchar (100)
);

CREATE TABLE cidade (
    id INT PRIMARY KEY AUTO_INCREMENT,
    municipio VARCHAR(100),
    estado_id INTEGER,
    FOREIGN KEY (estado_id) REFERENCES estado (id)
) 

SELECT * FROM estado;

INSERT INTO estado (nome) VALUES ('Mato Grosso');

INSERT INTO estado (nome) VALUES ('Bahia');

INSERT INTO estado (nome) VALUES ('Rio grande do Sul');

SELECT * FROM cidade

insert into cidade (municipio, estado_id) values ('Cuiabá', 1), ('Salvador', 2), ('Santa Maria', 3);


SELECT e.nome, c.municipio 
FROM estado e
JOIN cidade c 
ON e.id = c.estado_id;