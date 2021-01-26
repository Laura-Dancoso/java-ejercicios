CREATE DATABASE Programas;
USE Programas;
CREATE TABLE Programa(
id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
horaEmision TIME NOT NULL,
tipoPrograma INT(11) NOT NULL,
radioEmisora INT(11) NOT NULL,
audiencia INT(11) NOT NULL,
primary key(id)
);
-- select * from Programa;
-- truncate table programa;