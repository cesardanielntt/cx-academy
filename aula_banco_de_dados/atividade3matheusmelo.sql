-- ATIVIDADE3MATHEUSMELO


create database cxacademia
drop database cxcommerce

create database cxcommerce

use cxcommerce

create table produto (
	id int primary key auto_increment,
    codigoProduto varchar (50),
    nome varchar (100)
);

create table preco (
	id int primary key auto_increment,
    valor decimal(10,2),
    produto_id int (11),
    cliente_id int (11)
);

create table carrinho (
	id int primary key auto_increment,
    datahora datetime,
    total decimal(10,2),
    cliente_id int (11)
);

create table item (
	id int primary key auto_increment,
    quantidade int(11),
    total decimal(10,2),
    produto_id int(11),
    preco_id int(11),
    carrinho_id int(11)
);

create table cliente (
	id int primary key auto_increment,
    cpf varchar (11),
    nome varchar (100)
);

create table endereco (
	id int primary key auto_increment,
    cep varchar (8),
    logradouro varchar (100),
    numero varchar (20),
    bairro varchar (100),
    cidade varchar (100),
    uf varchar (2),
    cliente_id int (11),
    foreign key (cliente_id) references cliente(id)
);

SELECT * FROM cliente

INSERT INTO cliente (cpf, nome) VALUES ('18505318526', 'Adriana'), ('24710483619', 'André'), ('24012381428', 'Cristina');

SELECT * FROM endereco

INSERT INTO endereco (cliente_id, cep, logradouro, numero, bairro, cidade, uf) VALUES ('1', '69620970', 'Praça São Cristovão', '32', 'Centro', 'Amaturá', 'AM');
INSERT INTO endereco (cliente_id, cep, logradouro, numero, bairro, cidade, uf) VALUES ('1', '69931970', 'Rua Ocimar Tessinari', '07', 'Conquista', 'Capixaba', 'AC');

INSERT INTO endereco (cliente_id, cep, logradouro, numero, bairro, cidade, uf) VALUES ('2', '28880970', 'Rodovia Amaral Peixoto', '538 Loja 2', 'Barra de São João', 'Barra de São João', 'RJ');
INSERT INTO endereco (cliente_id, cep, logradouro, numero, bairro, cidade, uf) VALUES ('2', '25875970', 'Rua João Cabral', '1063', 'Afonso Arinos', 'Afonso Arinos', 'RJ');

INSERT INTO endereco (cliente_id, cep, logradouro, numero, bairro, cidade, uf) VALUES ('3', '49550970', 'Rua Domingos Venâncio Neto', '62', 'Centro', 'Carira', 'SE') ;
INSERT INTO endereco (cliente_id, cep, logradouro, numero, bairro, cidade, uf) VALUES ('3', '87145970', 'Avenida Ipiranga', '13', 'Centro', 'Água Boa', 'PR');

SELECT * FROM produto

INSERT INTO produto (codigoProduto, nome) VALUES ('55000827', 'Smartphone Samsung Galaxy');
INSERT INTO produto (codigoProduto, nome) VALUES ('12358736', 'Escova Secadora Britânia');
INSERT INTO produto (codigoProduto, nome) VALUES ('14226767', 'Lavadora de Roupas Consul');
INSERT INTO produto (codigoProduto, nome) VALUES ('4639', 'Forno de Micro-ondas Electrolux');
INSERT INTO produto (codigoProduto, nome) VALUES ('1509799932','Secador de Cabelos Philco');
INSERT INTO produto (codigoProduto, nome) VALUES ('1515207018', 'Geladeira Side By Side Eco Inverter Philco');

SELECT * FROM preco

INSERT INTO preco (cliente_id, produto_id, valor) values ('2', '1', '744.50');
INSERT INTO preco (cliente_id, produto_id, valor) values ('1', '1', '630.04');
INSERT INTO preco (cliente_id, produto_id, valor) values ('3', '1', '699.99');
INSERT INTO preco (cliente_id, produto_id, valor) values ('2', '2', '200.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('1', '2', '250.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('3', '2', '225.50');
INSERT INTO preco (cliente_id, produto_id, valor) values ('2', '3', '500.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('1', '3', '630.45');
INSERT INTO preco (cliente_id, produto_id, valor) values ('3', '3', '590.35');
INSERT INTO preco (cliente_id, produto_id, valor) values ('2', '4', '400.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('1', '4', '325.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('3', '4', '300.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('2', '5', '225.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('1', '5', '280.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('3', '5', '260.50');
INSERT INTO preco (cliente_id, produto_id, valor) values ('2', '6', '480.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('1', '6', '530.00');
INSERT INTO preco (cliente_id, produto_id, valor) values ('3', '6', '585.50');

select * from carrinho

INSERT INTO carrinho (dataHora, total, cliente_id) values ('2021-08-15 16:00:00',0, (SELECT id FROM cliente WHERE nome = 'Adriana'));
INSERT INTO carrinho (DataHora, total, cliente_id) values ('2021-03-14 20:00:00',0, (SELECT id FROM cliente WHERE nome = 'André'));
INSERT INTO carrinho (dataHora, total, cliente_id) values ('2021-02-08 08:00:00',0, (SELECT id FROM cliente WHERE nome = 'Cristina'));

select * from item;

INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) values ('2', 0, '1', '1', '1'), ('2', 0, '6', '6', '2');
insert into item (quantidade, total, produto_id, preco_id, carrinho_id) values ('3', 0, '2', '2', '2'), ('1', 0, '4', '4', '3');
insert into item (quantidade, total, produto_id, preco_id, carrinho_id) values ('1', 0, '5', '5', '3'), ('3', 0, '2', '2', '1');

UPDATE item i
JOIN carrinho c ON c.id = i.carrinho_id
JOIN cliente cl ON c.cliente_id = cl.id
JOIN preco p ON i.preco_id = p.id
SET i.total = i.quantidade * p.valor;

SET SQL_SAFE_UPDATES = 0;

select * from item;

UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
FROM item GROUP BY carrinho_id) AS i
SET c.total = i.total
WHERE c.id = i.carrinho_id;

SELECT p.nome as produto, i.quantidade as quantidade, pr.valor as ValorUnitario, i.total as valortotal
FROM produto p, item i, preco pr, carrinho c, cliente cl
WHERE c.cliente_id = 1
AND c.cliente_id = c.id
AND p.id = pr.produto_id 
AND cl.id = pr.cliente_id
AND i.produto_id = p.id 
AND i.preco_id = pr.id 
AND i.carrinho_id = c.id;

select i.quantidade, p.nome as produto 
from item i
inner join produto p 
on p.id = i.produto_id 
where quantidade > 0 order by quantidade
desc limit 1;

select sum(total), cliente_id from carrinho group by cliente_id
order by sum(cliente_id) desc limit 1;

SELECT i.quantidade, i.total, p.nome 
From item i 
INNER JOIN produto p 
on p.id = i.produto_id 
WHERE quantidade > 0 order by total











