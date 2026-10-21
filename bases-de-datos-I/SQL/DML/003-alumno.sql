-- A) Devolver todos los alumnos (nro_alumno, nombre) que realizan todos los talleres.

SELECT nro_alumno, nombre
FROM Alumno NATURAL JOIN (
    SELECT nro_alumno
    FROM Realiza
    GROUP BY nro_alumno
    HAVING COUNT(codigo_taller) = (SELECT COUNT(codigo_taller) from Taller)
) AS alumnos_todos_talleres;

-- B) Devolver talleres (cod_taller, nombre) que son realizados por más de un alumno.

SELECT cod_taller, nombre
FROM Taller NATURAL JOIN (
    SELECT codigo_taller
    FROM Realiza r1, Realiza r2
    WHERE r1.cod_taller = r2.cod_taller AND
    r1.nro_alumno != r2.nro_alumno
)

-- C) Devolver los talleres que no tienen alumnos.

SELECT cod_taller, nombre
FROM Taller
WHERE cod_taller NOT IN (
    SELECT cod_taller
    FROM Taller NATURAL JOIN Realiza
)