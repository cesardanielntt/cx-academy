-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 2 --
-- ----------------------------------------------------- --

CREATE DATABASE IF NOT EXISTS cxacademy;

USE cxacademy;

CREATE TABLE IF NOT EXISTS produto (
	id integer primary key auto_increment,
    sku varchar(50),
    nome varchar(100)
);

CREATE TABLE IF NOT EXISTS cliente (
	id integer primary key auto_increment,
    cpf varchar(11),
    nome varchar(100)
);

CREATE TABLE IF NOT EXISTS carrinho (
	id integer primary key auto_increment,
    datahora datetime,
    total decimal(12,2),
    cliente_id integer,
    foreign key (cliente_id) references cliente(id)
);

CREATE TABLE IF NOT EXISTS endereco (
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

CREATE TABLE IF NOT EXISTS preco (
	id integer primary key auto_increment,
    valor decimal(6,2),
    produto_id integer,
    foreign key (produto_id) references produto(id),
    cliente_id integer,
    foreign key (cliente_id) references cliente(id)
);

CREATE TABLE IF NOT EXISTS item (
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

INSERT INTO cliente (nome, cpf)
VALUES
	('Paulo', '3333325689'),
    ('Jessyca', '55464568689'),
    ('Priscilla', '4444445689');
    
INSERT INTO produto (nome, sku)
VALUES
	('celular', '4651'),
	('notebook', '4685'),
	('geladeira', '8975'),
    ('forno', '6534'),
    ('micro-ondas', '8546'),
    ('teclado', '2222');

INSERT INTO preco (valor, produto_id, cliente_id)
VALUES

	(1000, (SELECT id FROM produto WHERE nome = 'celular'), (SELECT id FROM cliente WHERE nome = 'Paulo')),
	(4750, (SELECT id FROM produto WHERE nome = 'notebook'), (SELECT id FROM cliente WHERE nome = 'Paulo')),
	(2500, (SELECT id FROM produto WHERE nome = 'geladeira'), (SELECT id FROM cliente WHERE nome = 'Paulo')),
    (1200, (SELECT id FROM produto WHERE nome = 'forno'), (SELECT id FROM cliente WHERE nome = 'Paulo')),
    (400, (SELECT id FROM produto WHERE nome = 'micro-ondas'), (SELECT id FROM cliente WHERE nome = 'Paulo')),
    (250, (SELECT id FROM produto WHERE nome = 'teclado'), (SELECT id FROM cliente WHERE nome = 'Paulo')),
    
    (899.99, (SELECT id FROM produto WHERE nome = 'celular'), (SELECT id FROM cliente WHERE nome = 'Jessyca')),
	(4499.99, (SELECT id FROM produto WHERE nome = 'notebook'), (SELECT id FROM cliente WHERE nome = 'Jessyca')),
	(2150.50, (SELECT id FROM produto WHERE nome = 'geladeira'), (SELECT id FROM cliente WHERE nome = 'Jessyca')),
    (999, (SELECT id FROM produto WHERE nome = 'forno'), (SELECT id FROM cliente WHERE nome = 'Jessyca')),
    (459.99, (SELECT id FROM produto WHERE nome = 'micro-ondas'), (SELECT id FROM cliente WHERE nome = 'Jessyca')),
    (229.99, (SELECT id FROM produto WHERE nome = 'teclado'), (SELECT id FROM cliente WHERE nome = 'Jessyca')),
    
    (1200, (SELECT id FROM produto WHERE nome = 'celular'), (SELECT id FROM cliente WHERE nome = 'Priscilla')),
	(4900, (SELECT id FROM produto WHERE nome = 'notebook'), (SELECT id FROM cliente WHERE nome = 'Priscilla')),
	(2700, (SELECT id FROM produto WHERE nome = 'geladeira'), (SELECT id FROM cliente WHERE nome = 'Priscilla')),
    (1450, (SELECT id FROM produto WHERE nome = 'forno'), (SELECT id FROM cliente WHERE nome = 'Priscilla')),
    (550, (SELECT id FROM produto WHERE nome = 'micro-ondas'), (SELECT id FROM cliente WHERE nome = 'Priscilla')),
    (280, (SELECT id FROM produto WHERE nome = 'teclado'), (SELECT id FROM cliente WHERE nome = 'Priscilla'));

INSERT INTO carrinho (datahora, total, cliente_id)
VALUES

	('2021-08-20 14:00:00', 0, (SELECT id FROM cliente WHERE nome = 'Paulo')),
    ('2021-08-20 14:00:00', 0, (SELECT id FROM cliente WHERE nome = 'Jessyca')),
    ('2021-08-20 14:00:00', 0, (SELECT id FROM cliente WHERE nome = 'Priscilla'));
    
INSERT INTO item (quantidade, total, produto_id, preco_id, carrinho_id)
VALUES

	(
		5,
		0,
        (SELECT id FROM produto WHERE nome = 'celular'),
		(SELECT p.id FROM preco p JOIN cliente c ON p.cliente_id = c.id JOIN produto pr ON p.produto_id = pr.id WHERE c.nome = 'Paulo' and pr.nome = 'celular'),
		(SELECT c.id FROM carrinho cn JOIN cliente c ON cn.cliente_id = c.id WHERE nome = 'Paulo')
    ),
    
	(
		2,
		0,
		(SELECT id FROM produto WHERE nome = 'notebook'),
		(SELECT p.id FROM preco p JOIN cliente c ON p.cliente_id = c.id JOIN produto pr ON p.produto_id = pr.id WHERE c.nome = 'Paulo' and pr.nome = 'notebook'),
		(SELECT c.id FROM carrinho cn JOIN cliente c ON cn.cliente_id = c.id WHERE nome = 'Paulo')
    ),
    
    (
		8,
		0,
		(SELECT id FROM produto WHERE nome = 'micro-ondas'),
		(SELECT p.id FROM preco p JOIN cliente c ON p.cliente_id = c.id JOIN produto pr ON p.produto_id = pr.id WHERE c.nome = 'Jessyca' and pr.nome = 'micro-ondas'),
		(SELECT c.id FROM carrinho cn JOIN cliente c ON cn.cliente_id = c.id WHERE nome = 'Jessyca')
    ),
    
    (
		10,
		0,
		(SELECT id FROM produto WHERE nome = 'teclado'),
		(SELECT p.id FROM preco p JOIN cliente c ON p.cliente_id = c.id JOIN produto pr ON p.produto_id = pr.id WHERE c.nome = 'Jessyca' and pr.nome = 'teclado'),
		(SELECT c.id FROM carrinho cn JOIN cliente c ON cn.cliente_id = c.id WHERE nome = 'Jessyca')
    ),

	(
		1,
		0,
		(SELECT id FROM produto WHERE nome = 'geladeira'),
		(SELECT p.id FROM preco p JOIN cliente c ON p.cliente_id = c.id JOIN produto pr ON p.produto_id = pr.id WHERE c.nome = 'Priscilla' and pr.nome = 'geladeira'),
		(SELECT c.id FROM carrinho cn JOIN cliente c ON cn.cliente_id = c.id WHERE nome = 'Priscilla')
    ),
    
    (
		2,
		0,
		(SELECT id FROM produto WHERE nome = 'teclado'),
		(SELECT p.id FROM preco p JOIN cliente c ON p.cliente_id = c.id JOIN produto pr ON p.produto_id = pr.id WHERE c.nome = 'Priscilla' and pr.nome = 'teclado'),
		(SELECT c.id FROM carrinho cn JOIN cliente c ON cn.cliente_id = c.id WHERE nome = 'Priscilla')
    );
    
INSERT INTO endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id)
VALUES
	('81754642', 'rua atuba', '451', 'grand-ville', 'sao paulo', 'SP', (SELECT id FROM cliente WHERE nome = 'Paulo')),
    ('12546778', 'avenida locatel', '566', 'hauer', 'curitiba', 'PR', (SELECT id FROM cliente WHERE nome = 'Jessyca')),
    ('45648774', 'rua irmandade petra', '8884', 'bacacheri', 'curitiba', 'PR', (SELECT id FROM cliente WHERE nome = 'Jessyca')),
    ('97846512', 'sitio jairzinho', '46522', 'aguas claras', 'pedra lisa', 'RJ', (SELECT id FROM cliente WHERE nome = 'Priscilla'));
    
UPDATE item i
JOIN carrinho c ON c.id = i.carrinho_id
JOIN cliente cl ON c.cliente_id = cl.id
JOIN preco p ON i.preco_id = p.id
SET i.total = i.quantidade * p.valor;

UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
FROM item GROUP BY carrinho_id) AS i
SET c.total = i.total
WHERE c.id = i.carrinho_id;

SELECT pr.nome AS Produto, i.quantidade, p.valor, c.total
FROM carrinho c 
JOIN item i ON i.carrinho_id = c.id
JOIN produto pr ON i.produto_id = pr.id
JOIN preco p ON p.produto_id = pr.id
JOIN cliente cl ON c.cliente_id = cl.id AND p.cliente_id = cl.id WHERE cl.nome = 'Paulo';

SELECT MAX(vendas) AS 'Total de vendas', Produto FROM (
	SELECT SUM(quantidade) AS vendas, nome AS Produto 
    FROM item i 
    JOIN produto p ON i.produto_id = p.id 
    GROUP BY p.nome
    ORDER BY vendas desc
) AS vendas;

SELECT MAX(compras) AS 'Total de pedidos', nome AS Cliente FROM (
	SELECT SUM(quantidade) AS compras, nome
	FROM cliente c 
	JOIN preco p ON p.cliente_id = c.id 
	JOIN item i ON i.preco_id = p.id
    GROUP BY nome
    ORDER BY compras desc
) AS compras;

SELECT SUM(quantidade) AS 'Produtos vendidos', SUM(i.total) AS 'Lucro Bruto'
	FROM cliente c 
	JOIN preco p ON p.cliente_id = c.id 
	JOIN item i ON i.preco_id = p.id