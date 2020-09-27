-- Задание:
--
-- Даны две сущности, представленные в таблицах departments и employees.
-- Отношение one-to-many. В таблицах только поле name.

-- 1. Создать таблицы и заполнить их начальными данными

DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS teens;

CREATE TABLE departments
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE employees
(
    id             SERIAL PRIMARY KEY,
    name           VARCHAR(2000) NOT NULL,
    departments_id INT REFERENCES departments (id)
);

INSERT INTO departments (name)
VALUES ('SAP'),
       ('Web'),
       ('Desktop'),
       ('HR'),
       ('Kitchen');

INSERT INTO employees (name, departments_id)
VALUES ('Ivan', 1),
       ('Petya', 2),
       ('Vasya', 3),
       ('Masha', 4),
       ('Sveta', 4),
       ('Natasha', 1),
       ('Fedor', 2);

-- 2. Выполнить запросы с left, right, full, cross соединениями

SELECT *
FROM departments d
         LEFT JOIN employees e ON d.id = e.departments_id;

SELECT *
FROM employees e
         RIGHT JOIN departments d ON e.departments_id = d.id;

SELECT *
FROM departments d
         FULL JOIN employees e ON d.id = e.departments_id;

SELECT *
FROM departments
         CROSS JOIN employees;

-- 3. Используя left join найти работников, которые не относятся ни к одну из департаментов

SELECT e.*
FROM employees e
         LEFT JOIN departments d ON e.departments_id = d.id
WHERE d.name IS NULL;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат.

SELECT *
FROM departments d
         LEFT JOIN employees e ON d.id = e.departments_id;

SELECT d.*, e.*
FROM employees e
         RIGHT JOIN departments d ON e.departments_id = d.id;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--    Используя cross join составить все возможные разнополые пары

CREATE TABLE teens
(
    id     SERIAL PRIMARY KEY,
    name   VARCHAR(2000) NOT NULL UNIQUE,
    gender VARCHAR(2000) NOT NULL
);

INSERT INTO teens (name, gender)
VALUES ('Ivan', 'M'),
       ('Petya', 'M'),
       ('Vasya', 'M'),
       ('Masha', 'W'),
       ('Sveta', 'W'),
       ('Natasha', 'W'),
       ('Fedor', 'M');

SELECT *
FROM teens t1
         CROSS JOIN teens t2
WHERE t1.gender != t2.gender
  AND t1.name > t2.name
ORDER BY t1.gender, t1.name;


