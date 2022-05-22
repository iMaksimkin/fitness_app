CREATE TABLE admin (
                       id BIGSERIAL PRIMARY KEY,
                       name TEXT NOT NULL,
                       surname TEXT NOT NULL,
                       lastname TEXT,
                       phone TEXT,
                       password TEXT NOT NULL,
                       birthday TIMESTAMP
);

INSERT INTO admin(name, surname, password) VALUES ('admin','admin', 1234);


CREATE TABLE card (
                      id BIGSERIAL PRIMARY KEY,
                      last_visit_day TIMESTAMP NOT NULL,
                      workout_amount BIGINT NOT NULL
);

CREATE TABLE client (
                        id BIGSERIAL PRIMARY KEY,
                        card_id BIGINT NOT NULL,
                        name TEXT NOT NULL,
                        surname TEXT NOT NULL,
                        lastname TEXT,
                        phone TEXT,
                        password TEXT NOT NULL,
                        birthday TIMESTAMP,
                        status BIGINT,
                        FOREIGN KEY (card_id) REFERENCES card
);

CREATE TABLE coach (
                         id BIGSERIAL PRIMARY KEY,
                         name TEXT NOT NULL,
                         surname TEXT NOT NULL,
                         lastname TEXT,
                         phone TEXT,
                         password TEXT NOT NULL,
                         birthday TIMESTAMP
);

CREATE TABLE workout (
                       id BIGSERIAL PRIMARY KEY,
                       coach_id BIGINT NOT NULL,
                       title TEXT NOT NULL,
                       date TIMESTAMP NOT NULL,
                       FOREIGN KEY (coach_id) REFERENCES coach
);

CREATE TABLE client_workouts (
                           client_id BIGINT NOT NULL,
                           workout_id BIGINT NOT NULL,
                           FOREIGN KEY (client_id) REFERENCES client,
                           FOREIGN KEY (workout_id) REFERENCES workout
);

