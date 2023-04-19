package com.location.service;

import com.location.dto.CoursDto;
import com.location.dto.EnseignantDto;
import com.location.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CoursService {
    Optional<CoursDto> getCoursById(Long CoursUuid) throws ItemNotFoundException;

    List<CoursDto> listCours() ;

    void deleteCours(Long id) ;

    void createCours(CoursDto coursDto) ;

    Optional<CoursDto> updateCours(Long id , CoursDto coursDto) throws Exception;
}
