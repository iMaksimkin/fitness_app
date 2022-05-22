
INSERT INTO card(id, last_visit_day, workout_amount) VALUES ('1', '2022-04-26 15:37:56.000000','10');
INSERT INTO client(id, card_id, name, surname, password) VALUES ('1', '1', 'client1','client1', '1234');

INSERT INTO coach(id, name, surname, password) VALUES ('1', 'coach1','coach1', '1234');

INSERT INTO workout(id, coach_id, title, date) VALUES ('1', '1','title1', '2022-04-26 15:37:56.000000');
INSERT INTO workout(id, coach_id, title, date) VALUES ('2', '1','title2', '2022-04-26 15:37:56.000000');

INSERT INTO client_workouts(client_id, workout_id) VALUES ('1', '1');