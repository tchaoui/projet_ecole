package com.location.service;

import com.location.dto.CollegeDto;
import com.location.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CollegeService {

    Optional<CollegeDto> getCollegeById(Long collegeUuid) throws ItemNotFoundException;

    List<CollegeDto> listColleges() ;

    void deleteCollege(Long id) ;

    void createCollege(CollegeDto college) ;

    Optional<CollegeDto> updateCollege(Long id,CollegeDto college) throws Exception;
}
