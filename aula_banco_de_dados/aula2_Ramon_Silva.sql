<<<<<<< HEAD
-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 2 --
-- ----------------------------------------------------- --

--  Francisco Ramon Da Silva Holanda  --

create database cxcommerce;
use cxcommerce;

create table produto(
	id integer primary key auto_increment,
    sku varchar(50),
    nome varchar(100)
);

create table item(
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

create table carrinho(
	id int auto_increment primary key,
    datahora datetime,
    total decimal(6,2),
    cliente_id int(11),
    foreign key (cliente_id) references cliente(id)
);

create table preco(
	id integer auto_increment primary key,
    valor decimal(6,2),
    produto_id int(11),
    cliente_id int(11),
    foreign key(produto_id) references produto(id),
    foreign key(cliente_id) references cliente(id)
);

create table cliente(
	id int auto_increment primary key,
    cpf varchar(11),
    nome varchar(100)
);

create table endereco(
	id int primary key auto_increment,
    cep varchar(8),
    logradouro varchar(100),
    numero varchar(20),
    bairro varchar(100),
    cidade varchar(100),
    uf varchar(2),
    cliente_id int(11),
    foreign key(cliente_id) references cliente(id)
);

create table preco (
	id integer(11) primary key auto_increment,
    valor decimal(6,2),
    produto_id int(11),
    cliente_id int(11),
    foreign key(produto_id) references produto(id),
    foreign key(cliente_id) references cliente(id)
);

insert into produto (sku, nome) values
	('12da54', 'Arroz'),
    ('93jwxm', 'Camisa'),
    ('djwn31a', 'Calça'),
	('wdsa28', 'pipoca'),
    ('d88dsf', 'feijão'),
    ('asd4d7', 'carne');
    
insert into cliente (cpf, nome) values
	('25415842', 'Carla'),
    ('78856822', 'Jessica'),
    ('89152245', 'Jefersom');
    

insert into preco(valor, produto_id, cliente_id) values 
	(58.20, 1, 3),
    (80.12, 2, 1),
    (40.50, 3, 2),
	(89.50, 4, 2),
    (75.23, 6, 3),
    (150.00, 5, 1);	

insert into carrinho(datahora, total, cliente_id) values 
	(CURDATE(), 50.00, 1),
    (CURDATE(), 200.00, 3),
    (CURDATE(), 300.12, 2);
    

insert into item
(quantidade, total, produto_id, preco_id, carrinho_id)
values
	(3, 200.00, 2, 1, 2),
    (5, 250.00, 3, 3, 1),
    (2, 100.00, 1, 2, 3),
	(10, 20.00, 6, 5, 2),
    (8, 500.00, 4, 6, 1),
    (15, 100.00, 5, 4, 3);
	
    
insert into endereco 
(cep, logradouro, numero, bairro, cidade, uf, cliente_id) 
values
	('64608600', 'avenida paulista', '12', 'junco', 'são paulo', 'SP', 2),
    ('64082125', 'avenida beira rio', '25', 'susuapara', 'picos', 'PI', 1),
    ('64027040', 'estrada 527', '27', 'cohab', 'picos', 'PI', 2);
    
update item i
join carrinho c on c.id = i.carrinho_id
join cliente cl on c.cliente_id = cl.id
join preco p on i.preco_id = p.id
set i.total = i.quantidade * p.valor;

update carrinho c, (select carrinho_id, sum(total) as 'total'
from item group by carrinho_id) as i
set c.total = i.total
where c.id = i.carrinho_id;

select * from produto;

select p.nome, i.quantidade, pr.valor, i.total from item i
join produto p on p.id = i.produto_id
join preco pr on pr.id = i.produto_id
where cliente_id = 2; -- baseando-se na cliente jessica

SELECT pr.nome AS Produto, i.quantidade, p.valor, c.total
FROM carrinho c 
JOIN item i ON i.carrinho_id = c.id
JOIN produto pr ON i.produto_id = pr.id
JOIN preco p ON p.produto_id = pr.id
JOIN cliente cl ON c.cliente_id = cl.id AND p.cliente_id = cl.id WHERE cl.nome = 'jessica';

-- pegando o produto com maior numero de vendas
select max(total) as "Número de Vendas", Nome from(
	select sum(quantidade) as total, nome as Nome 
    from item i
	join produto p on i.produto_id = p.id
    group by p.nome
    order by quantidade desc
) as total;


-- cliente que mais comprou
select max(total_compras) as 'pedidos', nome from (
	select sum(quantidade) as total_compras, nome
    from cliente c
    join preco p on p.cliente_id = c.id
    join item i on i.preco_id = p.id
    group by nome
    order by total_compras desc
) as total_compras;


select sum(quantidade) as 'Total de vendas', sum(i.total) as 'Total de lucros'
	from cliente c 
	inner join preco p on p.cliente_id = c.id 
	inner join item i on i.preco_id = p.id

=======
-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 2 --
-- ----------------------------------------------------- --

-- Todas as tabelas devem ser preenchidas com alguma informação
-- Popular a base com pelo menos 3 clientes
-- cliente deve ter 2 endereços
-- Popular a base com pelo menos 6 produtos
-- Cada produto deve ter pelo menos 1 preço para cada cliente
-- Criar pelo menos 2 carrinhos (neste caso, cada um com clientes diferentes)
-- Dos 2 carrinhos, cada um deve ter ao menos 2 items
-- Os totais das tabelas Item e Carrinho podem ser calculados posteriormente, ver dicas
-- Gerar relatório da lista de item de um pedido de um cliente, apresentar nome do produtos, quantidade, valor
-- unitário, valor total.
-- Relatório do produto mais vendido
-- Relatório do cliente que mais compra
-- Relatório com o total em quantidades e valores dos itens já vendidos no sistema

create database if not exists cxcommerce;
use cxcommerce;

create table if not exists produto (
	id int not null auto_increment,
    sku varchar(50),
    nome varchar(100),
    primary key(id)
);

create table if not exists cliente (
	id int not null auto_increment,
    cpf varchar(11),
    nome varchar(100),
    primary key(id)
);


create table if not exists preco (
	id int not null auto_increment,
	valor decimal(6,2),
    produto_id int,
    cliente_id int,
    primary key(id),
    foreign key(produto_id) references produto(id),
    foreign key(cliente_id) references cliente(id)
);

create table if not exists carrinho (
	id int not null auto_increment,
	datahora datetime,
    total decimal(6,2),
    cliente_id int,
    primary key(id),
    foreign key(cliente_id) references cliente(id)
);

create table if not exists item (
	id int not null auto_increment,
	quantidade int not null,
    total decimal(6,2),
    produto_id int,
    preco_id int,
    carrinho_id int,
    primary key(id),
    foreign key(produto_id) references produto(id),
    foreign key(preco_id) references preco(id),
    foreign key(carrinho_id) references carrinho(id)
);

create table if not exists endereco (
	id int not null auto_increment,
	cep varchar(8),
    logradouro varchar(100),
	numero varchar(20),
    bairro varchar(100),
    cidade varchar(100),
    uf char(2),
    cliente_id int,
    primary key(id),
    foreign key(cliente_id) references cliente(id)
);

insert into produto (sku, nome) values 
	("a1", "senhor dos aneis sociedade do anel"),
	("a2", "harry potter prisioneiro de askaban"),
	("a3", "controle xbox series x"),
	("a4", "DnD 5e Livro do Jogador"),
	("a5", "jujutsu kaisen");

insert into cliente (cpf, nome) values 
	("1111", "Archibald Brock"),
	("1112", "Albertina Farwell"),
	("1113", "Eldridge Eddie"),
	("1115", "Daisy Freeman"),
	("1116", "Forest Welch");

insert into endereco (cep, logradouro, numero, bairro, cidade, uf, cliente_id) values
	("58103766", "Rua Ferroviário", "1234", "Jardim Camboinha", "Cabedelo", "PB", 1),
	("68902321", "Passagem S do Sena", "8913", "Muca", "Macapá", "AP", 1),
	("12608160", "Rua Santa Catarina", "5123", "Vila Hepacare", "Lorena", "SP", 2),
	("39102971", "Rua Principal, s/n", "754", "Centro", "Sopa", "MG", 2),
	("23820445", "Rua Luiz Carlos Dias", "1344", "Engenho", "Itaguaí", "RJ", 3),
	("38414650", "Rua Iolanda Alves Figueira", "8913", "Jardim Europa", "Uberlândia", "MG", 3),
	("35430253", "Rua Santa Efigênia", "8236", "Alvorada", "Boa Vista", "RR", 4),
	("78088405", "Rua Trezentos e Dezessete", "754", "Tijucal", "Cuiabá", "MT", 4),
	("59114068", "Travessa Noel Rosa", "2351", "Nossa Senhora da Apresentação", "Natal", "RN", 5),
	("29164854", "Rua da Mangueira", "612", "Balneário de Carapebus", "Serra", "ES", 5);
    
insert into preco (valor, produto_id, cliente_id) values
	(249.90, 3, 4),
    (29.90, 4, 4),
    (49.90, 2, 2),
    (49.90, 1, 3),
    (29.90, 5, 1),
    (49.90, 1, 1),
    (29.90, 5, 2),
    (49.90, 2, 2);
    
insert into carrinho (datahora, total, cliente_id) values
	(sysdate(), 79.80, 1),
    (sysdate(), 129.70, 2),
    (sysdate(), 49.90, 3),
    (sysdate(), 279.80, 4),
    (sysdate(), 00.00, 5);
    
insert into item (quantidade, total, produto_id, preco_id, carrinho_id) values
	(3, 87.70 ,5 , 5, 1),
    (1, 49.90 ,1 , 6, 1),
    (1, 49.90 ,2 , 3, 2),
    (1, 29.90 ,5 , 7, 2),
    (1, 49.90 ,2 , 8, 2),
    (1, 49.90 ,1 , 4, 3),
    (1, 249.90 ,3 , 1, 4),
    (1, 29.90 ,4 , 2, 4);
    
    
-- UPDATE item i
-- JOIN carrinho c ON c.id = i.carrinho_id
-- JOIN cliente cl ON c.cliente_id = cl.id
-- JOIN preco p ON i.preco_id = p.id
-- SET i.total = i.quantidade * p.valor;

-- UPDATE carrinho c, (SELECT carrinho_id, SUM(total) AS total
-- FROM item GROUP BY carrinho_id) AS i
-- SET c.total = i.total
-- WHERE c.id = i.carrinho_id;


-- Todos os produtos no pedido de um cliente
select cl.nome, pr.nome, i.quantidade, p.valor, c.total from item i
	join carrinho c on i.carrinho_id = c.id
    join cliente cl on c.cliente_id = cl.id
    join preco p on i.preco_id = p.id
    join produto pr on i.produto_id = pr.id
where cl.id = 1;

-- Produtos mais vendido
select p.nome, SUM(i.quantidade) as total_vendido from item i
	join produto p on i.produto_id = p.id
group by(p.id) order by(total_vendido) desc;

-- Cliente que mais compra
select cl.nome, SUM(i.quantidade) as produtos_comprados from item i
	join carrinho c on i.carrinho_id = c.id
    join cliente cl on c.cliente_id = cl.id
group by(cl.id) order by(produtos_comprados) desc; 

select p.nome, SUM(i.quantidade) as quantidade, SUM(i.total) as total from item i
	join produto p on i.produto_id - p.id
group by(p.id);



>>>>>>> feature_ramon_silva
