-- Создать структур данных в базе.
-- Таблицы:
--    Кузов. Двигатель, Коробка передач.
--
-- Создать структуру Машина. Машина не может существовать без данных из п.1.
--
-- Заполнить таблицы через insert.

DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS engine;
DROP TABLE IF EXISTS transmission;
DROP TABLE IF EXISTS body;

CREATE TABLE engine
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(2000) NOT NULL
);

CREATE TABLE transmission
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(2000) NOT NULL
);

CREATE TABLE body
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(2000) NOT NULL
);

CREATE TABLE car
(
    id              SERIAL PRIMARY KEY,
    model           VARCHAR(2000) NOT NULL,
    engine_id       INTEGER REFERENCES engine (id),
    transmission_id INTEGER REFERENCES transmission (id),
    body_id         INTEGER REFERENCES body (id)
);

INSERT INTO engine (model)
VALUES ('e1'),
       ('e2'),
       ('e3'),
       ('e4');

INSERT INTO transmission (model)
VALUES ('t1'),
       ('t2'),
       ('t3'),
       ('t4');

INSERT INTO body (model)
VALUES ('b1'),
       ('b2'),
       ('b3'),
       ('b4');

INSERT INTO car (model, engine_id, transmission_id, body_id)
VALUES ('mercedes', 1, 1, 1),
       ('audi', 2, 2, 2),
       ('bmw', 3, 3, 3);

-- Создать SQL запросы:
--
-- 1. Вывести список всех машин и все привязанные к ним детали.

SELECT *
FROM car c
         JOIN body b ON b.id = c.body_id
         JOIN engine e ON e.id = c.engine_id
         JOIN transmission t ON t.id = c.transmission_id;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

SELECT b.*
FROM body b
         LEFT OUTER JOIN car c ON b.id = c.body_id
WHERE c.id IS NULL
UNION ALL
SELECT e.*
FROM engine e
         LEFT JOIN car c2 ON e.id = c2.engine_id
WHERE c2.id IS NULL
UNION ALL
SELECT t.*
FROM transmission t
         LEFT OUTER JOIN car c3 ON t.id = c3.transmission_id
WHERE c3.id IS NULL;
