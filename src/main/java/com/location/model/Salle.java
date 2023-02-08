package com.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="salle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="numero_Salle")
    private long numeroSalle ;
    private String nom ;
    private int capacite ;
    @OneToMany(mappedBy = "salle")
    private List<Cours> courses = new ArrayList<>();
}
