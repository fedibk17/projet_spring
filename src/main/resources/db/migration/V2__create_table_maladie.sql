CREATE TABLE maladie (
                         id int(11) AUTO_INCREMENT PRIMARY KEY,
                         description varchar(255) DEFAULT NULL,
                         nom varchar(255) NOT NULL
) ENGINE=InnoDB;


ALTER TABLE maladie
    ADD UNIQUE KEY `UKajv0473pxd4n4vuny0544hdf4` (nom);


CREATE TABLE patient_maladies (
                                  patient_id int(11) NOT NULL,
                                  CONSTRAINT fk_maladies_patient
                                      FOREIGN KEY (patient_id) REFERENCES patient(id),
                                  maladies_id int(11) NOT NULL,
                                  CONSTRAINT fk_maladies_maladie
                                      FOREIGN KEY (maladies_id) REFERENCES maladie(id)
) ENGINE=InnoDB;


ALTER TABLE patient_maladies
    ADD KEY `fk_maladies_maladie` (maladies_id),
  ADD KEY `fk_maladies_patient` (patient_id);