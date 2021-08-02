-- Pedro Henrique Alves de Souza --

CREATE DATABASE ecommerce;

CREATE TABLE cliente(
	id int PRIMARY KEY auto_increment,
    cpf VARCHAR(11),
    nome VARCHAR(100)
);

CREATE TABLE endereco(
	id int PRIMARY KEY auto_increment,
    cep VARCHAR(8),
    logradouro VARCHAR(100),
    numero VARCHAR(20),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf VARCHAR(2),
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE carrinho(
	id int PRIMARY KEY auto_increment,
    datahora DATETIME,
    total DECIMAL(6,2),
    cliente_id int,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE produto(
	id int PRIMARY KEY auto_increment,
	sku VARCHAR(50),
    nome VARCHAR(100)
);

CREATE TABLE preco(
	id int PRIMARY KEY auto_increment,
	valor DECIMAL(6,2),
    produto_id int,
    cliente_id int,
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE item(
	id int PRIMARY KEY auto_increment,
	quantidade int,
    total DECIMAL(6,2),
    produto_id int,
    preco_id int,
    carrinho_id int,
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (preco_id) REFERENCES preco(id),
    FOREIGN KEY (carrinho_id) REFERENCES carrinho(id)
);

-- -------------------------------------------------------------------------------------- --

INSERT INTO cliente (nome, cpf) VALUES('Pedro','12345678912');
INSERT INTO cliente (nome, cpf) VALUES('Ana','98765432198');
INSERT INTO cliente (nome, cpf) VALUES('Mariana','12345698712');

-- ------------------------------------------------------------------------------ --

INSERT INTO endereco (uf, cidade, cep, bairro, logradouro, numero, cliente_id) 
VALUES('GO','Goiânia', '12345678', 'Jardim Bonito', 'Rua dos Alfeneiros', '123', 1);

INSERT INTO endereco (uf, cidade, cep, bairro, logradouro, numero, cliente_id) 
VALUES('GO','Goiânia', '98765432', 'Jardim Cerrado', 'Rua Alameda', '456', 1);

-- ------------------------------------------------------------------------------ --

INSERT INTO produto (sku, nome)
VALUES('NIK-AF-FEM-BR-35', 'Tênis Air Force Feminino Branco Tamanho 35 - Nike');

INSERT INTO produto (sku, nome)
VALUES('NIK-AF-MAS-PR-40', 'Tênis Air Force Masculino Preto Tamanho 40 - Nike');

INSERT INTO produto (sku, nome)
VALUES('ADI-FALC-MASC-BR-41', 'Tênis Falcon Masculino Branco Tamanho 41 - Adidas');

INSERT INTO produto (sku, nome)
VALUES('ADI-FALC-FEM-PR-38', 'Tênis Falcon Feminino Preto Tamanho 38 - Adidas');

INSERT INTO produto (sku, nome)
VALUES('ADI-DUR-MASC-PR-39', 'Tênis Duramo SL Masculino Preto Tamanho 39 - Adidas');

INSERT INTO produto (sku, nome)
VALUES('ADI-DUR-FEM-BR-37', 'Tênis Duramo SL Feminino Branco Tamanho 37 - Adidas');

-- ------------------------------------------------------------------------------ --

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(1, 1, 330);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(1, 2 , 325);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(1, 3 , 320);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(2, 1, 320);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(2, 2 , 315);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(2, 3 , 310);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(3, 1, 280);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(3, 2 , 275);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(3, 3 , 270);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(4, 1, 270);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(4, 2 , 265);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(4, 3 , 260);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(5, 1, 300);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(5, 2 , 295);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(5, 3 , 290);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(6, 1, 290);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(6, 2 , 285);

INSERT INTO preco (produto_id, cliente_id, valor)
VALUES(6, 3 , 280);

-- ------------------------------------------------------------------------------ --

INSERT INTO carrinho(datahora, cliente_id, total)
VALUES(SYSDATE(), 1, 0);

INSERT INTO carrinho(datahora, cliente_id, total)
VALUES(SYSDATE(), 2, 0);

-- ------------------------------------------------------------------------------ --

INSERT INTO item(carrinho_id, produto_id, preco_id, quantidade, total)
VALUES(1, 1, 1, 2, 0);

INSERT INTO item(carrinho_id, produto_id, preco_id, quantidade, total)
VALUES(1, 2, 4, 3, 0);

INSERT INTO item(carrinho_id, produto_id, preco_id, quantidade, total)
VALUES(2, 1, 2, 3, 0);

INSERT INTO item(carrinho_id, produto_id, preco_id, quantidade, total)
VALUES(2, 2, 5, 2, 0);

-- 11) Gerar relatório da lista de item de um pedido de um cliente, 
-- apresentar nome do produtos, quantidade, valor
-- unitário, valor total. --

SELECT produto.nome as Nome, item.quantidade as Quantidade, preco.valor as ValorUnitario, carrinho.total as ValorTotal  
FROM produto, item, preco, carrinho, cliente
WHERE carrinho.cliente_id = 1 
AND carrinho.cliente_id = cliente.id
AND produto.id = preco.produto_id 
AND cliente.id = preco.cliente_id
AND item.produto_id = produto.id 
AND item.preco_id = preco.id 
AND item.carrinho_id = carrinho.id;

-- 12) Relatório do produto mais vendido --

SELECT produto.nome as nome, 
MAX(soma) as TotalUnidadesVendidas 
from (select produto_id, quantidade, SUM(quantidade) AS 'Soma' from item GROUP BY produto_id) as retorno, produto
WHERE produto.id = retorno.produto_id;

--  13) Relatório do cliente que mais compra --

SELECT MAX(somaTotal) as GastoTotal, cliente_id
FROM 
(SELECT SUM(total) as somaTotal, cliente_id 
	from (select item.id, item.quantidade, item.total, carrinho.cliente_id
			from item, carrinho
			where carrinho.id = item.carrinho_id
		 ) as a
			group by cliente_id
) as b ;

-- 14) Relatório com o total em quantidades e valores dos itens já vendidos no sistema --

SELECT produto_id, SUM(total) as SomaValor, SUM(quantidade) as SomaQuantidade
FROM(
	SELECT produto_id, total , quantidade from item as retorno
) as a
GROUP BY produto_id;

-- UPDATES --

-- Para calcular total do item --

UPDATE item i
 JOIN carrinho c ON c.id = i.carrinho_id
 JOIN cliente cl ON c.cliente_id = cl.id
 JOIN preco p ON i.preco_id = p.id
 SET i.total = i.quantidade * p.valor;
 
 -- Para calcular o total do carrinho --
 
 UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
 FROM item GROUP BY carrinho_id) AS i
 SET c.total = i.total
 WHERE c.id = i.carrinho_id;