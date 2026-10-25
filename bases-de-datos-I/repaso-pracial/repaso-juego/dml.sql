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