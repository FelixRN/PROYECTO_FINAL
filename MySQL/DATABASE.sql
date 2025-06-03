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
    anio YEAR NOT NULL,
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
    tipo ENUM('gasolina', 'revision', 'itv', 'cambio_aceite', 'otros') NOT NULL,
    kilometraje INT NOT NULL,
    fecha_gasto DATE NOT NULL,
    importe DECIMAL(10,2) NOT NULL,
    descripcion TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_coche) REFERENCES coche(id_coche) ON DELETE CASCADE
);


/*CREATE INDEX idx_usuario_codigo_uuid ON usuario(codigo_uuid);
CREATE INDEX idx_coche_matricula ON coche(matricula);
CREATE INDEX idx_propietario_usuario ON propietario(id_propietario);
CREATE INDEX idx_propietario_coche ON propietario(id_coche);
CREATE INDEX idx_gasto_coche ON gastos(id_coche);
CREATE INDEX idx_gasto_fecha ON gastos(fecha_gasto);
CREATE INDEX idx_gasto_tipo ON gastos(tipo);
CREATE INDEX idx_gasto_kilometraje ON gastos(kilometraje);*/


INSERT INTO usuario (nombre, password ) VALUES('Felix', '12345');

SELECT * FROM usuario;