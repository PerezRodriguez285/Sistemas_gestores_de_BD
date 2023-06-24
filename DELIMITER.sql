USE DELIMITER;

DELIMITER //
CREATE PROCEDURE proc_Mensaje
BEGIN 
	SELECT concat("Procedimiento: Hola mundo") AS mensajes;
END
//

DELIMITER;

#Ejercicio 1 PDF TRIGGERS
DELIMITER //
CREATE PROCEDURE proc_Mensaje1()
BEGIN
	SELECT 'Hola mundo SQL' AS MENSAJE;
END
//

DELIMITER;
#Ejercicio 2
DELIMITER //
DROP PROCEDURE IF EXISTS proc2//
CREATE PROCEDURE proc2(
	num FLOAT
)
BEGIN
	DECLARE mensaje VARCHAR(30);
	IF num = 0.0 THEN
		SET mensaje = " es cero";
	ELSEIF num > 0.0 THEN
		SET mensaje = "Es positivo";
	ELSE
		SET mensaje = 'Es Negativo';
	END IF;
	SELECT "Numero ", num , mensaje AS MENSAJE;
	SELECT concat("Numero ", num, mensaje) as MENSAJE;
END
//
DELIMITER;

#llamar a la consola
CALL proc2(30); #y asi sucecivamente

#EJERCICIO 3
DELIMITER //
DROP PROCEDURE IF EXISTS proc3//
CREATE PROCEDURE proc3(
	IN num FLOAT,
	OUT mensaje VARCHAR(30)
)
BEGIN
	DECLARE mensaje VARCHAR(30);
	IF num = 0.0 THEN
		SET mensaje = " es cero";
	ELSEIF num > 0.0 THEN
		SET mensaje = " Es positivo";
	ELSE
		SET mensaje = " Es Negativo";
	END IF;
	SELECT "Numero ", num , mensaje AS MENSAJE;
	SELECT concat("Numero ", num, mensaje) as MENSAJE;
END
//
DELIMITER;

CALL proc3(-40, @mensaje);

#ejercicio 4
DELIMITER //
DROP PROCEDURE IF EXISTS proc4//
CREATE PROCEDURE proc4(
nota FLOAT
)
BEGIN
	DECLARE mensaje VARCHAR(20);
	CASE
		WHEN nota = 9 or nota = 10 THEN
			SET mensaje = "Sobresaliente";
		WHEN nota >=7 and nota <9 THEN
			SET mensaje = "Notable";
		WHEN nota >=6 and nota <7 THEN
			SET mensaje = "Bien";
		WHEN nota >=5 and nota <6 THEN
			SET mensaje = "Aprobado";
		WHEN nota >=0 and nota <5 THEN
			SET mensaje = "Insuficiente";
		ELSE
			SET mensaje = "Nota no valida";
		END CASE;
		SELECT nota AS CALIF, mensaje AS MENSAJE;
END
//

DELIMITER;
CALL proc4(40);

#ver la rutina de los triggers
WHERE ROUTINE_SCHEMA='testTriggers';

#BORRAR PROCEDIMIENTO
DROP PROCEDURE IF EXISTS proc_Mensaje;

#MOSTREMOS EL PROCEDIMIENTO CON EL QUE ESTAMOS TRABAJANDO


SELECT ROUTINE_SCHEMA, ROUTIME_NAME, ROUTINE_TYPE, ROUTINE_DEFINITION FROM information_schema.routines WHERE ROUTINE_SCHEMA='jardineria\G';