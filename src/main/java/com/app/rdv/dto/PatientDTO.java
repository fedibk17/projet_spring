package com.app.rdv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private int id;
    private String nom;
    private String prenom;
    private Integer age;
    private Integer tel;
    private List<String> maladies;
}
