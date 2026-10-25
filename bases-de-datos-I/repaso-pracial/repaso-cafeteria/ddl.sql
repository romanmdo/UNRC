CREATE DATABASE IF NOT EXISTS cafeteria;
USE cafeteria;

-- Eliminación previa de tablas por orden de dependencias
DROP TABLE IF EXISTS detalle_pedido;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS cliente;

-- 1. Tabla Categoria
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

-- 2. Tabla Producto
CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ENGINE=InnoDB;

-- 3. Tabla Cliente
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    ciudad VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

-- 4. Tabla Pedido
CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha DATE NOT NULL,
    metodo_pago VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
) ENGINE=InnoDB;

-- 5. Tabla DetallePedido
CREATE TABLE detalle_pedido (
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id_pedido, id_producto),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
) ENGINE=InnoDB;

-- Poblado de datos de prueba
INSERT INTO categoria (id_categoria, nombre_categoria) VALUES 
(1, 'Cafetería'), 
(2, 'Pastelería'), 
(3, 'Sándwiches'), 
(4, 'Bebidas Frías');

INSERT INTO producto (id_producto, nombre_producto, precio, id_categoria) VALUES 
(1, 'Café Espresso', 1200.00, 1), 
(2, 'Café con Leche', 1600.00, 1), 
(3, 'Medialuna de Manteca', 600.00, 2), 
(4, 'Tarta de Frutilla', 1880.00, 2), 
(5, 'Sándwich de Jamón y Queso', 3200.00, 3), 
(6, 'Jugo de Naranja Natural', 2350.00, 4);

INSERT INTO cliente (id_cliente, nombre, email, ciudad) VALUES 
(1, 'Sofía Martínez', 'sofia@mail.com', 'Córdoba'), 
(2, 'Mateo Gómez', 'mateo@mail.com', 'Río Cuarto'), 
(3, 'Valentina Rossi', 'valen@mail.com', 'Villa María'), 
(4, 'Lucas Benítez', 'lucas@mail.com', 'Córdoba'), 
(5, 'Camila López', 'camila@mail.com', 'Río Cuarto');

INSERT INTO pedido (id_pedido, id_cliente, fecha, metodo_pago) VALUES 
(1, 1, '2026-10-01', 'MercadoPago'), 
(2, 2, '2026-10-02', 'Tarjeta'), 
(3, 1, '2026-10-03', 'Efectivo'), 
(4, 3, '2026-10-03', 'Tarjeta'), 
(5, 1, '2026-10-04', 'MercadoPago'), 
(6, 4, '2026-10-05', 'Tarjeta'), 
(7, 2, '2026-10-05', 'MercadoPago'), 
(8, 5, '2026-10-06', 'Efectivo');

INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario) VALUES 
(1, 1, 2, 1200.00), 
(1, 3, 3, 600.00), 
(2, 5, 1, 3200.00), 
(3, 2, 1, 1600.00), 
(4, 6, 2, 2350.00), 
(5, 4, 1, 1880.00), 
(5, 5, 2, 3200.00), 
(5, 6, 2, 2350.00), 
(6, 2, 2, 1600.00), 
(7, 5, 1, 3200.00), 
(8, 3, 2, 600.00);