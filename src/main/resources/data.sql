-- DROP TABLE IF EXISTS advice;
-- DROP TABLE IF EXISTS cityes;

-- CREATE TABLE cityes
-- (
--     city_id LONG AUTO_INCREMENT NOT NULL PRIMARY KEY,
--     name    VARCHAR(250)        NOT NULL,
--     PRIMARY KEY (city_id)
-- );
--
-- CREATE TABLE advice
-- (
--     id      LONG AUTO_INCREMENT NOT NULL PRIMARY KEY,
--     city_id LONG                NOT NULL,
--     advice  VARCHAR(250)        NOT NULL,
--     FOREIGN KEY (city_id) REFERENCES cityes (city_id)
--
-- );

INSERT INTO CITYES (city_id, name)
VALUES (1,'New York'),
       (2,'San Francisco'),
       (3,'Washington');

INSERT INTO ADVICES (id, city_id, content)
VALUES (1,1, 'Go to Central Park'),
       (2,1, 'Go to Central Moll'),
       (3,2, 'Go to Selicon Valley'),
       (4,2, 'Not go to the ghetto'),
       (5,3, 'Go to Central Library');