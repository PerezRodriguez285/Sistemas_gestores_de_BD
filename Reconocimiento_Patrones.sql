DROP DATABASE IF EXISTS Reconocimiento_Patrones;
CREATE DATABASE Reconocimiento_Patrones;
USE Reconocimento_Patrones;

CRATE TABLE Cliente(

  IdCliente int,
  Nombre int,
  Apellido1 VARCHAR(30),
  Apellido3 VARCHAR(30),
  Ciudad VARCHAR(50),
  Region VARCHAR(50),
  Pais VARCHAR(50),
  Genero VARCHAR(20),
  Edad int,
  Estado_civil VARCHAR(50),
  Nacionalidad VARCHAR(50),
  Fecha_nacimiento VARCHAR(30),
  Cantidad_hijos int,
  Ocupacion VARCHAR(50),
  Escolaridad VARCHAR(30),
  Trabajo VARCHAR(40),
  Firma VARCHAR(256),
  Observaciones TEXT,
  PRIMARY KEY (IdCliente)

);

CREATE TABLE Problema1(

  IdOrden int,
  IdCliente int,
  Respuesta TEXT,
  Firma VARCHAR(256)
  PRIMARY KEY (IdOrden),
  FOREIGN KEY (IdCliente) REFERENCES Problema1(IdOrden)

);

CREATE TABLE Problema2(

  IdOrden int,
  IdCliente int,
  Respuesta TEXT,
  Firma VARCHAR(256),
  PRIMARY KEY (IdOrden),
  FOREIGN KEY (IdCliente) REFERENCES Problema1(IdOrden)

);

CREATE TABLE Problema3(

  IdOrden int,
  IdCliente int,
  Respuesta1 TEXT,
  Respuesta2 TEXT,
  Respuesta3 TEXT,
  Firma VARCHAR(256)
  PRIMARY KEY (IdOrden),
  FOREIGN KEY (IdCliente) REFERENCES Problema1(IdOrden)

);
