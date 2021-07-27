create database cxcommerce;
use cxcommerce;
SET SQL_SAFE_UPDATES = 0;

create table produto (
id integer primary key auto_increment,
sku varchar(50),
nome varchar(100)
);

create table cliente (
id integer primary key auto_increment,
cpf varchar(11),
nome varchar(100)
);

create table carrinho(
id integer primary key auto_increment,
daathora datetime,
total decimal(6,2),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);

create table endereco(
id integer primary key auto_increment,
cep varchar(8),
logradouro varchar(100),
numero varchar(20),
bairro varchar(100),
cidade varchar(100),
uf varchar(2),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);

create table preco (
id integer primary key auto_increment,
valor decimal(6,2),
produto_id integer,
foreign key (produto_id) references produto(id),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);

create table item (
id integer primary key auto_increment,
quantidade integer,
total decimal(6,2),
produto_id integer,
foreign key (produto_id) references produto(id),
preco_id integer,
foreign key (preco_id) references preco(id),
carrinho_id integer,
foreign key (carrinho_id) references carrinho(id)
);

insert into cliente (cpf,nome)
values ('12345678901', 'Leandro'),
('10987654321', 'João'),('67891234567','Maria');

insert into endereco(cep, logradouro,numero,bairro,cidade,uf,cliente_id)
values ('12341','Emil Gaston','463','Cidade Jardim','Rio Braco','AC',3),
('3213','Camelias','432','Pompeia','Rio de Janeiro','RJ',3);
select * from endereco;

insert into produto (sku, nome)
values('123','lapis'),
('435','borracha'),('432','caderno'),	
('234','caneta'),('789','mochila'),
('980','apontador');

insert into preco(valor, produto_id, cliente_id)
values('30.50',4,1),
('29.99',4,2),('31.99',4,3),
('32.50',5,1),('36.99',5,2),
('22.95',5,3),('42.85',6,1),
('45.00',6,2),('43.50',6,3);

alter table carrinho
change column daathora datahora datetime;

insert into carrinho (datahora,total,cliente_id)
values ('2021-07-15 15:30','2',2);

insert into item (quantidade, produto_id, preco_id,carrinho_id)
values ('1', 4, 10, 2);

-- total item
UPDATE item i
JOIN carrinho c ON c.id = i.carrinho_id
JOIN cliente cl ON c.cliente_id = cl.id
JOIN preco p ON i.preco_id = p.id
SET i.total = i.quantidade * p.valor;

-- Total carrinho
UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
 FROM item GROUP BY carrinho_id) AS i
 SET c.total = i.total
 WHERE c.id = i.carrinho_id;

-- 11 - itens do cliente 1
select p.nome, i.quantidade, pr.valor, i.total 
from produto p join item i on p.id = i.produto_id
join preco pr on pr.id = i.preco_id
where pr.cliente_id = "1";

-- 12 produto mais vendido
select p.nome, pr.valor, i.quantidade, i.total
from produto p
inner join item i on p.id = i.produto_id
inner join preco pr on p.id = pr.produto_id
limit 1; 

-- 13 
select ct.nome, max(c.total) as valor_da_compra
from cliente ct, carrinho c
where ct.id = c.cliente_id;

-- 14
select p.id, i.quantidade , i.total  from item i, produto p
where i.produto_id = p.id; 