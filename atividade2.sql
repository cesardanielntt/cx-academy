use cxacademy;

create table medico (
id integer primary key auto_increment,
nomemedico varchar (100),
crm varchar (6)
);

create table paciente (
id integer primary key auto_increment,
nomepaciente varchar (100),
cpf varchar (11),
medico_id integer, 
foreign key (medico_id) references medico(id)
);

create table consulta (
id integer primary key auto_increment,
nomeconsulta varchar (100),
datahora varchar (100),
medico_id integer,
foreign key (medico_id) references medico(id)
);


INSERT INTO medico (nomemedico, crm) values ('Dr.Pedro', 'GO7760');

INSERT INTO medico (nomemedico, crm) values  ('Dr.Joao', 'GO7780');

INSERT INTO medico (nomemedico, crm) values  ('Dr.Maria', 'GO7743');

INSERT INTO medico (nomemedico, crm) values ('Dr.Rodrigo', 'GO7654');


select * from medico;

INSERT INTO paciente (nomepaciente, cpf, medico_id) values ('Kelma','66543454345', 1);
INSERT INTO paciente (nomepaciente, cpf, medico_id) values ('Vera','87678765432', 2);
INSERT INTO paciente (nomepaciente, cpf, medico_id) values ('Helena','87987667890', 3);
INSERT INTO paciente (nomepaciente, cpf, medico_id) values ('Bete','45654321214', 4);


select * from paciente;

INSERT INTO consulta (nomeconsulta, datahora, medico_id) values ('Cardiologista', 14.00, 4);
INSERT INTO consulta (nomeconsulta, datahora, medico_id) values ('Nutricionista', 10.10, 3);
INSERT INTO consulta (nomeconsulta, datahora, medico_id) values  ('Ortopedia', 9.10, 2);
INSERT INTO consulta (nomeconsulta, datahora, medico_id) values ('Ginecologista', 11.00, 1);

select * from consulta;

SELECT m.nomemedico, p.nomepaciente, c.nomeconsulta, c.datahora,


