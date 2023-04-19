package com.location.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnseignantDto {
    private String nom ;
    private String prenom ;
    private String mail ;
    private String tel ;
    private Date datePriseFonction ;
    private int indice ;
    private UUID uuid ;
}
