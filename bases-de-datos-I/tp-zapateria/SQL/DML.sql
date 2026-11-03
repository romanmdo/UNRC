SELECT c1.modelo, c1.nro_talle
FROM contiene c1
WHERE c1.cantidad_venta = (
    SELECT MAX(c2.cantidad_venta)
    FROM contiene c2
    WHERE c2.modelo = c1.modelo
);

SELECT 
    v.nro_vendedor,
    v.nombre,
    v.apellido,
    SUM(ve.monto) AS monto_total_2025
FROM vendedor v
LEFT JOIN venta ve 
    ON v.nro_vendedor = ve.nro_vendedor 
    AND YEAR(ve.fecha) = 2025 #Ningun vendedor tuvo ventas en 2025. En nuestros datos insertados, todos los vendedores hicieron sus ventas en 2026, por lo que dara null todos los montos.
GROUP BY v.nro_vendedor, v.nombre, v.apellido;

SELECT 
    apellido, 
    nombre
FROM vendedor
WHERE nro_vendedor NOT IN (
    SELECT nro_vendedor 
    FROM franco 
    WHERE fecha BETWEEN '2026-01-01' AND '2026-01-31'
);