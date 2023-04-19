package com.location.mapper;

import com.location.dto.CollegeDto;
import com.location.model.College;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CollegeMapper {

    CollegeDto collegeTocollegeDto(College college);

    College collegeDtoToCollege(CollegeDto collegeDto);

}
