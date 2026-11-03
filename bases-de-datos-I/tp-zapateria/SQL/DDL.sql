DROP DATABASE IF EXISTS tpbdd;
CREATE DATABASE TPBDD;
USE TPBDD;
DROP TABLE IF EXISTS tiene_talle;
DROP TABLE IF EXISTS contiene;
DROP TABLE IF EXISTS asiste;
DROP TABLE IF EXISTS provee;
DROP TABLE IF EXISTS vendedor;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS dia;
DROP TABLE IF EXISTS mprovee;
DROP TABLE IF EXISTS mayorista;
DROP TABLE IF EXISTS minorista;
DROP TABLE IF EXISTS venta;
DROP TABLE IF EXISTS franco;
DROP TABLE IF EXISTS auditoria_zapato_precio;


CREATE TABLE vendedor(
	dni_vendedor INT NOT NULL,
	nro_vendedor INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	direccion VARCHAR(100) NOT NULL,

	CONSTRAINT pk_vendedor PRIMARY KEY(dni_vendedor),
	UNIQUE (nro_vendedor)
);

CREATE TABLE dia(
	nombre_dia VARCHAR(50) NOT NULL,
	
	CONSTRAINT pk_dia PRIMARY KEY(nombre_dia)
);

CREATE TABLE proveedor(
	cuit BIGINT NOT NULL,
	razon_social VARCHAR(100) NOT NULL,
	direccion VARCHAR(100) NOT NULL,
	telefono_fijo INT NOT NULL,
	
	CONSTRAINT pk_proveedor PRIMARY KEY(cuit)
);

CREATE TABLE mproveedor(
	cuit BIGINT NOT NULL,
	celular INT NOT NULL,
	
	CONSTRAINT fk_proveedor FOREIGN KEY (cuit) REFERENCES proveedor(cuit)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE zapato(
	color VARCHAR(100) NOT NULL,
	modelo VARCHAR(100) NOT NULL,
	
	CONSTRAINT pk_zapato PRIMARY KEY(color, modelo)

);

CREATE TABLE talle(
	nro_talle INT NOT NULL,
	
	CONSTRAINT pk_talle PRIMARY KEY(nro_talle)
);

CREATE TABLE cliente(
	dni INT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	direccion VARCHAR(100) NOT NULL,
	
	CONSTRAINT pk_cliente PRIMARY KEY(dni)
);

CREATE TABLE mayorista(
	dni INT NOT NULL,
	descuento_general FLOAT NOT NULL,
	
	CONSTRAINT check_descuento2 CHECK (descuento_general >= 0 AND descuento_general < 100),
	
	CONSTRAINT fk_cliente FOREIGN KEY(dni) REFERENCES cliente(dni)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE minorista(
	dni INT NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	
	CONSTRAINT fk_cliente_minorista FOREIGN KEY(dni) REFERENCES cliente(dni)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE venta(
	nro_factura INT NOT NULL,
	monto FLOAT NOT NULL,
	fecha DATE NOT NULL,
	dni INT NOT NULL,
	dni_vendedor INT NOT NULL,
	porcentaje_descuento FLOAT NOT NULL,
	
	CONSTRAINT pk_venta PRIMARY KEY(nro_factura),
	CONSTRAINT fk_vendedor FOREIGN KEY (dni_vendedor) REFERENCES vendedor(dni_vendedor) 
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT fk_cliente_venta FOREIGN KEY (dni) REFERENCES cliente(dni)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT check_descuento1 CHECK (porcentaje_descuento >= 0 AND porcentaje_descuento < 100)
);

CREATE TABLE franco(
	nro_franco INT NOT NULL,
	observaciones VARCHAR(100) NOT NULL,
	fecha DATE NOT NULL,
	dni_vendedor INT NOT NULL, 

	CONSTRAINT pk_franco PRIMARY KEY(nro_franco),
	CONSTRAINT fk_vendedor_franco FOREIGN KEY (dni_vendedor) REFERENCES vendedor(dni_vendedor)
	ON DELETE CASCADE
	ON UPDATE CASCADE
	
);


CREATE TABLE tiene_talle(
	color VARCHAR(100) NOT NULL,
	modelo VARCHAR(100) NOT NULL,
	nro_talle INT NOT NULL,
	cantidad INT NOT NULL,
	precio FLOAT NOT NULL,
	
	CONSTRAINT tiene_talle PRIMARY KEY (color, modelo, nro_talle),
	
	CONSTRAINT fk_zapato FOREIGN KEY (color,  modelo) REFERENCES zapato(color, modelo)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT fk_talle FOREIGN KEY(nro_talle) REFERENCES talle(nro_talle)
	ON DELETE CASCADE
	ON UPDATE CASCADE

);

DELIMITER $$

CREATE TRIGGER trigger_auditoria
AFTER UPDATE ON tiene_talle 
FOR EACH ROW
BEGIN 
	IF OLD.precio <> NEW.precio THEN	
		INSERT INTO auditoria_zapato_precio(fecha, precio_viejo, precio_nuevo, usuario)
		VALUES(NOW(), OLD.precio, NEW.precio, USER());
	END IF;
END$$

DELIMITER ;

CREATE TABLE contiene(
	color VARCHAR(100) NOT NULL,
	modelo VARCHAR(100) NOT NULL,
	nro_talle INT NOT NULL,
	nro_factura INT NOT NULL,
	precio_venta FLOAT NOT NULL,
	cantidad_venta INT NOT NULL,
	
	CONSTRAINT pk_contiene PRIMARY KEY (nro_factura, color, modelo, nro_talle),
	
	CONSTRAINT fk_zapato_contiene FOREIGN KEY (color, modelo) REFERENCES zapato(color, modelo)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT fk_talle_contiene FOREIGN KEY(nro_talle) REFERENCES talle(nro_talle)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT fk_venta_contiene FOREIGN KEY (nro_factura) REFERENCES venta(nro_factura)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT check_precio CHECK (precio_venta < 200000)
);

CREATE TABLE asiste(
	dni_vendedor INT NOT NULL,
	nombre_dia VARCHAR(100) NOT NULL,
	hora_entrada TIME NOT NULL,
	hora_salida TIME NOT NULL,
	
	CONSTRAINT pk_asiste PRIMARY KEY (dni_vendedor, nombre_dia),
	
	CONSTRAINT fk_vendedor_asiste FOREIGN KEY (dni_vendedor) REFERENCES vendedor(dni_vendedor) 
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT fk_dia FOREIGN KEY (nombre_dia) REFERENCES dia(nombre_dia) 
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE provee(
	color VARCHAR(100) NOT NULL,
	modelo VARCHAR(100) NOT NULL,
	cuit BIGINT NOT NULL,
	
	CONSTRAINT pk_provee PRIMARY KEY (cuit, color, modelo),
	
	CONSTRAINT fk_zapato_provee FOREIGN KEY (color, modelo) REFERENCES zapato(color, modelo)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT fk_proveedor_provee FOREIGN KEY (cuit) REFERENCES proveedor(cuit)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE auditoria_zapato_precio(
    id_auditoria INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    precio_viejo FLOAT NOT NULL,
    precio_nuevo FLOAT NOT NULL,
    usuario VARCHAR(100) NOT NULL
);

USE TPBDD;

INSERT INTO vendedor (nombre, apellido, direccion, dni_vendedor) VALUES
    ('Carlos', 'Gomez', 'Av. San Martin 450', 32456789), -- 1
    ('Lucia', 'Fernandez', 'Belgrano 1230', 35678901), -- 2
    ('Martin', 'Sosa', 'Rivadavia 890', 38901234), -- 3
     ('Lucio', 'Fassano', '25 de Mayo 421', 30523124), -- 4
     ('Valentin', 'Tello', 'Constitucion 628', 36102523); -- 5

INSERT INTO dia (nombre_dia) VALUES
    ('Lunes'),
    ('Martes'),
    ('Miercoles'),
    ('Jueves'),
    ('Viernes'),
    ('Sabado');

INSERT INTO proveedor (cuit, razon_social, direccion, telefono_fijo) VALUES
    (20112233442, 'Calzados del Sur Rio Cuarto', 'Av. Sabattini 2200', 4521000),
    (20223344552, 'Cueros Argentinos', 'Mitre 550', 4522000),
    (20334455662, 'Distribuidora SixSeven', 'Sarmiento 2300', 4523000);

INSERT INTO zapato (color, modelo) VALUES
    ('Negro', 'Borcego Urbano'),
    ('Marron', 'Zapato Vestir'),
    ('Blanco', 'Zapatilla Deportiva'),
    ('Rojo', 'Botines Clasico');

INSERT INTO talle (nro_talle) VALUES
    (36),
    (37),
    (38),
    (40),
    (42),
    (43);

INSERT INTO cliente (dni, nombre, apellido, direccion) VALUES
    (48252234, 'Francisco', 'Muñoz', 'Pedernera 271'),
    (28189420, 'Roman', 'Maldonado', 'Av. Peron 1692'), 
    (30124512, 'Ticiano', 'Rios', 'Paunero 620'),
    (40555666, 'Valentina', 'Perez', 'Colon 345'),
    (27325712, 'Maximo', 'Saliba', 'Quirico Porreca 812');

INSERT INTO mproveedor (cuit, celular) VALUES
    (20112233442, 154001122),
    (20112233442, 154001123),
    (20223344552, 154889900);

INSERT INTO mayorista (dni, descuento_general) VALUES
    (48252234, 15.5),
    (28189420, 20.0);

INSERT INTO minorista (dni, fecha_nacimiento) VALUES
    (30124512, '1983-05-14'),
    (40555666, '1997-11-22');

INSERT INTO franco (nro_franco, observaciones, fecha, dni_vendedor) VALUES
    (1, 'Franco para rendir bases de datos', '2026-10-12', 32456789), -- 1
    (2, 'Dia de estudio', '2026-10-15', 35678901); -- 2

INSERT INTO asiste (dni_vendedor, nombre_dia, hora_entrada, hora_salida) VALUES
    (32456789, 'Lunes', '08:30:00', '16:30:00'), -- 1
    (32456789, 'Martes', '08:30:00', '16:30:00'), -- 1
    (35678901, 'Miercoles', '12:00:00', '20:00:00'), -- 2
    (35678901, 'Jueves', '12:00:00', '20:00:00'), -- 2 
    (38901234, 'Viernes', '09:00:00', '17:00:00'), -- 3
    (38901234, 'Sabado', '09:00:00', '13:00:00'); -- 3

INSERT INTO provee (color, modelo, cuit) VALUES
    ('Negro', 'Borcego Urbano', 20112233442),
    ('Marron', 'Zapato Vestir', 20223344552),
    ('Blanco', 'Zapatilla Deportiva', 20334455662),
    ('Rojo', 'Botines Clasico', 20223344552);

INSERT INTO tiene_talle (color, modelo, nro_talle, cantidad, precio) VALUES
    ('Negro', 'Borcego Urbano', 40, 15, 170500.00),
    ('Negro', 'Borcego Urbano', 42, 10, 199999.00),
    ('Marron', 'Zapato Vestir', 42, 8, 130000.00),
    ('Blanco', 'Zapatilla Deportiva', 38, 25, 80000.00),
    ('Blanco', 'Zapatilla Deportiva', 43, 7, 12000.00),
    ('Rojo', 'Botines Clasico', 36, 5, 71000.00),
    ('Rojo', 'Botines Clasico', 37, 12, 71250.00);

INSERT INTO venta (nro_factura, monto, fecha, dni, dni_vendedor, porcentaje_descuento) VALUES
    (1001, 110500.00, '2026-10-18', 48252234, 32456789, 15.0), -- 1
    (1002, 51300.00, '2026-10-19', 30124512, 35678901, 5.0), -- 2
    (1003, 131200.00, '2026-10-20', 28189420, 38901234, 20.0); -- 3

INSERT INTO contiene (color, modelo, nro_talle, nro_factura, precio_venta, cantidad_venta) VALUES
    ('Negro', 'Borcego Urbano', 40, 1001, 65000.00, 2),
    ('Blanco', 'Zapatilla Deportiva', 38, 1002, 54000.00, 1),
    ('Marron', 'Zapato Vestir', 42, 1003, 82000.00, 2);