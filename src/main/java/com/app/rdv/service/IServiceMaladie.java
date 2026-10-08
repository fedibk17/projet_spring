package com.app.rdv.service;

import com.app.rdv.entities.Maladie;

import java.util.List;
import java.util.Optional;


public interface IServiceMaladie {
    Maladie addMaladie(Maladie maladie);
    List<Maladie> getAllMaladies();
    Optional<Maladie> getMaladieByNom(String nom);
    Optional<Maladie> getMaladieById(int id);
}
