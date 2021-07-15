-- Ex 1
create database cxcommerce;
use cxcommerce;

-- Ex 2
create table produto(
	id int(11) primary key auto_increment,
    sku varchar (50),
    nome varchar (100)
);

create table cliente(
	id int(11) primary key auto_increment,
    CPF varchar(11),
    nome varchar(100)
);

create table carrinho(
	id int(11) primary key auto_increment,
    datahora datetime,
    total decimal(6,2),
    cliente_id int(11),
    constraint foreign key (cliente_id) references cliente(id)
);

create table preco(
	id int(11) primary key auto_increment,
    valor decimal(6,2),
    produto_id int(11),
    cliente_id int(11),
    constraint foreign key (cliente_id) references cliente(id),
    constraint foreign key (produto_id) references produto(id)
 );


create table item(
	id int(11) primary key auto_increment,
    quantidade int(11),
    total decimal(6,2),
    produto_id int(11),
    preco_id int(11),
    carrinho_id int(11),
    constraint foreign key (produto_id) references produto(id),
    constraint foreign key (preco_id) references preco(id),
    constraint foreign key (carrinho_id) references carrinho(id)
);

create table endereco(
	id int(11) primary key auto_increment,
    cep varchar(50),
    logradouro varchar(100),
    numero varchar(20),
    bairro varchar(50),
    cidade varchar(100),
    uf varchar (2),
    cliente_id int(11),
    constraint foreign key (cliente_id) references cliente(id)
);


-- Valores Tabela Produto
insert into produto (sku,nome) values ('0001','borracha');
insert into produto (sku,nome) values ('0002','lapis');
insert into produto (sku,nome) values ('0003','folha');
insert into produto (sku,nome) values ('0004','tesoura');
insert into produto (sku,nome) values ('0005','fita adesiva');
insert into produto (sku,nome) values ('0006','lapiseira');


-- Valores Tabela Cliente
insert into cliente (CPF,nome) values ('94717201094','Carlos Eduardo');
insert into cliente (CPF,nome) values ('00894036068','Maria Eduarda');
insert into cliente (CPF,nome) values ('73833413093','Matheus Pererira');
insert into cliente (CPF,nome) values ('04881302043','Ana Luiza');
insert into cliente (CPF,nome) values ('50571381030','Afonso Padilha');
insert into cliente (CPF,nome) values ('69639776076','Maria Clara');
insert into cliente (CPF,nome) values ('86064250011','Thiago Cardoso');
insert into cliente (CPF,nome) values ('26694917074','Letici Pererira');
insert into cliente (CPF,nome) values ('79979148039','Neymar Junior');
insert into cliente (CPF,nome) values ('69037093043','Isabela Silva');

-- Valores Tabela Preco
insert into preco (valor,produto_id,cliente_id) values (50.00,1,1);
insert into preco (valor,produto_id,cliente_id) values (50.00,2,1);
insert into preco (valor,produto_id,cliente_id) values (50.00,3,1);
insert into preco (valor,produto_id,cliente_id) values (50.00,4,1);
insert into preco (valor,produto_id,cliente_id) values (50.00,5,1);
insert into preco (valor,produto_id,cliente_id) values (50.00,6,1);

insert into preco (valor,produto_id,cliente_id) values (22.50,1,2);
insert into preco (valor,produto_id,cliente_id) values (22.50,2,2);
insert into preco (valor,produto_id,cliente_id) values (22.50,3,2);
insert into preco (valor,produto_id,cliente_id) values (22.50,4,2);
insert into preco (valor,produto_id,cliente_id) values (22.50,5,2);
insert into preco (valor,produto_id,cliente_id) values (22.50,6,2);

insert into preco (valor,produto_id,cliente_id) values (15.00,1,3);
insert into preco (valor,produto_id,cliente_id) values (15.00,2,3);
insert into preco (valor,produto_id,cliente_id) values (15.00,3,3);
insert into preco (valor,produto_id,cliente_id) values (15.00,4,3);
insert into preco (valor,produto_id,cliente_id) values (15.00,5,3);
insert into preco (valor,produto_id,cliente_id) values (15.00,6,3);

insert into preco (valor,produto_id,cliente_id) values (10.00,1,4);
insert into preco (valor,produto_id,cliente_id) values (10.00,2,4);
insert into preco (valor,produto_id,cliente_id) values (10.00,3,4);
insert into preco (valor,produto_id,cliente_id) values (10.00,4,4);
insert into preco (valor,produto_id,cliente_id) values (10.00,5,4);
insert into preco (valor,produto_id,cliente_id) values (10.00,6,4);

insert into preco (valor,produto_id,cliente_id) values (12.00,1,5);
insert into preco (valor,produto_id,cliente_id) values (12.00,2,5);
insert into preco (valor,produto_id,cliente_id) values (12.00,3,5);
insert into preco (valor,produto_id,cliente_id) values (12.00,4,5);
insert into preco (valor,produto_id,cliente_id) values (12.00,5,5);
insert into preco (valor,produto_id,cliente_id) values (12.00,6,5);

insert into preco (valor,produto_id,cliente_id) values (40.00,1,6);
insert into preco (valor,produto_id,cliente_id) values (40.00,2,6);
insert into preco (valor,produto_id,cliente_id) values (40.00,3,6);
insert into preco (valor,produto_id,cliente_id) values (40.00,4,6);
insert into preco (valor,produto_id,cliente_id) values (40.00,5,6);
insert into preco (valor,produto_id,cliente_id) values (40.00,6,6);

insert into preco (valor,produto_id,cliente_id) values (66.00,1,7);
insert into preco (valor,produto_id,cliente_id) values (66.00,2,7);
insert into preco (valor,produto_id,cliente_id) values (66.00,3,7);
insert into preco (valor,produto_id,cliente_id) values (66.00,4,7);
insert into preco (valor,produto_id,cliente_id) values (66.00,5,7);
insert into preco (valor,produto_id,cliente_id) values (66.00,6,7);

insert into preco (valor,produto_id,cliente_id) values (100.00,1,8);
insert into preco (valor,produto_id,cliente_id) values (100.00,2,8);
insert into preco (valor,produto_id,cliente_id) values (100.00,3,8);
insert into preco (valor,produto_id,cliente_id) values (100.00,4,8);
insert into preco (valor,produto_id,cliente_id) values (100.00,5,8);
insert into preco (valor,produto_id,cliente_id) values (100.00,6,8);

insert into preco (valor,produto_id,cliente_id) values (45.00,1,9);
insert into preco (valor,produto_id,cliente_id) values (45.00,2,9);
insert into preco (valor,produto_id,cliente_id) values (45.00,3,9);
insert into preco (valor,produto_id,cliente_id) values (45.00,4,9);
insert into preco (valor,produto_id,cliente_id) values (45.00,5,9);
insert into preco (valor,produto_id,cliente_id) values (45.00,6,9);

insert into preco (valor,produto_id,cliente_id) values (55.00,1,10);
insert into preco (valor,produto_id,cliente_id) values (55.00,2,10);
insert into preco (valor,produto_id,cliente_id) values (55.00,3,10);
insert into preco (valor,produto_id,cliente_id) values (55.00,4,10);
insert into preco (valor,produto_id,cliente_id) values (55.00,5,10);
insert into preco (valor,produto_id,cliente_id) values (55.00,6,10);


select * from preco order by cliente_id;

select * from carrinho;


-- Valores Tabela Carrinho
insert into carrinho (datahora,total,cliente_id) values ('2021-05-26',0.00,5);
insert into carrinho (datahora,total,cliente_id) values ('2021-02-24',0.00,5);
insert into carrinho (datahora,total,cliente_id) values ('2021-06-10',0.00,4);
insert into carrinho (datahora,total,cliente_id) values ('2021-03-08',0.00,3);
insert into carrinho (datahora,total,cliente_id) values ('2021-02-01',0.00,9);
insert into carrinho (datahora,total,cliente_id) values ('2021-03-15',0.00,10);
insert into carrinho (datahora,total,cliente_id) values ('2021-04-14',0.00,8);

-- Valores Tabela Item
select * from item;
insert into item (quantidade, total, produto_id, preco_id,carrinho_id) values (10,0.00,2,6,2);
insert into item (quantidade, total, produto_id, preco_id,carrinho_id) values (5,0.00,1,6,5);
insert into item (quantidade, total, produto_id, preco_id,carrinho_id) values (4,0.00,3,7,1);
insert into item (quantidade, total, produto_id, preco_id,carrinho_id) values (6,0.00,1,5,4);
insert into item (quantidade, total, produto_id, preco_id,carrinho_id) values (8,0.00,2,6,2);


-- Valores Tabela Endereco
insert into endereco (cep,logradouro,numero,bairro,cidade,uf,cliente_id) values ('11020050','Rua Doutor Bezerra de Menezes','33','Macuco','Santos','SP',6);
insert into endereco (cep,logradouro,numero,bairro,cidade,uf,cliente_id) values ('13502301','Rua 19 NR','455','Jardim Nova Rio Claro','Rio Claro','SP',4);
insert into endereco (cep,logradouro,numero,bairro,cidade,uf,cliente_id) values ('31560200','Avenida Deputado Anuar Menhen','64','Santa Amélia','Belo Horizonte','MG',3);
insert into endereco (cep,logradouro,numero,bairro,cidade,uf,cliente_id) values ('31060240','Rua Lagamar','500','Boa Vista','Belo Horizonte','MG',3);
insert into endereco (cep,logradouro,numero,bairro,cidade,uf,cliente_id) values ('24325010','Rua Sant Ana','65','Maria Paula','Niterói','RJ',8);
insert into endereco (cep,logradouro,numero,bairro,cidade,uf,cliente_id) values ('24360170','Rua Caetés','10','São Francisco','Niterói','RJ',1);


update item i join carrinho c on c.id = i.carrinho_id join cliente cl on c.cliente_id = cl.id join preco p on i.preco_id = p.id set i.total = i.quantidade * p.valor;
update carrinho c,(select carrinho_id,sum(total) as total from item group by carrinho_id) as i set c.total = i.total where c.id = i.carrinho_id;

-- A partir do exercicio 11 não consegui resolver até o momento (15/07/21)!!!

