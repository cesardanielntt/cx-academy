create table produto (
	id int primary key auto_increment,
    sku varchar (50),
    nome varchar (100)
    );
    
    
    create table item (
    id int primary key auto_increment,
    quantidade int (11),
    total decimal (6,2),
    produto_id int (11),
    preco_id int (11),
    carrinho_id int (11),
    foreign key (produto_id) references produto(id),
    foreign key (preco_id) references preco(id),
    foreign key (carrinho_id) references carrinho(id)
    );
    
    create table cliente (
	id int primary key auto_increment,
    cpf varchar (50),
    nome varchar (100)
    );
    
    create table preco (
    id int primary key auto_increment,
    valor decimal (6,2),
    produto_id int (11),
    cliente_id int (11),
    foreign key (produto_id) references produto(id),
    foreign key (cliente_id) references cliente(id)
    );
    
    create table carrinho (
    id int primary key auto_increment,
    datahora datetime,
    total decimal (6,2),
    cliente_id int(11),
    foreign key (cliente_id) references cliente(id)
    );
    
    create table endereço (
    cep varchar (8),
    logradouro varchar (100),
    numero varchar (100),
    bairro varchar (100),
    cidade varchar (100),
    uf varchar (2),
    cliente_id int (11),
    foreign key (cliente_id) references cliente(id)
    );
    
select * from produto;
    insert into produto (sku, nome) values ('001', 'calça jeans'), ('002', 'tenis'), ('003', 'camiseta'), ('004','meias'), ('005', 'cuecas'), ('006', 'calcinhas')
    ;
    
    select * from cliente;
    insert into cliente (cpf, nome) values ('12345678910', 'joao victor'), ('0202020202', 'thales assis'), ('0303030303', 'julia helena')
    ;
    
    select * from endereço;
    insert into endereço (cliente_id, cep, logradouro, numero, bairro, cidade, uf) values ('1', '75071113', 'Rua Primavera', '20', 'Jardim das Américas 3 Etapa', 'Anápolis', 'GO'),
    insert into endereço (cliente_id, cep, logradouro, numero, bairro, cidade, uf) values ('2', '82930425', 'Rua Afonso Francisco Gomes', '21', 'Cajuru', 'Curitiba', 'PR'),
    insert into endereço (cliente_id, cep, logradouro, numero, bairro, cidade, uf) values ('2', '68803971', 'Rua Primeira', '22', 'Centro', 'Antônio Lemos', 'PA'),
    insert into endereço (cliente_id, cep, logradouro, numero, bairro, cidade, uf) values ('3', '55332970', 'Rua do Comércio', '23', 'Centro', 'Barra do Brejo', 'PE')
    ;
    select * from preco;
    insert into preco (produto_id, valor, cliente_id) values ('1','70','1'),
	insert into preco (produto_id, valor, cliente_id) values ('1','78','2'), 
	insert into preco (produto_id, valor, cliente_id) values ('1','85','3'),
	insert into preco (produto_id, valor, cliente_id) values ('2','300','1'),
    insert into preco (produto_id, valor, cliente_id) values ('2','295','2'),
    insert into preco (produto_id, valor, cliente_id) values ('2','330','3'),
    insert into preco (produto_id, valor, cliente_id) values ('3','120','1'),
    insert into preco (produto_id, valor, cliente_id) values ('3','115','2'),
    insert into preco (produto_id, valor, cliente_id) values ('3','145','3'),
    insert into preco (produto_id, valor, cliente_id) values ('4','35','1'),
    insert into preco (produto_id, valor, cliente_id) values ('4','25','2'),
    insert into preco (produto_id, valor, cliente_id) values ('4','25','3'),
    insert into preco (produto_id, valor, cliente_id) values ('5','25','1'),
    insert into preco (produto_id, valor, cliente_id) values ('5','22','2'),
    insert into preco (produto_id, valor, cliente_id) values ('5','27','3'),
    insert into preco (produto_id, valor, cliente_id) values ('6','27','1'),
    insert into preco (produto_id, valor, cliente_id) values ('6','25','2'),
    insert into preco (produto_id, valor, cliente_id) values ('6','20','3')
    ;
    
    select * from carrinho;
    insert into carrinho (datahora, total, cliente_id) values ('2022-03-06 12:24:39', '216', '2'),
    insert into carrinho (datahora, total, cliente_id) values ('2022-12-12 18:39:39', '660', '3')
    ;
    select * from item;
    insert into item (carrinho_id, produto_id, preco_id, quantidade, total) values ('1', '1', '2', '1','78'),
    insert into item (carrinho_id, produto_id, preco_id, quantidade, total) values ('1', '4', '11', '2','50'),
    insert into item (carrinho_id, produto_id, preco_id, quantidade, total) values ('1', '5', '14', '4','88'),
    insert into item (carrinho_id, produto_id, preco_id, quantidade, total) values ('2', '3', '9', '2','290'),
    insert into item (carrinho_id, produto_id, preco_id, quantidade, total) values ('2', '6', '18', '2','20'),
    insert into item (carrinho_id, produto_id, preco_id, quantidade, total) values ('2', '2', '6', '1','330')
    ;
    
     UPDATE item i 
     JOIN carrinho c ON c.id = i.carrinho_id
     JOIN cliente cl ON c.cliente_id = cl.id
     JOIN preco p ON i.preco_id = p.id 
     SET i.total = i.quantidade * p.valor
     ; 
     select * from item
     
     update carrinho c, (select carrinho_id, SUM(total) as total
     from item group by carrinho_id) as i
     set c.total = i.total
     where c.id = i.carrinho_id;
     
     set SQL_SAFE_UPDATES = 0;
     
     select p.nome as produto, i.quantidade as quantidade, pr.valor as preco_id, i.total as valor
from produto p, item i, preco pr, carrinho c, cliente cl
where c.cliente_id = 1 
and c.cliente_id = c.id
and p.id = pr.Produto_id 
and cl.id = pr.cliente_id
and i.preco_id = p.id 
and i.preco_id = pr.id 
and i.carrinho_id = c.id;

select i.quantidade, p.nome as produto
from item i
inner join produto p 
on p.id = i.produto_id 
where quantidade > 0 order by quantidade
desc limit 1;

select sum(total), cliente_id from carrinho group by cliente_id
order by sum(cliente_id) desc limit 1;

select i.quantidade, i.total, p.nome
from item i 
inner from produto p 
on p.id = i.produto_id 
where quantidade > 0 order by total;
     
     
     
     
     
     