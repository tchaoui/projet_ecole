package com.location.mapper;

import com.location.dto.DepartementDto;
import com.location.model.Departement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartementMapper {
    DepartementDto departementTodepartementDto(Departement departement);

    Departement departementDtoToDepartement(DepartementDto departementDto);

}
