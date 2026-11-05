USE tpbdd;
DROP VIEW  IF EXISTS vendedores_max_ventas;

-- Obtenemos el nro_talle mas vendido por cada modelo de zapato.

SELECT c1.modelo, c1.nro_talle
FROM contiene c1
WHERE c1.cantidad_venta = (
    SELECT MAX(c2.cantidad_venta)
    FROM contiene c2
    WHERE c2.modelo = c1.modelo
);

-- Con esta consulta obtenemos el monto total que tiene asociado cada vendedor en 2025.
-- En nuestro caso es null pq rellenamos la tabla con valores de venta de 2026.

CREATE VIEW vendedores_max_ventas AS
SELECT 
    v.nro_vendedor,
    v.nombre,
    v.apellido,
    SUM(ve.monto) AS monto_total_2025
FROM vendedor v
LEFT JOIN venta ve 
    ON v.nro_vendedor = ve.nro_vendedor 
    AND YEAR(ve.fecha) = 2025 -- Ningun vendedor tuvo ventas en 2025. En nuestros datos insertados, todos los vendedores hicieron sus ventas en 2026, por lo que dara null todos los montos.
GROUP BY v.nro_vendedor, v.nombre, v.apellido;

-- Obtenemos todos los vendedores que no tuvieron NINGUN FRANCO en todo enero

SELECT apellido, nombre
FROM vendedor
WHERE nro_vendedor NOT IN (
    SELECT nro_vendedor 
    FROM franco 
    WHERE fecha BETWEEN '2026-01-01' AND '2026-01-31'
);

-- Esta consulta utiliza la subconsulta 2) que devuelve los vendedores y sus montos, 
-- para seleccionar al vendedor con el monto de ventas mas alto.

SELECT *
FROM vendedores_max_ventas
WHERE monto_total_2025 = (
    SELECT MAX(monto_total_2025) 
    FROM vendedores_max_ventas
);

-- Esta consulta nos lista el nombre y appelido de 
-- los vendedores que trabajan el dia Lunes.

SELECT v.nombre, v.apellido
FROM vendedor v
INNER JOIN asiste a ON v.nro_vendedor = a.nro_vendedor
WHERE a.nombre_dia = 'Lunes';

-- Esta consulta lista los modelos de zapatos junto a su 
-- color y talle cuyo precio supere los 100000.

SELECT modelo, color, nro_talle, precio
FROM tiene_talle
WHERE precio > 100000;