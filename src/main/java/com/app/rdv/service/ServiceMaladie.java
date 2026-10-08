package com.app.rdv.service;

import com.app.rdv.entities.Maladie;
import com.app.rdv.repository.MaladieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceMaladie implements IServiceMaladie{
    MaladieRepository maladieRepository;

    @Override
    public Maladie addMaladie(Maladie maladie){
        Optional<Maladie> m = maladieRepository.findByNom(maladie.getNom());
        if (m.isEmpty())
            return maladieRepository.save(maladie);
        else
            return null;
    }

    @Override
    public List<Maladie> getAllMaladies(){
        return maladieRepository.findAll();
    }

    @Override
    public Optional<Maladie> getMaladieByNom(String nom){
        return maladieRepository.findByNom(nom);
    }

    @Override
    public Optional<Maladie> getMaladieById(int id){
        return maladieRepository.findById(id);
    }
}
