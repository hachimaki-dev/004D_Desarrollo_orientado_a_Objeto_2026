CREATE TABLE usuarios
(
    
    id number generated always as identity primary key,

    username varchar2(50) not null,

    correo varchar2(100) not null,

    password varchar2(100) not null,

    rol varchar2(30) not null,

    constraint uq_usuario_username unique(username),

    constraint uq_usuario_password unique(password)
);

-- Insertamos 2 registros iniciales de prueba (observa que NO enviamos el id)
INSERT INTO usuarios (username, correo, password, rol)
VALUES ('admin_duoc', 'admin@duoc.cl', 'admin123', 'ADMIN');

INSERT INTO usuarios (username, correo, password, rol)
VALUES ('carlitos_dev', 'carlitos@duoc.cl', 'java2026', 'DOCENTE');

-- Confirmamos la transacción para que los datos sean visibles desde Java
COMMIT;

drop table usuarios;
-- Verificamos que las 2 filas existan con sus IDs 1 y 2
SELECT * FROM usuarios;