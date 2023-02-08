package com.location.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="college")
@Data@AllArgsConstructor@NoArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY )
    @Column(name="code_College")
    private long codeCollege ;
    @Column(name="college_Uuid")
    @NotBlank
    private  String collegeUuid ;


    @Column(name="nom")
    private String nom ;
    @Column(name="adresse_Site")
    private String adresseSite ;
    @ManyToOne
    private Departement departement;

}
