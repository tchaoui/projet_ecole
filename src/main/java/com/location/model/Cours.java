package com.location.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="numero_Cours")
    private Long numeroCours ;
    @Column(name="cours_Uuid")
    @NotBlank
    private  String coursUuid ;
    @Column(name="libelle_Cours")
    private String libelleCours ;

    @ManyToMany(mappedBy = "courses")
    private List<Enseignant> Enseignants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
}
