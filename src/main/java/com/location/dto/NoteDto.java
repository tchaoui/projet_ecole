package com.location.dto;

import com.location.model.Cours;
import com.location.model.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

    private Double noteControlle ;

    private Etudiant student;

    private Cours course;

    private  String noteUuid ;
}
