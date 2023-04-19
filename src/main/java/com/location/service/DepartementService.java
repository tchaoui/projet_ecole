package com.location.service;

import com.location.dto.DepartementDto;
import com.location.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartementService {

    Optional<DepartementDto> getDepartementDtoById(Long DepartementUuid) throws ItemNotFoundException;

    List<DepartementDto> listDepartementDto() ;

    void deleteDepartement(Long id) ;

    void createDepartement(DepartementDto departementDto) ;

    Optional<DepartementDto> updateDepartement(Long id , DepartementDto departementDto) throws Exception;
}
