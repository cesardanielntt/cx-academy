create table cliente (
id int primary key auto_increment,
Cpf varchar (100),
Nome varchar (100)
);

create table endereço (
id int primary key auto_increment,
cep varchar (8),
logradouro varchar (100),
numero varchar (20),
bairro varchar (100),
cidade varchar (100),
uf varchar (2),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);

create table produto (
    id int primary key auto_increment,
    CodigoProduto varchar (50),
    NomeProduto varchar (100)
);



create table carrinho (
	id int primary key auto_increment,
	datahora datetime (6),
	total decimal (6,2),
	cliente_id integer,
	foreign key (cliente_id) references cliente(id)
);


create table preço (
id int primary key auto_increment,
valorproduto varchar (100),
produto_id integer,
foreign key (produto_id) references produto(id),
cliente_id integer,
foreign key (cliente_id) references cliente(id)
);


CREATE TABLE item (
id integer primary key auto_increment,
quantidade INT (100),	
total DECIMAL (6,2),	
produto_id integer,
foreign key (produto_id) references produto(id),
preço_id integer,
foreign key (preço_id) references preço(id),
carrinho_id integer,
foreign key (carrinho_id) references carrinho(id)
);




INSERT INTO cliente (cpf, nome) values ('44912347653', 'Maiara');
INSERT INTO cliente (cpf, nome) values ('9876876543', 'Lidia');
INSERT INTO cliente (cpf, nome) values ('87865676543', 'Claudia');

select * from cliente;

INSERT INTO produto (CodigoProduto, NomeProduto) values ('108790400','Caderno Barbie');
INSERT INTO produto (CodigoProduto, NomeProduto) values  ('222400000','Estojo Roxo');
INSERT INTO produto (CodigoProduto, NomeProduto) values ('109088600','Livro Animado'); 
INSERT INTO produto (CodigoProduto, NomeProduto) values ('106540400','Caneta');
INSERT INTO produto (CodigoProduto, NomeProduto) values  ('20980000','Borracha');
INSERT INTO produto (CodigoProduto, NomeProduto) values ('76545600','Papel Sulfite');

select * from produto;

                                    
INSERT INTO endereço (cep, logradouro, numero, bairro, cidade, uf, cliente_id) values ('7861597','Rua Bahia,','s/n','Centro','Araguainha','MT', 1), ('78636970','Rua Principal','s/n','Jaragua','Água Boa','MT',1);
INSERT INTO endereço (cep, logradouro, numero, bairro, cidade, uf, cliente_id) values ('7657990','Avenida Getúlio Vargas','75','Setor Central','Alto Horizonte','GO',2), ('29475980','Rua Acendino Nunes de Carvalho','s/n','Alto Calçado','Alto Calçado','ES',2);
INSERT INTO endereço (cep, logradouro, numero, bairro, cidade, uf, cliente_id) values ('6879271','Vila de Americano','s/n','Americano','Americano','PA',3), ('98480971','Avenida Principal','s/n','Barra Grande (Zona Rural)','Alpestre','RS',3);

select * from endereço;

INSERT INTO preço (valorproduto, produto_id, cliente_id) values (19.90, 1, 1), (15.00, 2,1 ), (50.50, 3, 1), (5.00, 4, 1), (4.00, 5, 1), (20.00, 6,1);
INSERT INTO preço (valorproduto, produto_id, cliente_id) values (18.90, 1, 2), (14.00, 2,2 ), (49.50, 3, 2), (4.00, 4, 2), (3.00, 5, 2), (19.00, 6,2);
INSERT INTO preço (valorproduto, produto_id, cliente_id) values (17.90, 1, 3), (13.00, 2,3 ), (48.50, 3, 3), (3.00, 4, 3), (4.00, 5, 3), (18.00, 6,3);


select * from preço;

INSERT INTO carrinho (datahora, total, cliente_id) values ('2021-03-15 16:30:00',0, (SELECT id FROM Cliente WHERE Nome = 'Maiara'));
INSERT INTO carrinho (datahora, total, cliente_id) values ('2021-07-14 10:00:00',0, (SELECT id FROM Cliente WHERE Nome = 'Lidia'));
INSERT INTO carrinho (datahora, total, cliente_id) values ('2021-02-12 11:00:00',0, (SELECT id FROM Cliente WHERE Nome = 'Claudia'));


select * from carrinho;

INSERT INTO item (quantidade, total, produto_id, preço_id, carrinho_id) VALUES (3, 0, 1, 2, 1),(3, 0, 3, 1, 1);
INSERT INTO item (quantidade, total, produto_id, preço_id, carrinho_id) VALUES (7, 0, 2, 1, 2),(6, 0, 6, 2, 2);
INSERT INTO item (quantidade, total, produto_id, preço_id, carrinho_id) VALUES (2, 0, 5, 1, 3),(4, 0, 4, 3, 3);

select*from item;

UPDATE item i,
JOIN carrinho c ON c.id = i.carrinho_id
JOIN cliente cl ON c.cliente_id = cl.id
JOIN preço p ON i.preço_id = p.id
SET i.total = i.quantidade * p.valorproduto;







