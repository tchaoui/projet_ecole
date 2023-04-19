package com.location.mapper;



import com.location.dto.CoursDto;
import com.location.model.Cours;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CoursMapper {

    CoursDto coursTocourseDTO(Cours cours);

    Cours coursDTOToCours(CoursDto coursDto);

}
