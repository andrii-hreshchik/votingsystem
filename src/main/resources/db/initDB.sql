DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR                 NOT NULL,
  email      VARCHAR                 NOT NULL,
  password   VARCHAR                 NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL
);

CREATE UNIQUE INDEX user_unique_email_idx
  ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  title       VARCHAR                 NOT NULL,
  description TEXT                    NOT NULL,

  date_time   TIMESTAMP DEFAULT now() NOT NULL
);

CREATE UNIQUE INDEX restaurant_unique_title_index
  ON restaurants (title);


CREATE TABLE votes
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id       INTEGER                 NOT NULL,
  restaurant_id INTEGER                 NOT NULL,
  date_time     TIMESTAMP DEFAULT now() NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX votes_unique_user_datetime_idx
  ON votes (user_id, date_time);

CREATE TABLE meals
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurant_id INTEGER                 NOT NULL,
  description   TEXT                    NOT NULL,
  price         INTEGER                 NOT NULL,
  date_time     TIMESTAMP DEFAULT now() NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
