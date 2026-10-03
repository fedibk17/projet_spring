package com.app.rdv.service;

import com.app.rdv.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface IServicePatient {
    Patient ajouterPatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> findByNumTel (Integer tel);
}
