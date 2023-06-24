#query para el trigger de jardineria
DROP DATABASE IF EXISTS jardineria;
CREATE DATABASE jardineria CHARACTER SET utf8;
USE jardineria;

#1
DELIMITER //
DROP PROCEDURE IF EXISTS nomb_pais//
CREATE PROCEDURE nomb_pais(
	IN pais VARCHAR(50)
)
BEGIN
	SELECT * FROM cliente WHERE cliente.pais = pais;
END 
//

DELIMITER;

CALL nomb_pais(@Madrid)

SELECT * FROM WHERE = "Madrid";

#2
DROP PROCEDURE IF EXISTS pagos//
DELIMITER //
CREATE PROCEDURE pagos(
	In forma_pago VARCHAR(40),
	OUT max FLOAT
)
BEGIN
	SET maximo= (SELECT MAX(total) FROM pago WHERE pago.forma_pago=forma_pago);
END 
//

DELIMITER;

CALL pagos('paypa', @maximo);
SELECT @maximo;
#3
DROP PROCEDURE IF EXISTS pagos2//
DELIMITER//
CREATE PROCEDURE pagos2(
	IN nombre varchar(30),
	OUT maximo FLOAT,
	OUT minimo FLOAT,
	OUT media FLOAT,
	OUT suma FLOAT,
	OUT numero_pagos INT
)
BEGIN
    SELECT MAX(total), MIN(total), AVG(total), SUM(total),COUNT(total) AS numero_pagos
    INTO maximo, minimo, media, suma, numero_pagos
    FROM pago WHERE forma_pago=nombre;
END
//

DELIMITER;
CALL pagos2('paypal', @maximo, @mínimo, @media, @suma, @numero_pagos);
SELECT @máximo, @mínimo, @media, @suma, @numero_pagos;)

#4
DELIMITER //
DROP FUNCTION IF EXISTS calcular_precio_total_pedido//
CREATE FUNCTION calcular_precio_total_pedido(
	codigoPedido INT
)
RETURNS FLOAT
DETERMINISTIC
BEGIN
	DECLARE totalPedido FLOAT;

	SELECT SUM(cantidad*precio_unidad) INTO totalPedido
	FROM detalle_pedido WHERE codigo_pedido=codigoPedido;

 RETURN(totalPedido);
END
//
DELIMITER;

SELECT calcular_percio_total_pedido();

#5
DELIMITER //
DROP FUNCTION IF EXISTS calcular_suma_pedidos_cliente//
CREATE FUNCTION calcular_suma_pedidos_cliente
(
	codigoCliente INT
)
RETURNS FLOAT
DETERMINISTIC
BEGIN
DECLARE totalPedidoCliente FLOAT;

 	SELECT SUM(calcular_precio_total_pedido(codigo_pedido)) INTO totalPedidoCliente
	FROM pedido WHERE codigo_cliente = codigoCliente;
	RETURN(totalPedidoCliente);
END
//
DELIMITER 
#6
DELIMITER //
DROP FUNCTION IF EXISTS calcular_suma_pagos_cliente//
CREATE FUNCTION calcular_suma_pagos_cliente
(
	codigoCliente INT
)
RETURNS FLOAT
DETERMINISTIC
BEGIN
	DECLARE totalPagos FLOAT;

	SELECT SUM(total) INTO totalPagos
	FROM pago WHERE codigo_cliente = codigoCliente;

	RETURN(totalPagos);
END
//

SELECT codigo_cliente, total FROM pago WHERE codigo_cliente = 15;
SELECT calcular_suma_pagos_cliente(15);
​
DELIMITER ;
#7  
DELIMITER //
DROP PROCEDURE IF EXISTS proc_calcular_pagos_pendientes//
CREATE PROCEDURE proc_calcular_pagos_pendientes
(
	IN codigoCliente INT,
	OUT cantidadPedida FLOAT,
	OUT cantidadPagada FLOAT
)
BEGIN
	SELECT calcular_suma_pagos_cliente(codigoCliente),
	calcular_suma_pedidos_cliente(codigoCliente) INTO cantidadPagada, cantidadPedida;

 	DROP TABLE IF EXISTS clientes_pagos_pendientes;
	CREATE TABLE clientes_pagos_pendientes (codigo_cliente INT PRIMARY KEY,
	total_pedidos FLOAT, total_pagos FLOAT, pendiente_pago FLOAT);
 	IF cantidadPedida > cantidadPagada THEN
	INSERT INTO clientes_pagos_pendientes
	VALUES (codigoCliente, cantidadPedida, cantidadPagada, (cantidadPedida - cantidadPagada));
	END IF;
END
//
DELIMITER ;

CALL proc_calcular_pagos_pendientes(3, @cantPedida, @cantPagada);
CALL proc_calcular_pagos_pendientes(16, @cantPedida, @cantPagada);
SELECT @cantPedida AS "Pedidos", @cantPagada AS "Pagos";

#8
DELIMITER //
DROP FUNCTION IF EXISTS cantidad_total_de_productos_vendidos//
CREATE FUNCTION cantidad_total_de_productos_vendidos(codigo VARCHAR(10))
RETURNS INT
BEGIN
	DECLARE sumaTotP INT;
	SET sumaTotP = (SELECT SUM(cantidad) FROM detalle_pedido WHERE codigo_producto = codigo);
	RETURN sumaTotP;
END
//
DELIMITER ;
SELECT codigo_producto, cantidad FROM detalle_pedido WHERE codigo_producto = 'OR-227';
SELECT cantidad_total_de_productos_vendidos('OR-227');
    
#9
DELIMITER //
DROP PROCEDURE IF EXISTS obtener_numero_empleados//
CREATE PROCEDURE obtener_numero_empleados(
	IN codigoOf VARCHAR(10),
	OUT numEmp INT
)
BEGIN
	SET numEmp = (SELECT COUNT(codigo_oficina) FROM empleado WHERE codigo_oficina = codigoOf);
END
//
DELIMITER ;
CALL obtener_numero_empleados('BCN-ES', @NEmpleados);
SELECT @NEmpleados AS numEmp;
#10
DROP TABLE IF EXISTS Notificaciones;
CREATE TABLE IF NOT EXISTS Notificaciones(
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	fecha_hora DATETIME,
	toTal NUMERIC(15, 2),
	codiCl INT
);

DELIMITER //
DROP TRIGGER IF EXISTS trigger_notificar_pago//
CREATE TRIGGER trigger_notificar_pago
AFTER INSERT ON pago FOR EACH ROW
BEGIN
	INSERT INTO Notificaciones VALUES(NULL, (SELECT NOW()), NEW.total, NEW.codigo_cliente);
END
//
DELIMITER ;



