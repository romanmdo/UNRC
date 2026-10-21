-- A) Competidores del deporte “FUTBOL”.

SELECT nro_competidor, nombre
FROM Competidor NATURAL JOIN Deporte
WHERE denominacion = "Futbol"

-- B) Países que han competido y no ganaron ninguna medalla. 

SELECT DISTINCT(pais) 
FROM competidor
WHERE pais NOT IN (
	SELECT pais
	FROM medalla
)

