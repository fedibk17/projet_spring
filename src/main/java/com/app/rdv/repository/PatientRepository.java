package com.app.rdv.repository;

import com.app.rdv.entities.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByTel (int tel);
    Optional<Patient> findByIdAndMaladiesId(Integer patientId, Integer maladiesId);
    List<Patient> findByMaladiesNom(String nom);

    @EntityGraph(attributePaths = {"maladies"})
    List<Patient> findAll();
}
