IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='usuarios' and xtype='U')

create table usuarios(
id BIGINT not null IDENTITY(1,1) PRIMARY KEY,
nome varchar(45) not null,
sobrenome varchar(45) not null,
email varchar(45) not null,
senha varchar(45) not null,
cod_status_usuario bit null,
data_nascimento DATE,
unique(email)
)