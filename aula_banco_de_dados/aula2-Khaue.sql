create database cxcommerce;
use cxcommerce;
CREATE TABLE produto (
id int(11) primary key auto_increment,
sku varchar (50),
nome varchar (100)
);

INSERT INTO produto (sku, nome) VALUES ('A1233', 'Mochila'), 
('A1234', 'Sapato'),
('A1235', 'Camisa'),
('A1236', 'Calca'),
('A1237', 'Casaco'),
('A1238', 'Vestido');

CREATE TABLE cliente (
id int(11) primary key auto_increment,
cpf varchar (11),
nome varchar (100)
);

INSERT INTO cliente (cpf, nome) VALUES ('78663664036', 'Paula '),
('10154062030', 'Carlos'), ('70582998034', 'Adolfo');

select * from carrinho;
CREATE TABLE carrinho (
id int(11) primary key auto_increment,
datahora datetime,
total decimal(6,2),
cliente_id int(11),
foreign key (cliente_id) references cliente(id)
);
INSERT INTO carrinho (datahora, total, cliente_id) 
VALUES 
('2021-07-15 09:15', 0, 1),
('2021-07-15 10:30', 0, 2),
('2021-07-15 11:45', 0, 3);

select * from preco;
CREATE TABLE preco (
id int(11) primary key auto_increment,
valor decimal(6,2),
produto_id int(11),
cliente_id int(11),
foreign key (cliente_id) references cliente(id),
foreign key (produto_id) references produto(id)
);

INSERT INTO preco (produto_id, cliente_id, valor) 
values
(1, 1, 59.99),(2, 1, 149.90), (3, 1, 35.60), (4, 1, 79.99), (5, 1, 110.99), (6, 1, 49.90),

(1, 2, 55.99),(2, 2, 249.99), (3, 2, 99.90), (4, 2, 144.90), (5, 2, 236.70), (6, 2, 139.90),

(1, 3, 60.99),(2, 3, 299.00), (3, 3, 149.99), (4, 3, 359.99), (5, 3, 449.49), (6, 3, 289.90);

CREATE TABLE item (
id int(11) primary key auto_increment,
quantidade int(11),
total decimal(6,2),
produto_id int(11),
preco_id int(11),
carrinho_id int(11),
foreign key (produto_id) references produto(id),
foreign key (preco_id) references preco(id),
foreign key (carrinho_id) references carrinho(id)
);
select * from item;
INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) 
values
(2, 0, 1, 1, 1),
(2, 0, 2, 2, 1),

(2, 0, 1, 7, 2),
(2, 0, 2, 8, 2),

(2, 0, 1, 13, 3),
(2, 0, 2, 14, 3);

select * from endereco;
CREATE TABLE endereco (
id int(11) primary key auto_increment,
cep varchar(8),
logradouro varchar(100),
numero varchar(20),
bairro varchar(100),
cidade varchar(100),
uf varchar(2),
cliente_id int(11),
foreign key (cliente_id) references cliente(id)
);

INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES 
('88064100', 'Rua João Vieira Aguiar', '1500', 'Ribeirão da Ilha', 'Florianópolis', 'SC', 1),

('78556746', 'Rua dos Jenipapos', '1100', 'Jardim das Itaúbas', 'Sinop', 'MT', 1);

INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES 
('69918078', 'Rua Veterano Henrique Julião', '5023', 'Jardim Nazle', 'Rio Branco', 'AC', 2),

('37903331', 'Rua Ceres', '5468', 'Penha', 'Passos', 'MG', 2);

INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) VALUES 
('76820864', 'Avenida Calama', '8580', 'Embratel', 'Porto Velho', 'RO', 3),

('68903640', 'Rua Francisca Feitosa dos Santos', '5555', 'Universidade', 'Macapá', 'AP', 3);

/*total do valor do item*/
UPDATE item i
JOIN carrinho c ON c.id = i.carrinho_id
JOIN cliente cl ON c.cliente_id = cl.id
JOIN preco p ON i.preco_id = p.id
SET i.total = i.quantidade * p.valor;

/*total do carrinho*/
select * from carrinho;

UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
FROM item GROUP BY carrinho_id) AS i 
SET c.total = i.total 
WHERE c.id = i.carrinho_id;

/*relatório da lista de item de um pedido de um cliente, apresentar nome do produtos, quantidade, valor 
unitário, valor total.*/
SELECT p.nome as produto, i.quantidade as quantidade, pr.valor as valor, i.Total as valor
FROM produto p, item i, preco pr, carrinho c, cliente cl
WHERE c.cliente_id = 1 
AND c.cliente_id = c.id
AND p.id = pr.produto_id 
AND cl.id = pr.cliente_id
AND i.produto_id = p.id 
AND i.preco_id = pr.id 
AND i.carrinho_id = c.id;


/*Produto mais vendido*/
select i.quantidade, p.nome as produto 
from item i
join produto p 
on p.id = i.Produto_id 
where quantidade > 0 order by quantidade
desc limit 1;

/*Relatório do cliente que mais compra*/
select sum(total), cliente_id from carrinho group by cliente_id
order by sum(cliente_id) desc limit 1;

/*Relatório com o total em quantidades e valores dos itens já vendidos no sistema*/
SELECT i.quantidade, i.total, p.nome
From Item i 
join produto p 
on p.id = i.Produto_id 
where quantidade > 0 order by total;