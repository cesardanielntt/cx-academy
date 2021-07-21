CREATE TABLE paciente (  -- thales assis --
	id int primary key auto_increment ,
	nome_paciente varchar (50),
    cpf varchar (11)
);

create table medico (
	id int primary key auto_increment,
    nome_medico varchar (20),
    crm varchar (50)
    );
    
create table consulta (
    id int primary key auto_increment,
    datahora datetime,
    medico_id int(11),
    paciente_id int(11),
    foreign key (medico_id) references medico(id),
    foreign key (paciente_id) references paciente(id)
    
    
    );
    select * from paciente;
    insert into paciente (nome_paciente, cpf) values ('julia', '08550092911'), ('joao', '55953187425'), ('thales', '12345678910'), ('rafael', '98765432109')
    
    ;select * from medico;
    insert into medico (nome_medico, crm) values ('marcos junior', '12345678901'), ('ana julia', '98765432105'), ('leandro vasconscelos', '12345678900'), ('renata nunes', '98765432189')
    ;
    select * from consulta;
    insert into consulta (datahora) values (sysdate()), (sysdate()), (sysdate()), (sysdate())
    ; 
    -- nao consegui relacionar o id do medico com o medico_id (nao sei o porque, achei que ao usar o ''foreign key (medico_id) references medico(id)'' isso seria feiro automaticamente). 
    -- portanto, nao consegui seguir com a realizaçao dos outros passos :(