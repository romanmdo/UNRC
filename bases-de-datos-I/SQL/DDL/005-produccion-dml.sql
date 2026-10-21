-- A) Obtener el auto (cod_auto) con mayor producción.
SELECT cod_auto
FROM produccion 
GROUP BY cod_auto 
HAVING COUNT(*) >= all(
	SELECT COUNT(*)
	FROM produccion
	GROUP BY cod_auto
)

-- B) Obtener la cantidad de producciones de cada auto por color. 
SELECT cod_auto, cod_color, COUNT(*) AS cantidad_producciones 
FROM produccion 
GROUP BY cod_auto, cod_color;