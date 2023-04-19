package com.location.dto;

import com.location.model.Enseignant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursDto {

    private String libelleCours ;

    private UUID uuid ;

    private List<Enseignant> Enseignants = new ArrayList<>();

    private Long salle_id;
}
