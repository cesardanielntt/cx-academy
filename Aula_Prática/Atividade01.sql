CREATE TABLE Estado (
id integer primary key auto_increment,
Nome varchar (100),
Uf varchar (100)
);

CREATE TABLE Cidade (
id integer primary key auto_increment,
Cidade2 varchar (20),
Estado_id integer,
foreign key (Estado_id) references Estado(id)
);


INSERT INTO Estado (Nome, Uf) values ('Paraná', 'PR'), ('São Paulo', 'SP'),('Rio de Janeiro', 'RJ');

select * from Estado;


INSERT INTO Cidade (Cidade2, Estado_id) values ('Curitiba', 1), ('Osásco', 2),('São Gonçalo', 3);

select * from Cidade;

SELECT e.Nome, c.Cidade2 
FROM Estado e
JOIN Cidade c 
ON e.id = c.estado_id;










