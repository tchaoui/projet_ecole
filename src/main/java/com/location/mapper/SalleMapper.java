package com.location.mapper;



import com.location.dto.SalleDto;
import com.location.model.Salle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalleMapper {
    SalleDto salleTosalleDto(Salle salle);

    Salle salleDtoToSalle(SalleDto salleDto);

}
