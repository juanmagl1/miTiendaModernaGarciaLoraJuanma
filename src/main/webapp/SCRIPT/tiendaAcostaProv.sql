SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database tiendaAcosta;

--CREACION DE TABLAS--

--LOGICA EXTRA--

--INSERTS--

create user 'acosta'@'%' identified by 'felipe';
grant all privileges on tiendaAcosta.* to 'acosta'@'%';