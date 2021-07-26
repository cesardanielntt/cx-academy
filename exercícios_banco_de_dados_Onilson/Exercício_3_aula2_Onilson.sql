CREATE DATABASE cxcommerce;

use cxcommerce;

  ------ Nome Onilson Cardoso -----                                 
 
 
CREATE TABLE produto (
	id integer primary key auto_increment,
	sku varchar (50),
	nome varchar (100)
);

CREATE TABLE item (
	id integer primary key auto_increment,
    quantidade integer,
    total DECIMAL (6,2),
    produto_id integer,
    preco_id integer,
    carrinho_id integer,
    foreign key (produto_id) references produto(id),
    foreign key (preco_id) references preco(id),
    foreign key (carrinho_id) references carrinho(id)
);

CREATE TABLE carrinho (
	id integer primary key auto_increment,
    datahora DATETIME,
    total DECIMAL (6,2),
    cliente_id integer,
    foreign key (cliente_id) references cliente(id)
);

CREATE TABLE preco (
    id integer primary key auto_increment,
    valor DECIMAL (6,2),
    produto_id integer,
    cliente_id integer,
    foreign key (produto_id) references produto(id),
    foreign key (cliente_id) references cliente(id)
);

CREATE TABLE cliente (
	id integer primary key auto_increment,
    cpf varchar (11),
    nome varchar (100)
);

CREATE TABLE endereco (
	id integer primary key auto_increment,
    cep varchar (8),
    logradouro varchar (100),
    numero varchar (20),
    bairro varchar (100),
    cidade varchar (100),
    uf varchar (2),
    cliente_id integer (11),
    foreign key (cliente_id) references cliente(id)
);


INSERT INTO cliente (nome, cpf) value ('Carlos', '12345678912'), ('Rebeca', '45866988544'), ('Artur', '58442558963');

SELECT * from cliente;
SELECT * from produto;
SELECT * from endereco;
SELECT * from item;
SELECT * from preco;
SELECT * from carrinho;


INSERT INTO produto (nome, sku) value ('camisa', 'ca'), ('calça', 'cl'), ('bermuda', 'be');
INSERT INTO produto (nome, sku) value ('chapel', 'ch'), ('tenis', 'te'), ('chinelo', 'chi');

INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) value ('04114110', 'Rua Doutor Luíz', '123', 'Jardim da Glória', 'sao paulo', 'sp', '1');
INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) value ('23946165', 'Rua Jaqueira', '321', 'Frade ', 'Angra dos Reis', 'rj', '1');
INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) value ('74830280', 'Rua 1103', '42', 'Setor Pedro Ludovico', 'Goiânia', 'go', '2');
INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) value ('85415971', 'Avenida Principal', '70', 'Centro', 'Cafelândia', 'pr', '3');

INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) value ('5', 100.00, '1', '1', '1');
INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) value ('3', 90.00, '2', '2', '1');
INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) value ('10', 300.00, '2', '2', '2');
INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) value ('2', 80.00, '3', '3', '2');
INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) value ('15', 600.00, '3', '3', '3');
INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id) value ('6', 300.00, '4', '4', '3');

INSERT INTO preco (valor, produto_id, cliente_id) value (20.00, '1', '1');
INSERT INTO preco (valor, produto_id, cliente_id) value (30.00, '2', '3');
INSERT INTO preco (valor, produto_id, cliente_id) value (40.00, '3', '2');
INSERT INTO preco (valor, produto_id, cliente_id) value (50.00, '4', '1');
INSERT INTO preco (valor, produto_id, cliente_id) value (60.00, '5', '2');
INSERT INTO preco (valor, produto_id, cliente_id) value (10.00, '6', '3');

INSERT INTO carrinho (datahora, total, cliente_id) value ('2021/05/10 10:00:00', 40.20, '1');
INSERT INTO carrinho (datahora, total, cliente_id) value ('2021/06/20 11:30:00', 40.00, '2');
INSERT INTO carrinho (datahora, total, cliente_id) value ('2021/04/07 12:30:00', 50.50, '3');

UPDATE item i
JOIN carrinho c ON c.id = i.carrinho_id
JOIN cliente cl ON c.cliente_id = cl.id
JOIN preco p ON i.preco_id = p.id
SET i.total = i.quantidade * p.valor;



UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
FROM item GROUP BY carrinho_id) AS i
SET c.total = i.total
WHERE c.id = i.carrinho_id;
SET SQL_SAFE_UPDATES = 0;





----- questao 11 -----

SELECT p.nome as produto, i.quantidade as quantidade, v.valor as valor, i.total as total
FROM produto p, item i, preco v, carrinho c, cliente cl
WHERE c.cliente_id = 3
AND c.cliente_id = c.id
AND p.id = v.produto_id
AND cl.id = v.cliente_id
AND i.produto_id = p.id
AND i.preco_id = v.id
AND i.carrinho_id = c.id;


----- questao 12----

select sum(quantidade), produto_id from item group by produto_id
order by sum(quantidade) desc limit 1;

----- questao 13----

select sum(total), cliente_id from carrinho group by cliente_id
order by sum(cliente_id) desc limit 1;


---- questao14 -----

SELECT i.quantidade, i.total, p.nome
FROM item i
INNER JOIN produto p on p.id = i.produto_id
WHERE quantidade > 0 order by total desc;











    




