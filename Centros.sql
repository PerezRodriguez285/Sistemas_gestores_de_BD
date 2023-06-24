CREATE DATABASE Centros;

USE Centros;

CREATE TABLE Alumnos(
	Identificador int,
	Nombre varchar(20),
	ApPaterno varchar(20),
	ApMaterno varchar(20),
	Fecha_nacimiento datetime,
	Telefono int,
	Edad int,
	Fecha_inicio date,
	Fecha_termino date,
	Matricula int,
	Tutoria varchar(20),
	Tutor varchar(20),
	Id_tutoria int,
	Primary key (Identificador));

CREATE TABLE Centros_Universitarios(
	Codigo_identificacion int,
	Nombre varchar(20),
	Direccion varchar(50),
	Contrato varchar(100),
	Id_trabajador int,
	Matricula int,
	Identificador int,
	Foreign key (Id_trabajador) references Trabajador(Id_trabajador),
	Foreign key (Identificador) references Alumnos(Identificador),
	Primary key (Codigo_identificacion));

CREATE TABLE Trabajador(
	Id_trabajador int,
	Nombre varchar(20),
	ApPat varchar(20),
	ApMat varchar(20),
	Telefonos int,
	Cuenta_corriente varchar(20),
	Contrato varchar(100),
	Tipo_de_trabajo varchar(50),
	Primary key (Id_trabajador));

CREATE TABLE Administrativo(
	Id int,
	Hora_entrada datetime,
	Hora_salida datetime,
	Salario float,
	Vacaciones varchar(20),
	Telefono int,
	Correo varchar(30),
	Primary key (Id));

CREATE TABLE Personal_de_Apoyo(
	Id int,
	Horario datetime,
	Sueldo float,
	No_movil int,
	Primary key (Id));

CREATE TABLE Profesor(
	Id int,
	No_cubiculo int,
	Horario datetime,
	Salario float,
	Primary key (Id));

CREATE TABLE Tutoria(
	Nombre_de_la_tutoria varchar(20),
	Id int,
	Profesor varchar(30),
	No_alumnos int,
	Fecha_inicio date,
	Fecha_termino date,
	Id_Tutoria int,
	Foreign key (Id) references Profesor (Id),
	Primary key (Id_Tutoria));

