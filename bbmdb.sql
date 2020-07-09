-- criar base de dados
create database bbmdb;
-- Usar uma base de dados
use bbmdb;
-- criar uma tabela
create table tbusuario(
idusuer int primary key,
usuario varchar(50) not null,
cell varchar(15),
login varbinary(15) not null unique,
senha varchar(15)not null
);

-- descrever tabela
describe tbusuario;

-- inserir dados na tabela
insert into tbusuario(idusuer, usuario, cell, login, senha)
values(1, 'Belmiro Mungoi', '+258840000000', 'belmiro', '123456');

-- exibir dados da tabela
select * from tbusuario;

insert into tbusuario(idusuer, usuario, cell, login, senha, perfil)
values(2, 'Denver Ralph', '+258840000001', 'denral', 'iamdog', 'normal');

insert into tbusuario(idusuer, usuario, cell, login, senha)
values(3, 'Administrador', '+258840000002', 'admin', 'admin');

-- modificar dados na tabela
update tbusuario set cell = '+258840000911' where idusuer = '2';

-- apagar um registo da tabela
delete from tbusuario where idusuer = '2';

create table tbclientes(
idcliente int primary key auto_increment,
nomecliente varchar(50) not null,
endercliente varchar(65),
cellcliente varchar(50) not null,
emailcliente varchar(50)
);

describe tbclientes;

insert into tbclientes(nomecliente, endercliente, cellcliente, emailcliente)
values('Naira Silva', 'Matola, Bairro liberdade, Rua cris', '+258840020011', 'naira@silva.com');

insert into tbclientes(nomecliente, endercliente, cellcliente, emailcliente)
values('Kelly da Silva', 'Matola, Bairro Huncho, Rua Nenny', '+258840010012', 'kellyda@lucky.com');

select * from tbclientes;

create table tbos(
os int primary key auto_increment,
data_os timestamp default current_timestamp,
equipamento varchar(150) not null,
defeito varchar(100) not null,
servico varchar(100),
tecnico varchar(50),
valor decimal(10, 2),
idcliente int not null,
foreign key(idcliente) references tbclientes(idcliente)
);

describe tbos;

insert into tbos(equipamento, defeito, servico, tecnico, valor, idcliente)
values('LapTop', 'Processador queimado', 'Troca de processador', 'Lucas Junior', 2500.50, 1);

insert into tbos(equipamento, defeito, servico, tecnico, valor, idcliente)
values('Monitor', 'Tela quebrada', 'Troca da tela', 'Carla Sitoe', 1000.99, 2);

select * from tbos;

-- juntar informacoes de duas tabelas
select
Ordem.os, equipamento, defeito, servico, tecnico, valor,
Cliente.nomecliente, cellcliente, emailcliente
from tbos as Ordem
inner join tbclientes as Cliente
on (Ordem.idcliente = Cliente.idcliente);

select * from tbusuario where login = "admin" and senha = "admin";

select * from tbusuario;

alter table tbusuario add column perfil varchar(20) not null;
alter table tbusuario add column biuser varchar(15) not null after usuario;

update tbusuario set biuser = '100231289339M' where idusuer = 1; 
update tbusuario set biuser = '100121289229B' where idusuer = 2;
update tbusuario set biuser = '100331288653B' where idusuer = 3;
update tbusuario set biuser = '100521280986J' where idusuer = 4;












