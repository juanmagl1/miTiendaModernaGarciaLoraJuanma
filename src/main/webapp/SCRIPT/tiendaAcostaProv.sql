SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database tiendaAcosta;

use tiendaAcosta;

CREATE TABLE usuario(
	nombre varchar(30),
	apellidos varchar(30),
	password varchar(30),
	fecha date,
	genero varchar(30),
	
	constraint pk_usuario primary key (nombre)
);

create table categoria(
	id int AUTO_INCREMENT,
	nombre varchar(30),
	descripcion varchar(100),
	
	constraint pk_categoria primary key (id)
);

CREATE TABLE elemento(
	id int AUTO_INCREMENT,
	nombre varchar(30),
	descripcion varchar(100),
	precio double,
	id_categoria int,
	
	constraint pk_elemento primary key (id),
	constraint fk_elemento_categoria foreign key (id_categoria) references categoria(id)
);

create table compra(
	id int AUTO_INCREMENT,
	id_user varchar(30),
	id_elemento int,
	cantidad int,
	precio double,
	fecha date,
	
	constraint pk_compra primary key (id),
	constraint fk_compra_usuario foreign key (id_user) references usuario(nombre),
	constraint fk_compra_elemento foreign key (id_elemento) references elemento(id)
);

insert into usuario (nombre, apellidos, password, fecha, genero) values ('felipe','felipe', 'felipe', '11/11/2021', 'Female');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Madison','felipe', 'felipe', '11/29/2021', 'Male');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Terencio','felipe', 'felipe', '07/27/2021', 'Bigender');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Cora','felipe', 'felipe', '10/15/2022', 'Female');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Filmore','felipe', 'felipe', '10/07/2020', 'Genderqueer');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Haleigh','felipe', 'felipe', '11/29/2019', 'Male');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Lefty','felipe', 'felipe', '03/16/2022', 'Male');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Rhys','felipe', 'Wilford', '07/16/2022', 'Male');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Kary','felipe', 'Twigge', '01/11/2021', 'Female');
insert into usuario (nombre, apellidos, password, fecha, genero) values ('Heather','felipe', 'Hellwing', '12/22/2021', 'Female');

insert into categoria (id, nombre, descripcion) values (1, 'CAT1', 'scelerisque');
insert into categoria (id, nombre, descripcion) values (2, 'CAT2', 'varius');
insert into categoria (id, nombre, descripcion) values (3, 'CAT3', 'rhoncus');

insert into elemento (id, nombre, descripcion, precio, id_categoria) values (1, 'Elfreda', 'sit', 71.87, 1);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (2, 'Elston', 'quam turpis adipiscing', 56.17, 1);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (3, 'Tallulah', 'consequat', 33.43, 3);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (4, 'Brittaney', 'in lacus curabitur', 62.25, 2);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (5, 'Godfrey', 'quam pharetra magna', 64.77, 3);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (6, 'Lucina', 'malesuada', 24.29, 3);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (7, 'Fan', 'nunc', 99.88, 2);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (8, 'Candra', 'semper interdum mauris', 43.01, 1);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (9, 'Faulkner', 'tristique in tempus', 22.01, 3);
insert into elemento (id, nombre, descripcion, precio, id_categoria) values (10, 'Torrance', 'ut nunc vestibulum', 53.84, 2);

insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('felipe', 8, 57, 15.6, '2020-12-27');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('felipe', 8, 75, 31.85, '2021-03-28');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('felipe', 4, 6, 61.69, '2020-03-19');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('Cora', 2, 61, 96.43, '2020-09-07');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('Cora', 5, 3, 91.91, '2020-05-18');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('Cora', 1, 76, 99.5, '2020-11-26');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('felipe', 4, 90, 62.35, '2020-10-12');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('Cora', 3, 78, 80.56, '2022-10-06');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('felipe', 6, 5, 89.98, '2020-12-25');
insert into compra (id_user, id_elemento, cantidad, precio, fecha) values ('Cora', 5, 47, 48.09, '2020-05-24');

grant all privileges on tiendaAcosta.* to 'acosta'@'%' identified by 'felipe';