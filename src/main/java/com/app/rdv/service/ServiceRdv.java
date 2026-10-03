package com.app.rdv.service;

import com.app.rdv.entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv {
    RdvRepository rdvRepository;

    @Override
    public Rdv ajoutRdv(Rdv rdv) {

        Optional<Rdv> rdv1 = rdvRepository.findByMedecinIdAndDateRdv(rdv.getMedecin().getId(),rdv.getDateRdv());
        Optional<Rdv> rdv2 = rdvRepository.findByPatientIdAndDateRdv(rdv.getPatient().getId(),rdv.getDateRdv());

        if(rdv1.isEmpty() && rdv2.isEmpty())
            return rdvRepository.save(rdv);
        else
            return null;

    }

    @Override
    public List<Rdv> getAllRdv() {
        return rdvRepository.findAll();
    }
}
