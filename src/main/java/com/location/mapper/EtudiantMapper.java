package com.location.mapper;


import com.location.dto.EtudiantDto;
import com.location.model.Etudiant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

    EtudiantDto etudiantToetudiantDTO(Etudiant etudiant);

    Etudiant etudiantDTOToEtudiant(EtudiantDto etudiantDto);

}
