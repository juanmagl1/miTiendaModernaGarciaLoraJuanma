SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database tiendaAcosta;

--CREACION DE TABLAS--

CREATE TABLE usuario(
	id int AUTO_INCREMENT,
	nombre varchar(30),
	apellidos varchar(30),
	fecha date,
	genero varchar(2),
	
	constraint pk_usuario primary key (id)
)

create table categoria(
	id int AUTO_INCREMENT,
	nombre varchar(30),
	descripcion varchar(100),
	
	constraint pk_categoria primary key (categoria)
)

CREATE TABLE elemento(
	id int AUTO_INCREMENT,
	nombre varchar(30),
	descripcion varchar(100),
	precio double,
	id_categoria int,
	
	constraint pk_elemento primary key (id),
	constraint fk_elemento_categoria foreign key (id_categoria) references categoria(id)
)

create table compra(
	id_user int,
	id_elemento int,
	cantidad int,
	precio double,
	fecha date,
	
	constraint pk_compra primary key (id_usuario),
	constraint fk_compra_usuario foreign key (id_user) references usuario(id),
	constraint fk_compra_elemento foreign key (id_elemento) references elemento(id)
)

--LOGICA EXTRA--

--INSERTS--

create user 'acosta'@'%' identified by 'felipe';
grant all privileges on tiendaAcosta.* to 'acosta'@'%';