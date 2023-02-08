package com.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="enseignant")
@Data @AllArgsConstructor@NoArgsConstructor
@DiscriminatorValue("enseignant")
public class Enseignant  extends Personne {

    @Column(name="date_Prise_Fonction")
    private Date datePriseFonction ;
    @Column(name="indice")
    private int indice ;

    @ManyToMany
    @JoinTable(name = "enseignant_cours",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    private List<Cours> courses = new ArrayList<>();
}
