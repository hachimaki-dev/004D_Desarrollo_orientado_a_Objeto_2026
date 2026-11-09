CREATE TABLE usuarios (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR2(50) NOT NULL UNIQUE,
    correo VARCHAR2(100) NOT NULL,
    password VARCHAR2(100) NOT NULL,
    rol VARCHAR2(30) NOT NULL
);

-- Insertamos 2 registros iniciales de prueba (observa que NO enviamos el id)
INSERT INTO usuarios (username, correo, password, rol)
VALUES ('admin_duoc', 'admin@duoc.cl', 'admin123', 'ADMIN');

INSERT INTO usuarios (username, correo, password, rol)
VALUES ('carlitos_dev', 'carlitos@duoc.cl', 'java2026', 'DOCENTE');

-- Confirmamos la transacción para que los datos sean visibles desde Java
COMMIT;

-- Verificamos que las 2 filas existan con sus IDs 1 y 2
SELECT * FROM usuarios;