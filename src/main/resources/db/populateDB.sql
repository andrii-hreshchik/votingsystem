DELETE FROM meals;
DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM restaurants;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('user', 'user@gmail.com', '{noop}password'),
  ('User2', 'user2@gmail.com', '{noop}passwordUser2'),
  ('User3', 'user3@gmail.com', '{noop}passwordUser3'),
  ('User4', 'user4@gmail.com', '{noop}passwordUser4'),
  ('User5', 'user5@gmail.com', '{noop}passwordUser5'),
  ('admin', 'admin@gmail.com', '{noop}password'),
  ('Admin2', 'admin2@gmail.com', '{noop}passwordAdmin2');

INSERT INTO user_roles (user_id, role) VALUES
  (100000, 'ROLE_USER'),
  (100001, 'ROLE_USER'),
  (100002, 'ROLE_USER'),
  (100003, 'ROLE_USER'),
  (100004, 'ROLE_USER'),
  (100005, 'ROLE_ADMIN'),
  (100006, 'ROLE_ADMIN');

INSERT INTO restaurants (title, description, date_time) VALUES
  ('Ресторан1', 'Описание Ресторан1', '2018-04-18 10:00:00'),
  ('Ресторан2', 'Описание Ресторан2', '2018-05-20 10:00:00'),
  ('Ресторан3', 'Описание Ресторан3', '2018-06-23 10:00:00');

INSERT INTO meals (restaurant_id, description, price, date_time) VALUES
  (100007, 'Ресторан1 блюдо1', 80, now()),
  (100007, 'Ресторан1 блюдо2', 150, now()),
  (100007, 'Ресторан1 блюдо3', 220, now()),

  (100008, 'Ресторан2 блюдо1', 60, now()),
  (100008, 'Ресторан2 блюдо2', 40, now()),
  (100008, 'Ресторан2 блюдо3', 50, now()),
  (100008, 'Ресторан2 блюдо4', 90, now()),

  (100009, 'Ресторан3 блюдо1', 110, now()),
  (100009, 'Ресторан3 блюдо2', 180, now()),
  (100009, 'Ресторан3 блюдо3', 150, now()),
  (100009, 'Ресторан3 блюдо4', 300, now()),
  (100009, 'Ресторан3 блюдо5', 80, now()),

  (100007, 'Ресторан1 блюдо1 old', 80, '2018-06-11 12:00:00'),
  (100007, 'Ресторан1 блюдо2 old', 150, '2018-06-11 12:30:00'),
  (100007, 'Ресторан1 блюдо3 old', 220, '2018-06-11 13:00:00'),

  (100008, 'Ресторан2 блюдо1 old', 60, '2018-06-11 11:00:00'),
  (100008, 'Ресторан2 блюдо2 old', 40, '2018-06-11 11:30:00'),
  (100008, 'Ресторан2 блюдо3 old', 50, '2018-06-11 11:45:00'),
  (100008, 'Ресторан2 блюдо4 old', 90, '2018-06-11 12:00:00');


INSERT INTO votes (user_id, restaurant_id, date_time) VALUES
  (100000, 100008, '2018-06-11 15:00:00'),
  (100001, 100008, '2018-06-12 12:00:00'),
  (100002, 100008, '2018-06-12 10:00:00'),
  (100003, 100007, '2018-06-11 14:00:00'),
  (100004, 100007, '2018-06-13 10:15:00'),

  (100001, 100008, now()),
  (100002, 100008, now()),
  (100003, 100009, now()),
  (100004, 100009, now());











