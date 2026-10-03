package com.app.rdv.repository;

import com.app.rdv.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.naming.ldap.Rdn;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface RdvRepository extends JpaRepository<Rdv,Integer> {
    Optional <Rdv> findByMedecinIdAndDateRdv(int medecinId, LocalDateTime date);
    Optional <Rdv> findByPatientIdAndDateRdv(int patientId, LocalDateTime date);
}
