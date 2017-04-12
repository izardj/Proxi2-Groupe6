#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Client
#------------------------------------------------------------

CREATE TABLE Client(
        id_client      int (11) Auto_increment  NOT NULL ,
        nom            Varchar (50) NOT NULL ,
        prenom         Varchar (50) NOT NULL ,
        adresse        Varchar (100) NOT NULL ,
        code_postal    Varchar (25) NOT NULL ,
        ville          Varchar (50) NOT NULL ,
        telephone      Varchar (25) NOT NULL ,
        entreprise     Bool NOT NULL ,
        nom_entreprise Varchar (25) ,
        email          Varchar (50) NOT NULL ,
        id_conseiller  Int NOT NULL ,
        PRIMARY KEY (id_client )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Compte
#------------------------------------------------------------

CREATE TABLE Compte(
        id_compte      int (11) Auto_increment  NOT NULL ,
        num_compte     Int NOT NULL ,
        solde          Double NOT NULL ,
        date_ouverture Varchar (25) NOT NULL ,
        remuneration   Double ,
        decouvert      Double ,
        type_compte    Varchar (25) NOT NULL ,
        id_client      Int NOT NULL ,
        PRIMARY KEY (id_compte )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Conseiller
#------------------------------------------------------------

CREATE TABLE Conseiller(
        id_conseiller int (11) Auto_increment  NOT NULL ,
        nom           Varchar (50) NOT NULL ,
        prenom        Varchar (50) NOT NULL ,
        adresse       Varchar (100) NOT NULL ,
        code_postal   Varchar (25) NOT NULL ,
        ville         Varchar (50) NOT NULL ,
        telephone     Varchar (25) NOT NULL ,
        login         Varchar (50) NOT NULL ,
        pwd           Varchar (50) NOT NULL ,
        PRIMARY KEY (id_conseiller )
)ENGINE=InnoDB;

ALTER TABLE Client ADD CONSTRAINT FK_Client_id_conseiller FOREIGN KEY (id_conseiller) REFERENCES Conseiller(id_conseiller);
ALTER TABLE Compte ADD CONSTRAINT FK_Compte_id_client FOREIGN KEY (id_client) REFERENCES Client(id_client);
