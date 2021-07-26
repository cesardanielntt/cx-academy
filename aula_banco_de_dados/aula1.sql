-- ----------------------------------------------------- --
-- Arquivo para armazenar todos os scripts SQL da aula 1 --
-- ----------------------------------------------------- --

--  Francisco Ramon Da Silva Holanda  --

create database if not exists cxacademy;
use cxacademy;

create table estado (
	id integer primary key auto_increment,
    uf varchar(2),
    nome varchar(100)
);

create table cidade (
	id integer primary key auto_increment,
    nome varchar(100),
    estado_id integer,
    foreign key (estado_id) references estado(id)
);

insert into estado(uf, nome) values
	('PI', 'piauí'),
    ('SP', 'são paulo'),
    ('RJ', 'Rio de Janeiro'),
    ('MG', 'Minas Gerais'),
    ('SC', 'Santa Catarina'),
    ('AM', 'Amazonas');


insert into cidade(nome, estado_id) values
	('picos', 1),
    ('são sebastião', 3),
    ('Maceió', 3),
    ('Sorocaba', 6),
    ('Cuiabá', 5),
    ('Niterói', 3);
    
select * from estado;

select e.uf, e.nome, c.nome from estado e
join cidade c on e.id = c.estado_id;





-- parte 2

create table paciente (
	id integer primary key auto_increment,
    nome varchar(100),
    cpf varchar(11)
);

create table medico (
	id integer primary key auto_increment,
    nome varchar(100),
    cm varchar(50)
);

create table consulta (
	id integer primary key auto_increment,
    data_hora datetime,
    medico_id int(11),
    paciente_id int(11),
    foreign key(medico_id) references medico(id),
    foreign key(paciente_id) references paciente(id)
);

insert into paciente(nome, cpf) values
	("César", "12345678"),
    ("Paulo", "1247555"),
    ("Amanda", "865716");
    
insert into medico(nome, cm) values 
	("Henrique", "Sua Saúde"),
    ("Oscar", "Boa Vida"),
    ("Jaqueline", "Good Life");
    
insert into consulta(data_hora, paciente_id, medico_id) values
	("2021-07-25 14:00", 1, 3),
    ("2021-07-28 15:00", 3, 2),
    ("2021-08-01 09:00", 2, 3),
    ("2021-08-10 12:00", 3, 2),
    ("2021-08-15 17:00", 1, 2),
    ("2021-08-30 16:00", 2, 1);

select * from paciente;
select * from medico;

-- lista pacientes de acordo com os médicos
select p.nome as "Pacientes", p.cpf, m.nome as "Médico", m.cm "Clinica Médica" from paciente p
join consulta c on p.id = c.paciente_id 
join medico m on m.id = c.medico_id;

-- lista médicos de acordo com os pacientes
select m.nome as "Médico", m.cm "Clinica Médica", p.nome as "Pacientes", p.cpf from medico m
join consulta c on m.id = c.medico_id 
join paciente p on p.id = c.paciente_id;


-- lista os médicos e o número de seus respectivos pacientes
select m.nome, m.cm as 'Clinica Médica', count(p.id) as "Número de Pacientes" from medico m
join consulta c on m.id = c.medico_id
join paciente p on p.id = c.paciente_id
group by (m.id);







