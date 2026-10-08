package com.app.rdv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private Integer age;
    private Integer tel;
    @ManyToMany
    private List<Maladie> maladies;
}
