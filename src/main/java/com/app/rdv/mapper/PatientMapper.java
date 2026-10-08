package com.app.rdv.mapper;

import com.app.rdv.dto.PatientDTO;
import com.app.rdv.entities.Patient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientMapper {
    public Patient toEntity (PatientDTO dto){
        Patient patient = new Patient();

        patient.setId(dto.getId());
        patient.setNom(dto.getNom());
        patient.setPrenom(dto.getPrenom());
        patient.setTel(dto.getTel());

        return patient;
    }
    public PatientDTO toDTO(Patient patient){
        PatientDTO dto = new PatientDTO();

        dto.setId(patient.getId());
        dto.setNom(patient.getNom());
        dto.setPrenom(patient.getPrenom());
        dto.setTel(patient.getTel());

        return dto;}
    public List<PatientDTO> toDTOList(List<Patient> patients){
        return patients.stream()
            .map(this::toDTO)
            .toList();
    }
}

