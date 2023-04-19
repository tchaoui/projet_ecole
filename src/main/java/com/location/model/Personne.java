package com.location.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

//@Entity
//@Table(name ="personne")
@Data @AllArgsConstructor@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "person_type")
@MappedSuperclass
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="id")
    private long id;

    @Column(name="nom")
    private String nom ;

    @Column(name="prenom")
    private String prenom ;

    @Column(name="tel")
    private String tel ;

    @Column(name="mail")
    private String mail ;

   /* @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )*/
   @Column(name="uuid")
    private UUID uuid ;

}
