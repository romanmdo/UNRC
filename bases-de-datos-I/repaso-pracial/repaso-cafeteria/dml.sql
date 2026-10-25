USE cafeteria;

-- Consultas Faciles: Funciones de agregación y clausula GROUP BY.

-- SELECT id_categoria, COUNT(nombre_producto) AS cant_productos
-- FROM producto
-- GROUP BY id_categoria 

-- SELECT id_categoria, MAX(precio) AS precio_maximo
-- FROM producto
-- GROUP BY id_categoria

-- SELECT id_categoria, MIN(precio) AS precio_minimo
-- FROM producto
-- GROUP BY id_categoria

-- SELECT id_categoria, AVG(precio) AS precio_promedio
-- FROM producto
-- GROUP BY id_categoria

-- SELECT id_categoria, SUM(precio) AS suma_precios
-- FROM producto
-- GROUP BY id_categoria

-- Consultas Medias: Funciones de agregación, clausula GROUP BY y Having.

-- SELECT id_categoria, COUNT(nombre_producto) AS cant_productos
-- FROM producto
-- GROUP BY id_categoria 
-- HAVING COUNT(nombre_producto) > 1

-- SELECT id_categoria, AVG(precio) AS precio_promedio
-- FROM producto
-- GROUP BY id_categoria 
-- HAVING AVG(precio) >= 2000

-- SELECT id_categoria, nombre_producto, AVG(precio) AS precio_promedio
-- FROM producto
-- WHERE precio > 1000
-- GROUP BY id_categoria 
-- HAVING AVG(precio) > 1500

-- Consultas Medias: Funciones de agregación, clausula GROUP BY y NATURAL JOIN.

-- SELECT nombre_categoria, COUNT(nombre_producto)
-- FROM categoria NATURAL JOIN producto
-- GROUP BY id_categoria

-- SELECT nombre, COUNT(id_pedido) AS cant_pedidos
-- FROM cliente NATURAL JOIN pedido
-- GROUP BY id_cliente

-- SELECT nombre_producto, SUM(cantidad) AS total_unidades
-- FROM producto NATURAL JOIN detalle_pedido
-- GROUP BY id_producto

-- Consultas Dificiles: Todo.

-- SELECT nombre, total_pedidos
-- FROM cliente NATURAL JOIN (
    -- SELECT id_cliente, COUNT(id_pedido) AS total_pedidos
    -- FROM pedido
    -- GROUP BY id_cliente
    -- HAVING COUNT(id_pedido) > 1
-- ) AS p
-- ORDER BY total_pedidos DESC

SELECT nombre, total_comprado
FROM cliente NATURAL JOIN(
    SELECT SUM(cantidad) AS total_comprado
    FROM pedido NATURAL JOIN detalle_pedido
    GROUP BY id_cliente
    HAVING SUM(cantidad) > 3
) AS p
ORDER BY total_comprado DESC