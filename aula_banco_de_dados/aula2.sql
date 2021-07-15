-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 2 --
-- ----------------------------------------------------- --


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

