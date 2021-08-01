CREATE TABLE Produto (
id integer primary key auto_increment unique,
CódigoProduto varchar (100),
NomeProduto varchar (100)
);

CREATE TABLE Cliente (
id integer primary key auto_increment,
CPF varchar (100),
Nome varchar (100)
);

CREATE TABLE Preço (
id integer primary key auto_increment,
ValorProduto DECIMAL (6,2),
Produto_id integer,
foreign key (Produto_id) references Produto(id),
Cliente_id integer,
foreign key (Cliente_id) references Cliente(id)
);

CREATE TABLE Carrinho (
id integer primary key auto_increment,
DataHora datetime (6),
Total decimal (6,2),
Cliente_id integer,
foreign key (Cliente_id) references Cliente(id)
);

CREATE TABLE Item (
id integer primary key auto_increment,
Quantidade INT (100),	
Total DECIMAL (6,2),	
Produto_id integer,
foreign key (Produto_id) references Produto(id),
Preço_id integer,
foreign key (Preço_id) references Preço(id),
Carrinho_id integer,
foreign key (Carrinho_id) references Carrinho(id)
);

CREATE TABLE Endereço (
id integer primary key auto_increment,
CEP varchar (9),
Logradouro Varchar (100),
Número varchar (100),
Bairro varchar (100),
Cidade varchar (100),
UF varchar (2),
Cliente_id integer,
foreign key (Cliente_id) references Cliente(id)
);
																				-- 
									-- -- Alimentação tabela PRODUTO -- --
                                    
INSERT INTO Produto (CódigoProduto, NomeProduto) values ('108507400','Secador de Cabelo Profissional'), ('222478900','Air Fryer Nell Smart Preta'), ('108508600','Escova Secadora Mondial Cerâmica');
INSERT INTO Produto (CódigoProduto, NomeProduto) values ('225608200','Smart TV HD LED 32” Samsung'), ('144129900','Jogo de Panelas Tramontina Antiaderente'), ('121927506','Sofá Retrátil Reclinável 3 Lugares Suede');

select * from Produto;
									-- -- Alimentação tabela CLIENTE -- --
                                    
INSERT INTO Cliente (Nome, CPF) values ('Andreia Fátima Porto','812.974.336-10'),('Rafaela Alícia Bárbara Almeida','288.182.420-08'),('Mateus Luan Davi Pires','440.770.977-46');

select * from Cliente;
									-- -- Alimentação tabela ENDEREÇO -- --
                                    
INSERT INTO Endereço (CEP,Logradouro, Número, Bairro, Cidade, UF, Cliente_id) values ('57075-855','Rua São Benedito','816','Santos Dumont','Maceió','AL', 1),('89231-755','Rua João Antônio de Souza','774','Paranaguamirim','Joinville','SC',1);
INSERT INTO Endereço (CEP,Logradouro, Número, Bairro, Cidade, UF, Cliente_id) values ('41500-505','Rua Nazaré','605','São Cristóvão','Salvador','BA',2),('69070-550','Beco Vale da Felicidade','106','Educandos','Manaus','AM',2);
INSERT INTO Endereço (CEP,Logradouro, Número, Bairro, Cidade, UF, Cliente_id) values ('44090-792','Rua Missionária','446','Tomba','Feira de Santana','BA',3), ('64017-790','Rua Y','28','Três Andares','Teresina','PI',3);

select * from Endereço;
									-- -- Alimentação tabela PREÇO -- --
                                    
INSERT INTO Preço (Produto_id, Cliente_id, ValorProduto) values (1, 1, 159.90),(2, 1, 289.00), (3, 1, 199.00), (4, 1, 1499.00), (5, 1, 329.90), (6, 1, 899.99);
INSERT INTO Preço (Produto_id, Cliente_id, ValorProduto) values (1, 2, 149.90),(2, 2, 279.00), (3, 2, 189.00), (4, 2, 1399.00), (5, 2, 319.90), (6, 2, 889.99);
INSERT INTO Preço (Produto_id, Cliente_id, ValorProduto) values (1, 3, 139.90),(2, 3, 269.00), (3, 3, 179.00), (4, 3, 1299.00), (5, 3, 309.90), (6, 3, 879.99);

select * from Preço;
									-- -- Alimentação tabela CARRINHO -- --
                                    
INSERT INTO Carrinho (DataHora, Total, Cliente_id) values ('2021-08-15 16:00:00',0, (SELECT id FROM Cliente WHERE Nome = 'Andreia Fátima Porto'));
INSERT INTO Carrinho (DataHora, Total, Cliente_id) values ('2021-03-14 20:00:00',0, (SELECT id FROM Cliente WHERE Nome = 'Rafaela Alícia Bárbara Almeida'));
INSERT INTO Carrinho (DataHora, Total, Cliente_id) values ('2021-02-08 08:00:00',0, (SELECT id FROM Cliente WHERE Nome = 'Mateus Luan Davi Pires'));

select * from Carrinho;
									-- -- Alimentação tabela ITEM -- --
                                    
INSERT INTO Item (Produto_id, Preço_id, Carrinho_id, Quantidade, Total) VALUES (1, 1, 1, 2, 0),(3, 3, 1, 4, 0);
INSERT INTO Item (Produto_id, Preço_id, Carrinho_id, Quantidade, Total) VALUES (2, 2, 2, 1, 0),(6, 6, 2, 3, 0);
INSERT INTO Item (Produto_id, Preço_id, Carrinho_id, Quantidade, Total) VALUES (5, 5, 3, 1, 0),(4, 4, 3, 1, 0);

select*from Item;


										 
										-- -- UPDATE ITEM -- --
                                        
UPDATE Item i
JOIN Carrinho c ON c.id = i.Carrinho_id
JOIN Cliente cl ON c.Cliente_id = cl.id
JOIN Preço p ON i.Preço_id = p.id
SET i.Total = i.Quantidade * p.ValorProduto;

select * from Item;

										-- -- UPDATE CARRINHO -- --
SET SQL_SAFE_UPDATES = 0;

UPDATE Carrinho c, (SELECT Carrinho_id, SUM(Total) AS Total
FROM Item GROUP BY Carrinho_id) AS i
SET c.Total = i.Total
WHERE c.id = i.Carrinho_id;

select * from Carrinho;

										-- -- Lista de Vendas -- --
                                        
SELECT p.NomeProduto as Produto, i.Quantidade as Quantidade, pr.ValorProduto as ValorUnitario, i.Total as ValorTotal
FROM Produto p, Item i, Preço pr, Carrinho c, Cliente cl
WHERE c.Cliente_id = 1 
AND c.Cliente_id = c.id
AND p.id = pr.Produto_id 
AND cl.id = pr.Cliente_id
AND i.Produto_id = p.id 
AND i.Preço_id = pr.id 
AND i.Carrinho_id = c.id;

										-- -- Produto Mais Vendido -- --
                                        
select i.Quantidade, p.NomeProduto as Produto 
from Item i  
inner join Produto p 
on p.id = i.Produto_id 
where Quantidade > 0 order by Quantidade
desc limit 1;

										-- -- Cliente que mais Comprou -- --
                                        
select sum(total), Cliente_id from Carrinho group by Cliente_id
order by sum(cliente_id) desc limit 1;

										-- -- Total em quantidades e valores dos itens já vendidos no sistema -- --

SELECT i.Quantidade, i.Total, p.NomeProduto
From Item i 
INNER JOIN Produto p 
on p.id = i.Produto_id 
WHERE Quantidade > 0 order by Total;




