package com.location.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="note_Controlle")
    private Double noteControlle ;
    private  String noteUuid ;

    @ManyToOne
    private Etudiant student;

    @ManyToOne
    private Cours course;


}