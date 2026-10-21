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

CREATE TABLE auditoriaArticulo(
	nro_articulo INT NOT NULL,
	movimiento INT NOT NULL,
	fecha_realizacion DATE NOT NULL,
	
	CONSTRAINT fk_articulo FOREIGN KEY (nro_articulo) REFERENCES articulo(nro_articulo) 
);
	
create function informacion_auditoria() returns trigger as '
BEGIN
	INSERT INTO auditoriaArticulo (nro_articulo, movimiento, fecha_realizacion)
	VALUES (NEW.nro_articulo, NEW.cantidad - OLD.cantidad, NOW());
	RETURN NEW;
END; '
LANGUAGE 'plpgsql';

CREATE TRIGGER trigger_informacion_auditoria
AFTER UPDATE ON articulo
FOR EACH ROW
EXECUTE PROCEDURE informacion_auditoria();