-- Ex 1
create database cxacademy;
use cxacademy;
-- Ex 2
create table Estado(
	id int primary key auto_increment,
    uf varchar(2),
    nome varchar(100)
);

create table Cidade(
	id int primary key auto_increment,
    nome varchar(100),
    Estado_id int,
   foreign key (Estado_id) references Estado (id)
);

-- Ex 3
INSERT INTO Estado (uf,nome) values ('SP','Sao Paulo');
INSERT INTO Estado (uf,nome) values ('RJ','Rio de Janeiro');
INSERT INTO Estado (uf,nome) values ('MG','Minas Gerais');
INSERT INTO Estado (uf,nome) values ('BH','Belo Horizonte');
INSERT INTO Estado (uf,nome) values ('PR','Parana');

insert into Cidade (nome, Estado_id) values ('Sao Paulo',1);
insert into Cidade (nome, Estado_id) values ('ABC',1);
insert into Cidade (nome, Estado_id) values ('Santos',1);
insert into Cidade (nome, Estado_id) values ('Araraquara',1);

insert into Cidade (nome, Estado_id) values ('Niteroi',2);
insert into Cidade (nome, Estado_id) values ('Duque de Caxias',2);
insert into Cidade (nome, Estado_id) values ('Sao Goncalo',2);
insert into Cidade (nome, Estado_id) values ('Mage',2);


insert into Cidade (nome, Estado_id) values ('Ouro Preto',3);
insert into Cidade (nome, Estado_id) values ('Mariana',3);
insert into Cidade (nome, Estado_id) values ('Uberlandia',3);
insert into Cidade (nome, Estado_id) values ('Juiz de Fora',3);

insert into Cidade (nome, Estado_id) values ('Santa Luzia',4);
insert into Cidade (nome, Estado_id) values ('Rio Acima',4);
insert into Cidade (nome, Estado_id) values ('Raposos',4);
insert into Cidade (nome, Estado_id) values ('Caete',4);

insert into Cidade (nome, Estado_id) values ('Curitiba',5);
insert into Cidade (nome, Estado_id) values ('Londrina',5);
insert into Cidade (nome, Estado_id) values ('Maringa',5);
insert into Cidade (nome, Estado_id) values ('Apucarana',5);

-- Ex 4
select * from Estado;

-- Ex 5
select * from Cidade where Estado_id = 2;



