CREATE DATABASE IF NOT EXISTS gestion_academica;
USE gestion_academica;

DROP TABLE IF EXISTS cursada;
DROP TABLE IF EXISTS materia;
DROP TABLE IF EXISTS estudiante;

-- 1. Tabla estudiante
CREATE TABLE estudiante (
    legajo INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50)
);

-- 2. Tabla materia
CREATE TABLE materia (
    codigo_materia INT PRIMARY KEY,
    nombre_materia VARCHAR(100) NOT NULL,
    creditos INT NOT NULL,
    departamento VARCHAR(50) NOT NULL
);

-- 3. Tabla cursada
CREATE TABLE cursada (
    legajo INT,
    codigo_materia INT,
    nota_final DECIMAL(4,2),
    asistencia_porcentaje DECIMAL(5,2),
    fecha_reglamentacion DATE,
    PRIMARY KEY (legajo, codigo_materia),
    FOREIGN KEY (legajo) REFERENCES estudiante(legajo),
    FOREIGN KEY (codigo_materia) REFERENCES materia(codigo_materia)
);

-- =========================================================
-- DATOS DE PRUEBA
-- =========================================================

INSERT INTO estudiante VALUES
(101, 'Juan', 'Pérez', 'Río Cuarto'),
(102, 'María', 'Gómez', 'Córdoba'),
(103, 'Carlos', 'López', 'Río Cuarto'),
(104, 'Ana', 'Martínez', 'Villa María'),
(105, 'Lucía', 'Fernández', 'Río Cuarto'),
(106, 'Pedro', 'Sánchez', 'Córdoba');

INSERT INTO materia VALUES
(1, 'Base de Datos 1', 10, 'Computación'),
(2, 'Programación 1', 12, 'Computación'),
(3, 'Análisis Matemático', 8, 'Matemática'),
(4, 'Sistemas Operativos', 10, 'Computación'),
(5, 'Álgebra Lineal', 8, 'Matemática');

INSERT INTO cursada VALUES
-- Juan (101): Aprobó BD1 (10 crd) y Prog1 (12 crd) = 22 crd. Desaprobó Análisis (4.00) y Álgebra (2.00)
(101, 1, 8.00, 90.00, '2025-06-20'),
(101, 2, 7.00, 85.00, '2025-06-20'),
(101, 3, 4.00, 70.00, '2025-06-20'),
(101, 5, 2.00, 60.00, '2025-06-20'),

-- María (102): Aprobó BD1 (10 crd) y Prog1 (12 crd) = 22 crd. Desaprobó Análisis (5.00)
(102, 1, 9.00, 95.00, '2025-06-20'),
(102, 2, 8.00, 80.00, '2025-06-20'),
(102, 3, 5.00, 80.00, '2025-06-20'),

-- Carlos (103): Aprobó BD1 (10 crd), Prog1 (12 crd), SO (10 crd) = 32 crd. Sin desaprobadas
(103, 1, 7.00, 80.00, '2025-06-20'),
(103, 2, 6.00, 75.00, '2025-06-20'),
(103, 4, 9.00, 90.00, '2025-06-20'),

-- Ana (104): Aprobó BD1 (10 crd). Desaprobó Prog1 (4.00)
(104, 1, 8.00, 85.00, '2025-06-20'),
(104, 2, 4.00, 80.00, '2025-06-20'),

-- Lucía (105): Aprobó BD1 (10 crd), Prog1 (12 crd) = 22 crd
(105, 1, 10.00, 100.00, '2025-06-20'),
(105, 2, 9.00, 88.00, '2025-06-20'),

-- Pedro (106): Aprobó BD1 (10 crd)
(106, 1, 6.00, 75.00, '2025-06-20');