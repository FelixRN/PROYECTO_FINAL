DROP DATABASE PracticaFinalRñfe;
CREATE DATABASE PracticaFinalRñfe;
USE PracticaFinalRñfe;

CREATE TABLE usuario (
    id_usuario INT  AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    codigo_uuid VARCHAR(36) DEFAULT (UUID()) UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_usuario)
);

CREATE TABLE coche (
    id_coche INT AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    anio int NOT NULL,
    PRIMARY KEY (id_coche)
);

CREATE TABLE propietario (
    id_usuario INT NOT NULL,
    id_coche INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_coche) REFERENCES coche(id_coche) ON DELETE CASCADE,
    PRIMARY KEY (id_usuario, id_coche)
);

CREATE TABLE gastos (
    id_gastos INT AUTO_INCREMENT PRIMARY KEY,
    id_coche INT NOT NULL,
    tipo ENUM('Gasolina', 'Revision', 'ITV', 'Cambio_aceite', 'Otros') NOT NULL,
    kilometraje INT NOT NULL,
    fecha_gasto DATE NOT NULL,
    importe DECIMAL(10,2) NOT NULL,
    descripcion TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_coche) REFERENCES coche(id_coche) ON DELETE CASCADE
);

INSERT INTO usuario (nombre, password ) VALUES('Felix', '12345');
INSERT INTO coche (marca, modelo, matricula, anio ) VALUES('Volvo', 'CMD', 'DRD-123', '1999');


<<<<<<< HEAD
SELECT * FROM usuario;
=======
SELECT * FROM usuario;
SELECT * FROM coche;
>>>>>>> e9d454d74519e65603dbc62fb808c4b460a170f8
