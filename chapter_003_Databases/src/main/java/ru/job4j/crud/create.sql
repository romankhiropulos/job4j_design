-- user - role = many-to-one 
-- role - privileges = many-to-many
-- item - user = many-to-one
-- item - comments = one-to-many
-- item - attachs = one-to-many
-- item - category = many-to-one
-- item - state = many-to-one

-- Создать SQL скрипт инициализирующий создание новой базы данных.
--
-- Создать SQL скрипт создающий таблицы для хранения структуры системы заявок.
--
-- Создать SQL скрипт заполняющий начальные данные для системы заявок.
--
-- Скрипты должны выполняться последовательно.

DROP DATABASE IF EXISTS job4j_crud;
CREATE DATABASE job4j_crud;

DROP TABLE IF EXISTS attachment;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS state;
DROP TABLE IF EXISTS roles_privileges;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS privilege;

CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    age        INTEGER      NOT NULL,
    email      VARCHAR(100) NOT NULL,
    password   VARCHAR      NOT NULL,
    role_id    INTEGER REFERENCES role (id)
);

CREATE TABLE privilege
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(2000) NOT NULL
);

CREATE TABLE roles_privileges
(
    id           SERIAL PRIMARY KEY,
    role_id      INTEGER REFERENCES role (id),
    privilege_id INTEGER REFERENCES privilege (id)
);

CREATE TABLE category
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE state -- состояние заявки
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE item
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(2000) NOT NULL,
    user_id     INTEGER REFERENCES users (id),
    category_id INTEGER REFERENCES category (id),
    state_id    INTEGER REFERENCES state (id)
);

CREATE TABLE comment
(
    id      SERIAL PRIMARY KEY,
    text    VARCHAR(2000) NOT NULL,
    item_id INTEGER REFERENCES item (id)
);

CREATE TABLE attachment
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(2000) NOT NULL,
    item_id     INTEGER REFERENCES item (id)
);

DELETE
FROM attachment;
DELETE
FROM comment;
DELETE
FROM item;
DELETE
FROM category;
DELETE
FROM state;
DELETE
FROM roles_privileges;
DELETE
FROM users;
DELETE
FROM role;
DELETE
FROM privilege;

INSERT INTO role (name)
VALUES ('user'),
       ('admin');

INSERT INTO privilege (description)
VALUES ('Validate new user'),
       ('Create account'),
       ('Delete own account'),
       ('Delete users accounts');

INSERT INTO roles_privileges (role_id, privilege_id)
VALUES (1, 2),
       (1, 3),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4);

INSERT INTO users (first_name, last_name, age, email, password, role_id)
VALUES ('User', 'Ivanov', 27, 'user@yandex.ru', 'password', 1),
       ('Admin', 'Petrov', 36, 'admin@yandex.ru', 'password', 2);

INSERT INTO state (name)
VALUES ('Done'),
       ('Active');

INSERT INTO category (name)
VALUES ('Job'),
       ('Vacation'),
       ('Salary'),
       ('Achievement');

INSERT INTO item (description, user_id, category_id, state_id)
VALUES ('Trouble with working account of Lync', 1, 1, 2),
       ('Go to Java Island', 2, 2, 2),
       ('Increase salary', 1, 3, 1),
       ('Learned to program in Java', 1, 2, 2);

INSERT INTO comment (text, item_id)
VALUES ('I can`t to get connection', 1),
       ('I would like to get to beach', 2);

INSERT INTO attachment (description, item_id)
VALUES ('You need to turn on VPN', 1),
       ('You are welcome', 2);






