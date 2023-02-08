package com.location.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="departement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="code_departement")
    private long codeDepartement ;
    @Column(name="cours_uuid")
    @NotBlank
    private  String coursUuid ;
    @Column(name="nom")
    private String nom ;
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<College> colleges;
}
