create database ex_hospital;
use ex_hospital;

-- Ex 1
create table paciente(
	id int(11) auto_increment,
    nome varchar(11),
    cpf varchar(11)
);

create table medico(
	id int(11) primary key auto_increment,
    nome varchar(100),
    cm varchar(50)
);

create table consulta(
	id int(11) primary key auto_increment,
    datahora datetime,
    medico_id int(11),
    paciente_id int (11),
    foreign key (medico_id) references medico(id),
    foreign key (paciente_id) references paciente(id)
);


-- Ex 2
insert into paciente (nome, cpf) values ('Ana Clara', '25957441007');
insert into paciente (nome, cpf) values ('Pedro Lopes','04321800013');
insert into paciente (nome, cpf) values ('Joao Lucas','12362912043');
insert into paciente (nome, cpf) values ('Vitor M','65806449076');
insert into paciente (nome, cpf) values ('Matheus R','22323296078');
insert into paciente (nome, cpf) values ('Caio P','41746316039');
insert into paciente (nome, cpf) values ('Milena R','29789507062');
insert into paciente (nome, cpf) values ('Maria E','39661975027');
insert into paciente (nome, cpf) values ('Leticia C','53974596070');
insert into paciente (nome, cpf) values ('Isabella S','48835342007');

insert into medico (nome, cm) values ('Dr Daniel','CMMSP');
insert into medico (nome, cm) values ('Dr Jefferson','CMMRJ');
insert into medico (nome, cm) values ('Dr Ricardo','CMMBH');
insert into medico (nome, cm) values ('Dr Leo','CMMBA');
insert into medico (nome, cm) values ('Dr Osvaldo','CMMSP');
insert into medico (nome, cm) values ('Dra Nicolly','CMMSP');
insert into medico (nome, cm) values ('Dra Sarah','CMMRJ');
insert into medico (nome, cm) values ('Dra Eliza','CMMMG');
insert into medico (nome, cm) values ('Dra Beatriz','CMMMG');
insert into medico (nome, cm) values ('Dra Gertrudes','CMMCE');


insert into consulta (datahora,medico_id,paciente_id) values ('1995-08-21',5,6);
-- Ex 3
select * from paciente;

-- Ex 4
select * from medico;

