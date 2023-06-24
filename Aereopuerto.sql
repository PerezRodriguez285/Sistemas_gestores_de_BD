CREATE DATABASE Aereopuerto;

USE Aereopuerto;

CREATE TABLE Aereopuerto(
    Id_aereopuerto int,
    nombre varchar(10),
    ciudad varchar(10),
    No. pista varchar(10),
    Direccion varchar(10),
    Primary key(Id_aereopuerto));

CREATE TABLE Rutas_aereas(
	id_ruta int,
	avion usado varchar(10),
	Direccion_origen varchar(50),
	Direccion_destino varchar(50),
	Hrs_viaje date time,
	Id_aereopuerto int,
	Rutas_aereas varchar(100),
	Foreign key (Id_aereopuerto) references Aereopuerto(Id_aereopuerto),
	Primary key (id_ruta));

CREATE TABLE Aviones(
	id_avion int,
	modelo varchar(10),
	Fecha_Ultima_Inspeccion date time,
	Km_recorridos int,
	No_Max_Pasajeros int,
	Tripulacion varchar(100),
	id_ruta int,
	Foreign key (id_ruta) references Rutas_aereas(id_ruta),
	Primary key (id_avion));

CREATE TABLE Empleado(
	Id_empleado int,
	Nombre varchar(10),
	ApPaterno varchar(10),
	ApMaterno varchar(10),
	RFC int,
	Telefono int
	Idioma varchar(10),
	Tipo_de_trabajo varchar(10),
	Primary key (Id_empleado));

CREATE TABLE Nacionalidad(
	Nacionalidad int,
	Primary key (Nacionalidad));

CREATE TABLE Continental(
	Continente varchar(100),
	Paises_con_permisos varchar(10),
	Nacionalidad varchar(40),
	Foreign key (Nacionalidad) references Compañias_aereas(Nacionalidad));

CREATE TABLE Internacional(
	Controles_Supervisados varchar(100),
	Fecha_control date time,
	Paises_que_no_operan varchar(100),
	Nacionalidad varchar(40),
	Foreign key (Nacionalidad) references Compañias_aereas(Nacionalidad));

CREATE TABLE Nacional(
	id_pais int,
	Pais varchar(100),
	permisos varchar(10),
	Modelo_avion varchar(100),
	Nacionalidad varchar(40),
	Foreign key (Nacionalidad) references Compañias_aereas(Nacionalidad));

CREATE TABLE Piloto(
	RFC int,
	Nombre varchar(10),
	Rutas_aerea varchar(100),
	Primary key (Rutas_aerea));

CREATE TABLE OpTierra(
	Encargado varchar(10),
	Tareas varchar(100));

CREATE TABLE OpAire(
	Encargado varchar(10),
	Tareas varchar(100));

CREATE TABLE Compañias_aereas(
	id int,
	RFC int,
	Nombre varchar(30),
	Oficial_de_compania varchar(30),
	Telefonos int,
	Direccion varchar(100),
	Nacionalidad varchar(40),
	Id_empleado int,
	id_avion int,
	No_vuelos int,
	Foreign key (id_avion) references Aviones(id_avion),
	Foreign key (Id_empleado) references Empleado(Id_empleado),
	Primary key (id));


