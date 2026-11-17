drop table JUEGOS;
CREATE TABLE JUEGOS (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    precio NUMBER(10,2) NOT NULL,
    consola VARCHAR2(50) NOT NULL
);

INSERT INTO JUEGOS (nombre, precio, consola) VALUES ('Zelda', 59.99, 'Switch');
INSERT INTO JUEGOS (nombre, precio, consola) VALUES ('God of War', 49.99, 'PS5');
COMMIT;

SELECT * FROM JUEGOS;