package com.location.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="salle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="numero_Salle")
    private long salle_id ;
    private String nom ;
    private int capacite ;
    private UUID uuid ;
    @OneToMany
    private List<Cours> courses = new ArrayList<>();
}
