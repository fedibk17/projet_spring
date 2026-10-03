package com.app.rdv.service;

import com.app.rdv.entities.Rdv;

import java.util.List;

public interface IServiceRdv {
    Rdv ajoutRdv(Rdv rdv);
    List<Rdv> getAllRdv();
}
