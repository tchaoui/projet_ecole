package com.location.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="personne")
@Data @AllArgsConstructor@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="numero_Personne")
    private long numeroPersonne ;
    @Column(name="nom")
    private String nom ;
    @Column(name="prenom")
    private String prenom ;
    @Column(name="tel")
    private String tel ;
    @Column(name="mail")
    private String mail ;

}
