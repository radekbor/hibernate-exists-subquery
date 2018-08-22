insert into peoples (id, first_name, last_name) VALUES (1, 'John', 'Doe');
insert into peoples (id, first_name, last_name) VALUES (2, 'Jane', 'Doe');
insert into peoples (id, first_name, last_name) VALUES (3, 'Jannet', 'Doe');

insert into events (id, person_id, event_level, log) VALUES (1, 1, 'INFO', 'John type wrong password');
insert into events (id, person_id, event_level, log) VALUES (2, 1, 'DEBUG', 'Hashing');
insert into events (id, person_id, event_level, log) VALUES (3, 2, 'ERROR', 'Jane blocked account');
