

 CREATE TABLE estado ( 
	id int primary key auto_increment,
	nome varchar (50)
);

create table Cidade (
	id int primary key auto_increment,
    municipio varchar (20),
    estado_id integer,
    FOREIGN KEY (estado_id) REFERENCES estado (id)
    
);

select * from estado;

insert into estado (nome) values ('Parana');
insert into estado (nome) values ('Santa Catarina');
insert into estado (nome) values ('Rio Grande do Sul'); 

select * from cidade;
insert into cidade (municipio, estado_id) values ('curitiba', 1), ('florianopolis', 2), ('porto alegre', 3);


SELECT e.nome, c.municipio
FROM Estado e
JOIN Cidade c 
ON e.id = c.estado_id;







    


	





