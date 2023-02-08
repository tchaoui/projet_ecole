package com.location.model;

import jakarta.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="note_Controlle")
    private Double noteControlle ;

    @ManyToOne
    private Etudiant student;

    @ManyToOne
    private Cours course;


}