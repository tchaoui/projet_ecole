package com.location.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

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

    //@Column(name="uuid")
    private UUID uuid ;

    @Column(name="nom")
    private String nom ;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<College> colleges;
}
