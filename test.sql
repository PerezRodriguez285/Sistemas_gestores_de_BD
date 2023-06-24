#PASO 1
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

#PASO2
CREATE TABLE alumnos(
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20),
	apellido1 VARCHAR(20),
	apellido2 VARCHAR(20),
	nota FLOAT
);


#paso3
DELIMITER //
DROP TRIGGER IF EXISTS trigger_check_nota_before_insert//

DELIMITER//
CREATE TRIGGER trigger_check_nota_before_insert
BEFORE INSERT
ON alumnos FOR EACH ROW
BEGIN
	IF NEW.nota < 0 THEN
		set NEW.nota = 0;
	ELSEIF NEW.nota > 10 THEN
	set NEW.nota = 10;
	END IF;
END
//

DELIMITER //
DROP TRIGGER IF EXISTS trigger_checkNota__B_update//
CREATE TRIGGER trigger_checkNota_B_update
BEFORE UPDATE ON alumnos FOR EACH ROW
BEGIN
	IF new.nota < 0 THEN
		set new.nota = 0;
	ELSEIF new.nota > 10 THEN
	set new.nota = 10;
	END IF;
END
//

#PASO 4

INSERT INTO alumnos VALUES (1, 'Leonardo', 'Villanueva', 'Medina', 7.7);
INSERT INTO alumnos Values (2, 'Tania', 'Del Angel' ,'Hernandez', 10);
INSERT INTO alumnos VALUES (3,'Carmelo','Diaz','Diaz',6.9);
INSERT INTO alumnos VALUES (4, 'Alejandro', 'Rios', 'Sanchez', 9.7);
INSERT INTO alumnos Values (5, 'Pancho', 'Trujillo' ,'Gonzalez', -10);
#paso 5
SELECT * FROM alumnos;

#paso 6
UPDATE alumnos SET nota = -4 WHERE id = 3;
UPDATE alumnos SET nota = 10 WHERE id = 2;
UPDATE alumnos SET nota = 9.7 WHERE id = 4;

#TRIGGERS 2
DROP DATABASE IF EXISTS test1;
CREATE DATABASE test1;
USE test1;

CREATE TABLE alumnos(
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20),
	apellido1 VARCHAR(20),
	apellido2 VARCHAR(20),
	email VARCHAR(50)
);

#PROCEDIMINETO
DELIMITER //
DROP PROCEDURE IF EXISTS crear_email//
CREATE PROCEDURE crear_email(
	IN nombre VARCHAR(20),
	IN apellido1 VARCHAR(20),
	IN apellido2 VARCHAR(20),
	OUT dominio VARCHAR(20)
)
BEGIN 
	DECLARE nombre INT;
	DECLARE apellido1 VARCHAR(10);
	
	SELECT "nombre: ", nombre, "apellido1", apellido1, "apellido2", apellido2, "dominio", dominio as MENSAJE;
	SELECT concat("nombre: ", nombre, "apellido1", apellido1, "apellido2", apellido2, "dominio", dominio) as MENSAJE;
END
//

create trigger actualizar_alumnos
after update on alumnos for each row
insert into alumnos(
	nomAnt, apellido1Ant, apellido2Ant, emailAnt,
	nombre, apellido1, apellido2, nota, id)
values(
	OLD.nombre, OLD.apellido1, OLD.apellido2, OLD.nota, 
	NEW.nombre, NEW.apellido1, NEW.apellido2, NEW.nota,
	USER(), NOW(), 'Dato Actualizado', NEW.id);

create trigger agregar_alumnos
after insert on alumnos for each row
insert into auditoria_productos(
	nomNew, cantNew, marNew, preNew,
	nombre, apellido1, apellido2, nota, id)
values(
	NEW.nombre, NEW.cantidad, NEW.marca, NEW.precio,
	USER(), NOW(), 'Dato Insertado', NEW.idproductos);

create trigger eliminar_alumnos
after delete on alumnos for each row
insert into auditoria_productos(
	nomAnt, cantAnt, marAnt, preAnt,
	nombre, apellido1, apellido2, nota, id)
values(
	OLD.nombre, OLD.cantidad, OLD.marca, OLD.precio,
	USER(), NOW(), 'Dato Eliminado', OLD.idproductos);
