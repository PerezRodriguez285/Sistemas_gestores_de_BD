--1
USE jardineria;
DELIMITER //
DROP PROCEDURE IF EXISTS prcedimiento1//
CREATE PROCEDURE prcedimiento1(IN nombre VARCHAR(120))
BEGIN
    SELECT * FROM cliente WHERE cliente.pais = nombre;
END
//
CALL procedimiento1('USA')//
--2
DELIMITER //
DROP PROCEDURE IF EXISTS procedimiento2//
CREATE PROCEDURE procedimiento2(IN nombre varchar(30))
BEGIN
    SELECT MAX(total) AS pago_maximo FROM pago WHERE forma_pago=nombre;
END
//
DELIMITER ;

CALL procedimiento2("PayPal");
--3
DELIMITER //
DROP PROCEDURE IF EXISTS //
CREATE PROCEDURE eprocedimiento3(IN nombre varchar(30))
BEGIN
    SELECT MAX(total) AS pago_max,MIN(total) AS pago_min,AVG(total) AS valor_medio,SUM(total) AS suma_total,COUNT(total) AS numero_pagos
    FROM pago WHERE forma_pago=nombre;
END
//
DELIMITER ;
--mostramos
CALL procedimiento3("PayPal");
--4