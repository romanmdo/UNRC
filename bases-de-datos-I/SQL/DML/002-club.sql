-- Consulta A)
SELECT * 
FROM competencia
WHERE categoria > 2


-- Consulta B) 
SELECT *
FROM club
WHERE nro_club IN (
	SELECT nro_competencia
    FROM competencia NATURAL JOIN participacion
    WHERE categoria = 2
)


-- Consulta C) 
SELECT nombre_club
FROM club
WHERE nro_club IN (
	SELECT nro_competencia
    FROM competencia NATURAL JOIN participacion
    WHERE categoria = 2
)
