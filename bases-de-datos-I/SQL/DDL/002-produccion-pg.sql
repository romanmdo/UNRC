CREATE domain tipo_color AS VARCHAR(20)
	CHECK (value IN('ROJO', 'BLANCO', 'NEGRO'))
	NOT null;
		
CREATE TABLE auto(
	cod_auto INT NOT NULL,
	nombre_auto VARCHAR(20) NOT NULL,
	
	constraint pk_auto PRIMARY KEY (cod_auto),
	constraint check_entero CHECK (cod_auto >= 0)
);

CREATE TABLE color (
	cod_color INT NOT NULL,
	nombre_color tipo_color NOT NULL,
	
	constraint pk_color PRIMARY KEY(cod_color),
	constraint check_entero CHECK (cod_color >= 0)
);

CREATE TABLE produccion (
	mes_produccion VARCHAR(20) NOT NULL,
	anio_produccion VARCHAR(20) NOT NULL,
	cod_auto INT NOT NULL,
	cod_color INT NOT NULL,
	
	constraint pk_produccion PRIMARY KEY (mes_produccion, anio_produccion, cod_auto, cod_color),
	constraint fk_cod_auto FOREIGN KEY (cod_auto) REFERENCES auto(cod_auto),
	constraint fk_cod_color FOREIGN KEY (cod_color) REFERENCES color(cod_color)	
);

INSERT INTO auto(cod_auto, nombre_auto)
VALUES
	(1, 'Fiat Idea'),
	(2, 'Ford Ka'),
	(3, 'Ford Fiesta');

INSERT INTO color(cod_color, nombre_color)
VALUES
	(100, 'ROJO'),
	(101, 'BLANCO'),
	(102, 'NEGRO');
	
INSERT INTO produccion(mes_produccion, anio_produccion, cod_auto, cod_color)
VALUES
	('JUNIO', '2026', 1, 100),
	('FEBRERO', '2026', 2, 102),
	('MARZO', '2025', 3, 101);
