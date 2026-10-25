CREATE DATABASE IF NOT EXISTS gaming_tracker;
USE gaming_tracker;

DROP TABLE IF EXISTS intento;
DROP TABLE IF EXISTS mision;
DROP TABLE IF EXISTS jugador;

-- 1. Tabla jugador
CREATE TABLE jugador (
    id_jugador INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- 2. Tabla mision
CREATE TABLE mision (
    codigo_mision INT PRIMARY KEY,
    nombre_mision VARCHAR(100) NOT NULL,
    tipo_mision VARCHAR(50) NOT NULL,
    fecha_inicio DATE,
    fecha_cierre DATE
);

-- 3. Tabla intento
CREATE TABLE intento (
    id_jugador INT,
    codigo_mision INT,
    puntaje DECIMAL(5,2),
    fecha_intento DATE,
    PRIMARY KEY (id_jugador, codigo_mision),
    FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador),
    FOREIGN KEY (codigo_mision) REFERENCES mision(codigo_mision)
);

-- =========================================================
-- DATOS DE PRUEBA
-- =========================================================

INSERT INTO jugador VALUES 
(1, 'Lucas', 'Gómez', 'lucas@mail.com'), 
(2, 'Sofía', 'Rodríguez', 'sofia@mail.com'), 
(3, 'Mateo', 'Fernández', 'mateo@mail.com'), 
(4, 'Valentina', 'López', 'valentina@mail.com');

INSERT INTO mision VALUES 
(1001, 'Infiltración Nocturna', 'PRACTICA', '2025-01-01', '2025-01-10'), 
(1002, 'Batalla Campal Boss', 'EXAMEN', '2025-01-05', '2025-01-15'), 
(1003, 'Carrera de Obstáculos', 'LABORATORIO', '2025-01-10', '2025-01-20'), 
(1004, 'Defensa de Base', 'RECUPERATORIO', '2025-01-12', '2025-01-22');

INSERT INTO intento VALUES 
-- Lucas (1): Desaprobó 1001 (4.00) y 1003 (3.00). Aprobó 1002 (8.50)
(1, 1001, 4.00, '2025-01-02'),
(1, 1002, 8.50, '2025-01-06'),
(1, 1003, 3.00, '2025-01-11'),

-- Sofía (2): Desaprobó 1002 (5.00). Aprobó 1001 (9.00)
(2, 1001, 9.00, '2025-01-03'),
(2, 1002, 5.00, '2025-01-07'),

-- Mateo (3): Aprobó 1001 (8.00) y 1002 (9.50) = 17.50 pts acumulados
(3, 1001, 8.00, '2025-01-04'),
(3, 1002, 9.50, '2025-01-08'),

-- Valentina (4): Desaprobó 1001 (2.00) y 1002 (6.00)
(4, 1001, 2.00, '2025-01-05'),
(4, 1002, 6.00, '2025-01-09');2