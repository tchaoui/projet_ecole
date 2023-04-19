package com.location.mapper;


import com.location.dto.EnseignantDto;

import com.location.model.Enseignant;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnseignantMapper {
    EnseignantDto enseignantToenseignantDTO(Enseignant enseignant);

    Enseignant enseignantDTOToEnseignant(EnseignantDto enseignantDto);



}
