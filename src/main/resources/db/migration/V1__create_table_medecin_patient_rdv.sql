CREATE TABLE medecin (
                         id int(11) AUTO_INCREMENT PRIMARY KEY,
                         adresse varchar(255) DEFAULT NULL,
                         nom varchar(255) DEFAULT NULL,
                         prenom varchar(255) DEFAULT NULL,
                         specialite varchar(255) DEFAULT NULL
) ENGINE=InnoDB;


CREATE TABLE patient (
                         id int(11) AUTO_INCREMENT PRIMARY KEY,
                         age int(11) DEFAULT NULL,
                         nom varchar(255) DEFAULT NULL,
                         prenom varchar(255) DEFAULT NULL,
                         tel int(11) DEFAULT NULL
) ENGINE=InnoDB;


CREATE TABLE rdv (
                     id int(11) AUTO_INCREMENT PRIMARY KEY,
                     date_rdv datetime(6) DEFAULT NULL,
                     etat varchar(255) DEFAULT NULL,
                     medecin_id int(11) NOT NULL,
                     CONSTRAINT fk_rdv_medecin
                         FOREIGN KEY (medecin_id) REFERENCES medecin(id),
                     patient_id int(11) NOT NULL,
                     CONSTRAINT fk_rdv_patient
                         FOREIGN KEY (patient_id) REFERENCES patient(id)
) ENGINE=InnoDB;