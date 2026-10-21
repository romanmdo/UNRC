CREATE TABLE articulo (
	nro_articulo INT NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
	precio NUMERIC(6, 2) NOT null,
	cantidad INT NOT NULL,
	stock_min INT NOT NULL,
	stock_max INT NOT NULL,
	mes_ult_mov VARCHAR(20) NOT NULL,
	fecha_vto DATE NOT null,
	
	CONSTRAINT pk_articulo PRIMARY KEY (nro_articulo),
	CONSTRAINT check_precio  CHECK (precio > 0 and precio < 9999),
	CONSTRAINT check_stock CHECK (stock_min <= stock_max)
);

INSERT INTO articulo (nro_articulo, descripcion, precio, cantidad, stock_min, stock_max, mes_ult_mov, fecha_vto)
VALUES
	(1, 'Cacao', 4000, 5, 1, 100, 'JUNIO', '2026-01-10'),
	(2, 'Azúcar', 120, 30, 15, 45, 'OCTUBRE', '2027-05-15'),
	(3, 'Harina', 110, 35, 16, 40, 'SEPTIEMBRE', '2027-01-20');

