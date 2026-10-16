package com.app.rdv.service;

import com.app.rdv.dto.PatientDTO;
import com.app.rdv.entities.Maladie;
import com.app.rdv.entities.Patient;
import com.app.rdv.mapper.PatientMapper;
import com.app.rdv.repository.MaladieRepository;
import com.app.rdv.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePatient implements IServicePatient {
    PatientRepository patientRepository;
    MaladieRepository maladieRepository;
    PatientMapper patientMapper;

    @Override
    public Patient ajouterPatient(Patient patient) {
        patient.setMaladies(new ArrayList<>());
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(int id){
        return patientRepository.findById(id);
    }

    @Override
    public Optional<Patient> findByNumTel(Integer tel){
        return  patientRepository.findByTel(tel);
    }

    @Override
    @Transactional
    public PatientDTO addMaladieToPatient(Integer patientId, Integer maladieId){
        // 1. Le patient et la maladie doivent exister
        Optional<Patient> p = patientRepository.findById(patientId);
        Optional<Maladie> m = maladieRepository.findById(maladieId);

        if (p.isEmpty() || m.isEmpty())
            return null;

        // 2. Le patient ne doit pas déjà posséder cette maladie
        if (patientRepository.findByIdAndMaladiesId(patientId, maladieId).isPresent())
            return null;

        // 3. Ajout de la maladie à la liste du patient
        Patient patient = p.get();
        if (patient.getMaladies() == null)
            patient.setMaladies(new ArrayList<>());
        patient.getMaladies().add(m.get());

        return patientMapper.toDTO(patientRepository.save(patient));
    }

    @Override
    public List<PatientDTO> getPatientsByMaladieNom(String nomMaladie){
        // 1. La maladie doit exister dans la BD (sinon null)
        if (maladieRepository.findByNom(nomMaladie).isEmpty())
            return null;

        // 2. Récupérer les patients ayant cette maladie
        return patientMapper.toDTOList(patientRepository.findByMaladiesNom(nomMaladie));
    }
}


