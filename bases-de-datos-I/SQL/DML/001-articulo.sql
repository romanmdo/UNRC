-- Consulta A)
SELECT *
FROM producto
WHERE precio < 15000

-- Consulta B)
SELECT cod_producto, cod_producto
FROM producto p NATURAL JOIN itemfactura i
WHERE i.cantidad > 2


-- Consulta C) 
SELECT * 
FROM cliente 
WHERE nro_cliente NOT IN 
(
	SELECT nro_cliente
    FROM factura
)
GROUP BY apellido, nombre
ORDER BY apellido, nombre DESC


-- Consulta D) 
SELECT *
FROM producto
WHERE cod_producto NOT IN 
(
	SELECT cod_producto
    FROM itemfactura
)


-- Consulta E) 
SELECT *
FROM cliente LEFT JOIN factura ON cliente.nro_cliente = factura.nro_cliente
