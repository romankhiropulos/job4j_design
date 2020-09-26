-- В системе заданы таблицы
--
-- product(id, name, type_id, expired_date, price)
--
-- type(id, name)

DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS type;

CREATE TABLE type
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE product
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(50) NOT NULL,
    expired_date DATE        NOT NULL,
    price        INTEGER     NOT NULL,
    type_id      INTEGER REFERENCES type (id)
);

-- Задание

-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT p.*
FROM product AS p
         JOIN type t ON p.type_id = t.id
WHERE t.name = 'СЫР';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT *
FROM product
WHERE name LIKE '%МОРОЖЕНОЕ%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT *
FROM product
WHERE expired_date + INTERVAL '1 month' > (SELECT current_date);

-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT *
FROM product
WHERE price = (SELECT max(price) FROM product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT t.name, count(*) AS count_of_type_name
FROM product AS p
         JOIN type t ON p.type_id = t.id
GROUP BY t.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT p.*
FROM product AS p
         JOIN type t ON p.type_id = t.id
WHERE t.name = 'СЫР'
   OR t.name = 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT t.name, count(*) AS count_of_type_name
FROM product AS p
         JOIN type t ON p.type_id = t.id
GROUP BY t.name
HAVING count(*) < 10;

-- 8. Вывести все продукты и их тип.
SELECT p.*, t.name
FROM product AS p
         JOIN type t ON p.type_id = t.id;