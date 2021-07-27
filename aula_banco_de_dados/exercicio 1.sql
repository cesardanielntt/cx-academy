create table estado(
id integer primary key auto_increment,
uf varchar(2),
nome varchar(100)
);

create table cidade (
id integer primary key auto_increment,
nome varchar(100),
estado_id integer,
foreign key (estado_id) references estado(id)
);

insert into estado(uf,nome)
value('SP','São Paulo'),('RJ','Rio de Janeiro'),('PR','Parana'),('GO','Goias');

insert into cidade(nome,estado_id)
values('Araraquara',1),('Curitiba',3),('Niteroi',2),('Santos',1),('Goiania',4),('Pinhais',3);
select * from cidade;
select * from estado;


-- cidade e Uf
select c.nome, e.uf from cidade c 
join estado e on c.estado_id = e.id;

-- cidades de SP
select c.nome, e.uf from cidade c 
join estado e on c.estado_id = e.id
where e.id like '1';
