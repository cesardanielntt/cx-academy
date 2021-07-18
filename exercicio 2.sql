create table medico (
id integer primary key auto_increment,
nome varchar(20),
crm varchar(6)
 );

create table paciente (
id integer primary key auto_increment,
nome varchar(20),
cpf varchar(11)
);

create table consulta (
id integer primary key auto_increment,
datahora datetime,
medico_id integer,
foreign key (medico_id) references medico(id),
paciente_id integer,
foreign key (paciente_id) references paciente(id)
);


insert into paciente(nome, cpf)
values ('Leandro Rocha', '123456'),('Ivo Gomes', '98764'),('Murillo Santos','43311'); 

insert into medico(nome, crm)
values ('Cristiane souza', '1524'),('Henrique Farias', '867342'),('Brenda Pinoti', '34251');

insert into consulta(datahora, medico_id, paciente_id)
values ('2021-07-15 08:30:00', 1, 2),('2021-07-15 09:00:00', 3, 3),('2021-07-15 09:30:00', 2, 4);

select * from consulta;
select * from paciente;
select * from medico; 

select p.nome, m.nome from paciente p 
join medico m on m.id = p.id;
