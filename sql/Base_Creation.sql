CREATE TABLE Film (
  film_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  acteur_principal VARCHAR(45) NOT NULL,
  realisateur VARCHAR(45) NOT NULL,
  support_id SMALLINT UNSIGNED NOT NULL,
  annee_sortie SMALLINT NOT NULL,
  PRIMARY KEY  (film_id),
   FOREIGN KEY (support_id) REFERENCES Support (support_id) 
) ;

CREATE TABLE Support (
  support_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  type_support VARCHAR(45) NOT NULL,
  PRIMARY KEY  (support_id)
) ;

CREATE TABLE Client (
  client_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  mail VARCHAR(45) NOT NULL,
  PRIMARY KEY  (client_id)
 
);

CREATE TABLE LocationFilm (
  location_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  client_id SMALLINT UNSIGNED NOT NULL,
  film_id SMALLINT UNSIGNED NOT NULL,
  date_location DATE,
  PRIMARY KEY  (location_id),
  FOREIGN KEY (client_id) REFERENCES Client (client_id),
  FOREIGN KEY (film_id) REFERENCES Film (film_id)
);



