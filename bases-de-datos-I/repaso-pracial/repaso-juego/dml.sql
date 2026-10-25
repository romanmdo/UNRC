USE gaming_tracker;

-- SELECT nombre, apellido, puntaje_promedio
-- FROM jugador NATURAL JOIN (
--    SELECT id_jugador, puntaje, AVG(puntaje) AS puntaje_promedio
--    FROM intento
--    WHERE puntaje < 7
--    GROUP BY id_jugador 
--    HAVING AVG(puntaje)
-- ) AS p
-- ORDER BY puntaje_promedio 

-- SELECT nombre, apellido, suma_puntos
-- FROM jugador NATURAL JOIN (
--    SELECT id_jugador, puntaje, SUM(puntaje) AS suma_puntos
--    FROM intento
--    WHERE puntaje >= 7
--    GROUP BY id_jugador 
--    HAVING SUM(puntaje) >= 12
--    ) AS p
-- ORDER BY suma_puntos DESC

-- SELECT nombre_mision, max_puntaje
-- FROM mision NATURAL JOIN (
-- 	SELECT codigo_mision, MAX(puntaje) AS max_puntaje
--	FROM intento
--	WHERE puntaje > 5
--	GROUP BY codigo_mision 
--	HAVING MAX(puntaje)
--	) AS p
-- ORDER BY max_puntaje DESC

-- SELECT nombre_mision, cantidad_jugadores_distintos
-- FROM mision NATURAL JOIN (
--	SELECT codigo_mision, COUNT(DISTINCT id_jugador) AS cantidad_jugadores_distintos
--	FROM intento
--	GROUP BY codigo_mision 
--	HAVING COUNT(DISTINCT id_jugador) 	> 2
--	) AS p
-- ORDER BY cantidad_jugadores_distintos DESC


