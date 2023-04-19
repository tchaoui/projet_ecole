package com.location.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name ="etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorValue("etudiant")
public class Etudiant extends Personne {

    @Column(name="annee_Entree")
    private Date anneeEntree ;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Note> notes;
}


