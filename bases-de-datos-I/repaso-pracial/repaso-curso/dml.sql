USE gestion_academica;

SELECT legajo, nombre, apellido, promedio_desaprobadas 
FROM estudiante NATURAL JOIN (
    SELECT legajo, AVG(nota_final) AS promedio_desaprobadas
    FROM cursada
    WHERE nota_final < 6
    GROUP BY legajo 
    ) AS p
ORDER BY promedio_desaprobadas DESC