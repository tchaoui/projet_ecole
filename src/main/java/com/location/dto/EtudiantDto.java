package com.location.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto  {

    private Date anneeEntree ;
    private String nom ;
    private String prenom ;
    private String mail ;
    private String tel ;
    private UUID uuid ;
}
