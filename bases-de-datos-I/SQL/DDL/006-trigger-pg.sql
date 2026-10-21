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

CREATE FUNCTION mayusculas() RETURNS TRIGGER AS '
BEGIN
	NEW.descripcion := upper(NEW.descripcion);
	RETURN NEW;
END;' 
LANGUAGE 'plpgsql';

CREATE TRIGGER trigger_mayusculas
BEFORE INSERT ON articulo
FOR EACH ROW
EXECUTE PROCEDURE mayusculas();