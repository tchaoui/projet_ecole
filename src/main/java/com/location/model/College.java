package com.location.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name ="college")
@Data@AllArgsConstructor@NoArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="code_College")
    private long codeCollege ;

    @Column(name="uuid")
    private UUID uuid ;

    @Column(name="nom")
    private String nom ;
    @Column(name="adresse_Site")
    private String adresseSite ;
    @ManyToOne
    private Departement departement;

}
