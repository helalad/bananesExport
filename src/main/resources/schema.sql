DROP TABLE IF EXISTS destinataire;

CREATE TABLE destinataire (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
   adresse VARCHAR(250) NOT NULL,
   code_postal INT NOT NULL,
    ville VARCHAR(250) NOT NULL,
    pays VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS commande;
CREATE TABLE commande (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fk_destinataire INT NOT NULL,
   date_livraison DATE NOT NULL,
   quantite INT NOT NULL,
      prix DOUBLE,
 FOREIGN KEY (fk_destinataire) REFERENCES destinataire(id)
);
