package com.app.rdv.controller;

import com.app.rdv.entities.Maladie;
import com.app.rdv.service.IServiceMaladie;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maladie")
@AllArgsConstructor
public class MaladieController {
    private IServiceMaladie iServiceMaladie;

    @GetMapping
    public List<Maladie> findAll(){
         return iServiceMaladie.getAllMaladies();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Maladie maladie){
        Maladie m = iServiceMaladie.addMaladie(maladie);
        if (m != null)
            return new ResponseEntity<>(maladie, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Cette maladie existe déja", HttpStatus.CONFLICT);

    }
}
