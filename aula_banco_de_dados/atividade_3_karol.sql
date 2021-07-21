-- Karoline Lays Penteado Alves --
CREATE DATABASE cxcommerce;

CREATE TABLE produto (
id INT(11) primary key auto_increment,
sku varchar (50),
nome varchar (100)
);

CREATE TABLE cliente (
id INT(11) primary key auto_increment,
cpf varchar (11),
nome varchar (100)
);

CREATE TABLE preco (
id INT(11) primary key auto_increment,
valor DECIMAL (6,2),
produto_id integer,
foreign key (Produto_id) references Produto(id),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);

CREATE TABLE carrinho (
id INT(11) primary key auto_increment,
datahora datetime,
total decimal (6,2),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);

CREATE TABLE item (
id INT(11) primary key auto_increment,
quantidade INT(11),	
total DECIMAL (6,2),	
produto_id integer,
foreign key (produto_id) references produto(id),
preco_id integer,
foreign key (preco_id) references preco(id),
carrinho_id integer,
foreign key (carrinho_id) references carrinho(id)
);

CREATE TABLE endereco (
id INT(11) primary key auto_increment,
cep varchar (9),
logradouro Varchar (100),
numero varchar (100),
bairro varchar (100),
cidade varchar (100),
UF varchar (2),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);
																				-- 
									-- -- Alimentação tabela PRODUTO -- --
                                    
INSERT INTO produto (sku, nome) 
values ('A125AKD','Smartphone ASUS 9'), 
('E669D82JKFS','Smartphone Motorola'), 
('FSF956FEWF','Smartphone XIOME 8'),
('DSFS653VEF','Smartphone LG K20'),
 ('BFG65265','Iphone 10'), 
 ('FKSDNJF65','Smartphone SAMSUNG');
 


select * from produto;
									-- -- Alimentação tabela CLIENTE -- --
                                    
INSERT INTO cliente (nome, cpf) 
values ('Karol','71297438910'),
('Joao','88898262008'),
('Mateus','95067097848');

select * from cliente;
									-- -- Alimentação tabela ENDEREÇO -- --
                                    
INSERT INTO endereco (cep,logradouro, numero, bairro, cidade, UF, cliente_id) 
VALUES ('84016190','Rua Governador Bento Munhoz da Rocha Neto','816','Jardim Carvalho','Ponta Grossa','PR', 1),
('76870132','Alameda Cacaueiro','605','Setor 01','Serra','ES',2),
('29167332','Rua Pitangueira','446','Boulevard Lagoa','Serra','ES',3), 
('49072296','Rua Maria Iraci Menezes','28','Dezoito do Forte','Aracaju','SE',3);

select * from endereco;
									-- -- Alimentação tabela PREÇO -- --
                                    
INSERT INTO preco (produto_id, cliente_id, valor) 
values (1, 1, 1159.00),(2, 1, 1289.00), (3, 1, 1099.00), (4, 1, 1499.00), (5, 1, 929.90), (6, 1, 899.99),
(1, 2, 1259.00),(2, 2, 1389.00), (3, 2, 1199.00), (4, 2, 499.00), (5, 2, 1929.90), (6, 2, 1899.99),
(1, 3, 1359.00),(2, 3, 1989.00), (3, 3, 999.00), (4, 3, 1699.00), (5, 3, 959.90), (6, 3, 1299.99);


select * from preco;
									-- -- Alimentação tabela CARRINHO -- --
                                    
INSERT INTO carrinho (datahora, total, cliente_id) 
VALUES ('2021-01-15 08:58:08',0, (SELECT id FROM cliente WHERE nome = 'Karol')),
('2021-01-18 21:50:18',0, (SELECT id FROM cliente WHERE nome = 'Joao')),
('2021-05-19 11:50:18',0, (SELECT id FROM cliente WHERE nome = 'Mateus'));

select * from carrinho;
									-- -- Alimentação tabela ITEM -- --
                                    
INSERT INTO item (produto_id, preco_id, carrinho_id, quantidade, total)
VALUES (2, 2, 1, 1, 0),(3, 3, 2, 3, 0),(4, 4, 3, 4, 0);

select*from item;


										 
										-- -- UPDATE ITEM -- --
                                        
UPDATE item i
JOIN carrinho c ON c.id = i.carrinho_id
JOIN cliente cl ON c.cliente_id = cl.id
JOIN preco p ON i.preco_id = p.id
SET i.total = i.quantidade * p.valor;

select * from item;

										-- -- UPDATE CARRINHO -- --
SET SQL_SAFE_UPDATES = 0;

UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
FROM item GROUP BY carrinho_id) AS i
SET c.total = i.total
WHERE c.id = i.carrinho_id;

select * from carrinho;

										-- -- Lista de Vendas -- --
SELECT p.nome as produto, i.quantidade as quantidade, pr.valor as ValorUnitario, i.total as ValorTotal 
FROM produto p, item i, preco pr, carrinho c, cliente cl 
WHERE c.cliente_id = 3  
AND c.cliente_id = c.id 
AND p.id = pr.produto_id  
AND cl.id = pr.cliente_id 
AND i.produto_id = p.id  
AND i.preco_id = pr.id  
AND i.carrinho_id = c.id;


										-- -- Produto Mais Vendido -- --
select i.quantidade, p.nome as produto 
from item i  
inner join produto p 
on p.id = i.produto_id 
where quantidade > 0 order by quantidade desc limit 1;      
									-- -- Cliente que mais compra -- --
select sum(total), cliente_id 
from carrinho 
group by cliente_id
order by sum(cliente_id) desc limit 1;
			-- -- Cliente total em quantidades e valores dos itens já vendidos no sistema -- --
SELECT i.quantidade, i.total, p.nome
From item i
INNER JOIN produto p
on p.id = i.produto_id
WHERE quantidade > 0 order by total 









