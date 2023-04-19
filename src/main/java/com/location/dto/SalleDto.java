package com.location.dto;

import com.location.model.Cours;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalleDto {

    private String nom ;
    private int capacite ;
    private UUID uuid ;
    private List<Cours> courses = new ArrayList<>();

}
