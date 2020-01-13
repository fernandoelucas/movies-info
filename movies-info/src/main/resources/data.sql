INSERT IGNORE INTO moviesdb.actor
(id,birth_place,birth_year,name)
VALUES(1,"USA","1974","Joaquin Phoenix");

INSERT IGNORE INTO moviesdb.actor
(id,birth_place,birth_year,name)
VALUES(2,"USA","1943","Robert De Niro");

INSERT IGNORE INTO moviesdb.actor
(id,birth_place,birth_year,name)
VALUES(3,"USA","1953","Frances Conroy");


INSERT IGNORE INTO moviesdb.director
(id,birth_place,birth_year,name)
VALUES(1,"USA","1970","Todd Phillips");

INSERT IGNORE INTO moviesdb.director
(id,birth_place,birth_year,name)
VALUES(2,"USA","1942 ","Martin Scorsese");


INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (1,"Action");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (2,"Adventure");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (3,"Comedy");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (4,"Crime/Gangster");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (5,"Drama");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (6,"Epics/Historical");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (7,"Horror");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (8,"Musicals/Dance");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (9,"Sci-Fi");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (10,"War");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (11,"Westerns");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (12,"Thriller");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (13,"Biography");
INSERT IGNORE INTO moviesdb.genre(id,name) VALUES (14,"Sport");


INSERT IGNORE INTO moviesdb.movie
(id,description,title,studio,year)
VALUES(1,
"In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
"Joker","Hollywood",2019);

INSERT IGNORE INTO moviesdb.movie
(id,description,title,studio,year)
VALUES(2,
"The life of boxer Jake LaMotta, whose violence and temper that led him to the top in the ring destroyed his life outside of it.",
"Raging Bull","Hollywood",2019);


INSERT IGNORE INTO moviesdb.movie_actor
(movies_id,actors_id)
VALUES(1,1);

INSERT IGNORE INTO moviesdb.movie_actor
(movies_id,actors_id)
VALUES(1,2);

INSERT IGNORE INTO moviesdb.movie_actor
(movies_id,actors_id)
VALUES(1,3);

INSERT IGNORE INTO moviesdb.movie_actor
(movies_id,actors_id)
VALUES(2,2);


INSERT IGNORE INTO moviesdb.movie_director
(movies_id,directors_id)
VALUES(1,1);

INSERT IGNORE INTO moviesdb.movie_director
(movies_id,directors_id)
VALUES(2,2);


INSERT IGNORE INTO moviesdb.movie_genre
(movies_id,genres_id)
VALUES(1,4);

INSERT IGNORE INTO moviesdb.movie_genre
(movies_id,genres_id)
VALUES(1,5);

INSERT IGNORE INTO moviesdb.movie_genre
(movies_id,genres_id)
VALUES(1,12);


INSERT IGNORE INTO moviesdb.movie_genre
(movies_id,genres_id)
VALUES(2,5);

INSERT IGNORE INTO moviesdb.movie_genre
(movies_id,genres_id)
VALUES(2,13);

INSERT IGNORE INTO moviesdb.movie_genre
(movies_id,genres_id)
VALUES(2,14);
