CREATE TABLE productos (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(80) NOT NULL,
    categoria VARCHAR2(40) NOT NULL,
    precio NUMBER(10) NOT NULL,
    stock NUMBER(6) NOT NULL
);

INSERT INTO productos (nombre, categoria, precio, stock) VALUES ('Café Americano', 'Bebestible', 1800, 35);
INSERT INTO productos (nombre, categoria, precio, stock) VALUES ('Empanada de Queso', 'Snack', 2200, 20);
INSERT INTO productos (nombre, categoria, precio, stock) VALUES ('Agua Mineral 500ml', 'Bebestible', 1200, 50);
COMMIT;