CREATE DATABASE ej2_empleados;

USE ej2_empleados;

CREATE TABLE EMPLEADO(
    DNI int PRIMARY KEY,
    NOMBRE varchar(20),
    APELLIDOUNO varchar(20),
    APELLIDODOS varchar(20),
    FECHA_NAC varchar(15),
    DIRECCION varchar(15),
	SEXO varchar(5),
	SUELDO float,
	SUPER_DNI int,
	DNO int,
	FOREIGN KEY (SUPER_DNI) REFERENCES EMPLEADO(DNI)
);

CREATE TABLE DEPARTAMENTO(
    NumeroDpto int PRIMARY KEY,
    NombreDpto varchar (20),
	DniDirector int,
	FechaIngresoDirector varchar(20),
	FOREIGN KEY (DniDirector) REFERENCES EMPLEADO(DNI)
);

ALTER TABLE EMPLEADO ADD FOREIGN KEY (DNO) REFERENCES DEPARTAMENTO(NumeroDpto);

CREATE TABLE LOCALIZACIONES_DPTO(
	NumeroDpto int,
	UbicacionDpto varchar (20),
	FOREIGN KEY (NumeroDpto) REFERENCES DEPARTAMENTO(NumeroDpto)
);

ALTER TABLE LOCALIZACIONES_DPTO ADD PRIMARY KEY (NumeroDpto, UbicacionDpto);

CREATE TABLE PROYECTO(
    NumProyecto int PRIMARY KEY,
    NombreProyecto varchar(20),
	UbicacionProyecto varchar(20),
	NumDptoProyecto int,
	FOREIGN KEY (NumDptoProyecto) REFERENCES DEPARTAMENTO (NumeroDpto)
);

CREATE TABLE TRABAJA_EN(
	DniEmpleado int,
	NumProy int,
	Horas float,
    PRIMARY KEY(DniEmpleado, NumProy),
	FOREIGN KEY (DniEmpleado) REFERENCES EMPLEADO(DNI),
	FOREIGN KEY (NumProy) REFERENCES PROYECTO(NumProyecto)
);

CREATE TABLE  SUBORDINADO(
	DniEmpleado int,
	NombSubordinado varchar(20),
	Sexo varchar(5),
	FechaNac varchar(20),
	Relacion varchar(20),
	FOREIGN KEY (DniEmpleado) REFERENCES EMPLEADO (DNI)
);

ALTER TABLE SUBORDINADO ADD PRIMARY KEY (DniEmpleado, NombSubordinado);
