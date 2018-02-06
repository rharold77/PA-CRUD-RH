INSERT INTO course (distance, name) VALUES ('3m', 'Ayr');
INSERT INTO course (distance, name) VALUES ('2m', 'Wolverhampton');
INSERT INTO course (distance, name) VALUES ('3.5m', 'York');

INSERT INTO jockey (first_name, last_name) VALUES ('P', 'Makin');
INSERT INTO jockey (first_name, last_name) VALUES ('J', 'Gordon');
INSERT INTO jockey (first_name, last_name) VALUES ('A', 'Kirby');
INSERT INTO jockey (first_name, last_name) VALUES ('P', 'Hanagan');

INSERT INTO horse (age, name) VALUES ('4', 'Wediddodontwe');
INSERT INTO horse (age, name) VALUES ('4', 'Temeraire');
INSERT INTO horse (age, name) VALUES ('3', 'Rickyroadboy');
INSERT INTO horse (age, name) VALUES ('3', 'Shanghai Elastic');
INSERT INTO horse (age, name) VALUES ('5', 'Blond Bombshell');
INSERT INTO horse (age, name) VALUES ('5', 'Georges Boy');

insert into meeting (date, course_id) values ('07-02-2018', 2);

insert into race (time) values ('4:55');
insert into race (time) values ('5:25');

insert into meeting_races (meeting_id, races_id) values (1, 1);
insert into meeting_races (meeting_id, races_id) values (1, 2);

insert into race_entry (odds, weight, horse_id, jockey_id) values (2.5, '8-8', 1, 3);
insert into race_entry (odds, weight, horse_id, jockey_id) values (3.5, '8-9', 2, 4);
insert into race_entry (odds, weight, horse_id, jockey_id) values (4.5, '8-5', 3, 1);
insert into race_entry (odds, weight, horse_id, jockey_id) values (1.5, '8-8', 4, 2);

insert into race_race_entries (race_id, race_entries_id) values (1, 1);
insert into race_race_entries (race_id, race_entries_id) values (1, 2);
insert into race_race_entries (race_id, race_entries_id) values (2, 3);
insert into race_race_entries (race_id, race_entries_id) values (2, 4);