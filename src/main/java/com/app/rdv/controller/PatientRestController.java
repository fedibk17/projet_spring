package com.app.rdv.controller;


import com.app.rdv.dto.PatientDTO;
import com.app.rdv.entities.Patient;
import com.app.rdv.mapper.PatientMapper;
import com.app.rdv.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient/")
@AllArgsConstructor
public class PatientRestController {

    private IServicePatient iServicePatient;
    private PatientMapper patientMapper;

    @PostMapping("add")
    public Patient add(@RequestBody Patient patient) {
        return iServicePatient.ajouterPatient(patient);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable int id) {
        return iServicePatient.getPatientById(id)
                .map(p -> new ResponseEntity<>(patientMapper.toDTO(p), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("tel")
    public ResponseEntity<Patient> findByTel(@RequestParam Integer tel){
        Optional<Patient> p = iServicePatient.findByNumTel(tel);

        if(p.isPresent())
            return new ResponseEntity<>(p.get(), HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("maladie")
    public ResponseEntity<?> findByMaladie(@RequestParam String nom) {
        List<PatientDTO> patients = iServicePatient.getPatientsByMaladieNom(nom);
        if (patients != null)
            return new ResponseEntity<>(patients, HttpStatus.OK);
        else
            return new ResponseEntity<>("Cette maladie n'existe pas", HttpStatus.NOT_FOUND);
    }
    @PostMapping("{patientId}/patient/{maladieId}")
    public ResponseEntity<?> addMaladieToPatient(@PathVariable int patientId,
                                                 @PathVariable int maladieId) {
        PatientDTO dto = iServicePatient.addMaladieToPatient(patientId, maladieId);
        if (dto != null)
            return new ResponseEntity<>(dto, HttpStatus.OK);
        else
            return new ResponseEntity<>(
                    "Maladie déjà associée au patient",
                    HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public List<PatientDTO> findAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size) {
        return iServicePatient.allPatients(page, size);
    }

}
