package com.location.service;

import com.location.dto.EtudiantDto;
import com.location.dto.SalleDto;
import com.location.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SalleService {

    Optional<SalleDto> getSalleById(Long salleUuid) throws ItemNotFoundException;

    List<SalleDto> listSalle() ;

    void deleteSalle(Long id) ;

    void createSalle(SalleDto salleDto) ;

    Optional<SalleDto> updateSalle(Long id,SalleDto salleDto) throws Exception;
}
