CREATE SCHEMA IF NOT EXISTS moviesdb ;

CREATE TABLE  IF NOT EXISTS moviesdb.movie (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  duration varchar(255) DEFAULT NULL,
  title varchar(255) NOT NULL,
  studio varchar(255) DEFAULT NULL,
  year int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS moviesdb.actor (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  birth_place varchar(255) DEFAULT NULL,
  birth_year int(11) DEFAULT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS moviesdb.director (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  birth_place varchar(255) DEFAULT NULL,
  birth_year int(11) DEFAULT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS moviesdb.genre (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS moviesdb.movie_actor (
  actors_id bigint(20) NOT NULL,
  movies_id bigint(20) NOT NULL,
  PRIMARY KEY (actors_id,movies_id),
  KEY `FKqmw9v15rqts6gtym41veo9lwl` (movies_id),
  KEY `FKq4aqpwtxhyk1grvro2fs3c3wf` (actors_id),
  CONSTRAINT `FKq4aqpwtxhyk1grvro2fs3c3wf` FOREIGN KEY (actors_id) REFERENCES `actor` (id),
  CONSTRAINT `FKqmw9v15rqts6gtym41veo9lwl` FOREIGN KEY (movies_id) REFERENCES `movie` (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS moviesdb.movie_director (
  directors_id bigint(20) NOT NULL,
  movies_id bigint(20) NOT NULL,
  PRIMARY KEY (directors_id,movies_id),
  KEY `FKhk6nlch8dhmxu0wlnviqnws45` (movies_id),
  KEY `FKow7bimy4m22uxo92g7gw5emcf` (directors_id),
  CONSTRAINT `FKhk6nlch8dhmxu0wlnviqnws45` FOREIGN KEY (`movies_id`) REFERENCES movie (id),
  CONSTRAINT `FKow7bimy4m22uxo92g7gw5emcf` FOREIGN KEY (`directors_id`) REFERENCES director (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS moviesdb.movie_genre (
  genres_id bigint(20) NOT NULL,
  movies_id bigint(20) NOT NULL,
  PRIMARY KEY (genres_id,movies_id),
  KEY `FK34ujopj3hkrgvyp7cu1nr55r2` (movies_id),
  KEY `FKq5hm1eatlm393m5l822o2nro8` (genres_id),
  CONSTRAINT `FK34ujopj3hkrgvyp7cu1nr55r2` FOREIGN KEY (movies_id) REFERENCES movie (id),
  CONSTRAINT `FKq5hm1eatlm393m5l822o2nro8` FOREIGN KEY (genres_id) REFERENCES genre (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
