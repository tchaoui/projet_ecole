package com.location.model;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="cours")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="id")
    private Long id ;

    @Column(name="uuid")
    private UUID uuid ;

    @Column(name="libelle_Cours")
    private String libelleCours ;

    @ManyToMany(mappedBy = "courses")
    private List<Enseignant> Enseignants = new ArrayList<>();

    @JoinColumn(name = "salle_id")
    private Long salle_id;
}
