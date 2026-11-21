create table producto
(
    id number generated always as identity primary key,

    nombre varchar2(80) not null,

    categoria varchar2(40) not null,

    precio number(10) not null,

    stock number(6) not null,

    constraint chk_producto_precio_valido check (precio >= 0),

    constraint chk_producto_stock_valido check (stock >= 0)

);

INSERT INTO producto (nombre, categoria, precio, stock) VALUES ('Café Americano', 'Bebestible', 1800, 35);

INSERT INTO producto (nombre, categoria, precio, stock) VALUES ('Empanada de Queso', 'Snack', 2200, 20);

INSERT INTO producto (nombre, categoria, precio, stock) VALUES ('Agua Mineral 500ml', 'Bebestible', 1200, 50);

COMMIT;

select * from producto;

select
nvl(max(id), 0) as ID_actual
from producto;

select * from producto order by producto.id asc;
