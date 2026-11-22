DROP TABLE PROPIEDADES CASCADE CONSTRAINTS;

CREATE TABLE propiedades (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tipo VARCHAR2(20) NOT NULL, -- 'CASA' o 'DEPARTAMENTO'
    direccion VARCHAR2(120) NOT NULL,
    arriendo_base NUMBER(10) NOT NULL,
    metros_cuadrados NUMBER(6) NOT NULL,
    -- Columnas exclusivas de CASA (NULL si es DEPARTAMENTO)
    cantidad_pisos NUMBER(3),
    tiene_patio NUMBER(1), -- 1 = Sí, 0 = No
    -- Columnas exclusivas de DEPARTAMENTO (NULL si es CASA)
    numero_piso NUMBER(3),
    gastos_comunes NUMBER(10)
);

INSERT INTO propiedades (tipo, direccion, arriendo_base, metros_cuadrados, cantidad_pisos, tiene_patio)
VALUES ('CASA', 'Av. Los Alerces 420', 650000, 120, 2, 1);

INSERT INTO propiedades (tipo, direccion, arriendo_base, metros_cuadrados, numero_piso, gastos_comunes)
VALUES ('DEPARTAMENTO', 'Calle Prat 890, Depto 504', 480000, 62, 5, 95000);

INSERT INTO propiedades (tipo, direccion, arriendo_base, metros_cuadrados, cantidad_pisos, tiene_patio)
VALUES ('CASA', 'Pasaje Roble 115', 590000, 95, 1, 0);
COMMIT;