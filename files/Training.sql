-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de donnees                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Training;
CREATE DATABASE Training;
USE Training;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
	IdUser				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Login				varchar(20)	NOT NULL UNIQUE,
	Password			varchar(20)	NOT NULL,
	Admin				boolean     
) ENGINE = InnoDB;

INSERT INTO T_Users (IdUser, Login, Password, Admin) VALUES ( 1, 'Jack' ,	'Sparrow' , true );
INSERT INTO T_Users (IdUser, Login, Password, Admin) VALUES ( 2, 'Hector',	'Barbossa' , false );
INSERT INTO T_Users (IdUser, Login, Password, Admin) VALUES ( 3, 'Elizabeth' ,	'Swann', false );
INSERT INTO T_Users (IdUser, Login, Password, Admin) VALUES ( 4, 'William'   ,	'Turner', false );
INSERT INTO T_Users (IdUser, Login, Password, Admin) VALUES ( 5, 'Davy'     ,	'Jones', false );

SELECT * FROM T_Users;

-- -----------------------------------------------------------------------------
-- - Construction de la table des clients	                                 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Customers (
	IdCustomer				int(4)		PRIMARY KEY AUTO_INCREMENT,
	LastName				varchar(30)	NOT NULL,
	FirstName				varchar(30)	NOT NULL,
	Email 					varchar(30)	NOT NULL unique,
	Phone 					varchar(20)	,
	Address					varchar(50)	,
	IdUser					int(4)		NOT NULL,
	FOREIGN KEY (idUser)	REFERENCES T_Users(idUser)
) ENGINE = InnoDB;

INSERT INTO T_Customers (IdCustomer, LastName, FirstName, Email, Phone, Address, IdUser) VALUES ( 1, 'Davy' ,	'Jones' , 'davy.jones@pirate.com', '0697325483', 'Black pearl' ,5);

SELECT * FROM T_Customers;

-- -----------------------------------------------------------------------------
-- - Construction de la table des categories de formations				  	 ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Categories (
	IdCategory 				INT(4) 		 PRIMARY KEY AUTO_INCREMENT,
	CategoryName 			VARCHAR(40)  NOT NULL,
	Description 			VARCHAR(500) NOT NULL
	
) ENGINE = InnoDB;

insert into T_Categories (IdCategory, CategoryName, Description) values (1 , 'Developpement web front-end' , 'Formation axee sur le developpement de la partie visible des sites web, notamment la creation d interfaces utilisateur et la programmation de l experience utilisateur en utilisant des langages tels que HTML, CSS et JavaScript.');
insert into T_Categories (IdCategory, CategoryName, Description) values (2 , 'Developpement web back-end' , 'Formation axee sur la creation de la partie serveur des sites web, y compris la gestion de base de donnees, la creation de serveurs web et la programmation cote serveur en utilisant des langages tels que Java, Python, C ou PHP.');
insert into T_Categories (IdCategory, CategoryName, Description) values (3 , 'Administration systeme' , 'Formation axee sur la gestion des systemes informatiques, y compris la configuration, la maintenance et la surveillance des serveurs et des reseaux informatiques.');
insert into T_Categories (IdCategory, CategoryName, Description) values (4 , 'Securite informatique' , 'Formation axee sur la securite des systemes et des sites web, y compris la protection contre les attaques, la gestion des vulnerabilites et la conformite aux reglementations de securite.');

select * from t_categories;

-- -----------------------------------------------------------------------------
-- - Construction de la table des formations en vente                        ---
-- -----------------------------------------------------------------------------
-- Duration -> en semaine

CREATE TABLE T_Trainings (
	IdTraining				int(4)		PRIMARY KEY AUTO_INCREMENT,
	TrainingName			VARCHAR(50)  NOT NULL,
	Description				varchar(500)	NOT NULL,
	UnitaryPrice			float(8)	NOT NULL DEFAULT 0,
	Quantity				int(4)		NOT NULL DEFAULT 0,
	Duration				int(4)		NOT NULL,
	Distential				boolean 	,
	IdCategory				int(4),
	FOREIGN KEY (IdCategory)	REFERENCES T_Categories(IdCategory)
) ENGINE = InnoDB;

INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'Java debutant', 'Formation axee sur les bases de la programmation en Java, y compris la syntaxe, la POO et la gestion de fichiers.', 2500, 5, 2, true, 2 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'App de bureau Java', 'Formation axee sur la creation d applications de bureau en utilisant Java et le framework Swing pour creer des interfaces utilisateur graphiques.', 2800, 10, 2, true, 2 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'App mobiles Android Java', 'Formation axee sur le developpement d applications mobiles Android en utilisant Java et l Android SDK, avec des competences en creation d interfaces utilisateur et en integration de fonctionnalites telles que la geolocalisation.', 4000, 2, 3, false, 2 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'App web Java', 'Formation axee sur le developpement d applications web en utilisant Java, y compris la creation de servlets, la gestion des sessions utilisateur et l integration de bases de donnees en utilisant JDBC.', 3200, 15, 2, false, 2 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'HTML, CSS et JavaScript', 'Formation axee sur les competences de base pour la creation de pages web, y compris la structure HTML, la mise en forme CSS et l interaction utilisateur JavaScript.', 7800, 30, 4, true, 1 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'React', 'Formation axee sur la creation d interfaces utilisateur avec la bibliotheque React, y compris la creation de composants, la gestion de l etat et la connexion a une API pour recuperer des donnees.', 6000, 13, 4, false, 1 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'Linux', 'Formation axee sur les competences de base pour l administration de systemes Linux, y compris la gestion des utilisateurs, la configuration reseau et la securite.', 5000, 9, 3, false, 3 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'Bases de donnees', 'Formation axee sur l administration de systemes Windows Server, y compris la gestion des utilisateurs, la configuration du reseau et la securite.', 4700, 8, 3, true, 3 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'Windows Server', 'Formation axee sur l administration de bases de donnees, y compris la creation de tables, la gestion des utilisateurs et la maintenance de la base de donnees.', 4000, 7, 3, true, 3 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'S. des reseaux informatiques', 'Formation axee sur la securite des reseaux informatiques, y compris la configuration des pare-feux, la detection des intrusions et la mise en place de politiques de securite.', 12000, 20, 5, true, 4 );
INSERT INTO T_Trainings (TrainingName, Description, UnitaryPrice, Quantity, Duration, Distential, IdCategory ) VALUES ( 'S. des applications web', 'Formation axee sur la securite des applications web, y compris la detection des vulnerabilites, la protection contre les attaques par injection et la mise en place de politiques de securite pour les applications web.', 11000, 6, 5, false, 4 );

SELECT * FROM T_Trainings;

-- -----------------------------------------------------------------------------
-- - Construction de la table des commandes en vente                         ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Orders (
	IdOrder				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Amount				float(4)	NOT NULL DEFAULT 0,
	DateOrder 			DATE		NOT NULL DEFAULT NOW(),
	IdCustomer          INT(4)   	NOT NULL,
	FOREIGN KEY(IdCustomer) REFERENCES T_Customers(IdCustomer)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Construction de la table des elements de commande en vente              ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Order_Items (
	IdOrderItem			int(4)	PRIMARY KEY AUTO_INCREMENT,
	
	IdTraining           INT(4)   NOT NULL,
	FOREIGN KEY(IdTraining) REFERENCES T_Trainings(IdTraining),
	
	Quantity			FLOAT(4) NOT NULL DEFAULT 1,
	UnitaryPrice		FLOAT(4)	NOT NULL DEFAULT 0,
	
	IdOrder             INT(4)   NOT NULL,
	FOREIGN KEY(IdOrder) REFERENCES T_Orders(IdOrder)
) ENGINE = InnoDB;