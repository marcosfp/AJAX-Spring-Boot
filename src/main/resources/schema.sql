DROP DATABASE IF EXISTS proyecto_ajax;
CREATE DATABASE proyecto_ajax;
USE proyecto_ajax;
CREATE TABLE usuario (
idUsuario BIGINT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(60),
correo VARCHAR(60) UNIQUE
);
