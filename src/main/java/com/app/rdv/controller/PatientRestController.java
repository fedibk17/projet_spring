package com.app.rdv.controller;


import com.app.rdv.entities.Patient;
import com.app.rdv.service.IServicePatient;
import lombok.AllArgsConstructor;
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

    @GetMapping
    public List<Patient> findAll() {
        return iServicePatient.getAllPatients();
    }

    @PostMapping("add")
    public Patient add(@RequestBody Patient patient) {
        return iServicePatient.ajouterPatient(patient);
    }

    @GetMapping("tel")
    public ResponseEntity<Patient> findByTel(@RequestParam Integer tel){
        Optional<Patient> p = iServicePatient.findByNumTel(tel);

        if(p.isPresent())
            return new ResponseEntity<>(p.get(), HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
