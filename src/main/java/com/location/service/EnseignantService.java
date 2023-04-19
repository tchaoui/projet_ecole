package com.location.service;

import com.location.dto.EnseignantDto;
import com.location.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EnseignantService {
    Optional<EnseignantDto> getEnseignantById(Long EnseignantUuid) throws ItemNotFoundException;

    List<EnseignantDto> listEnseignant() ;

    void deleteEnseignant(Long id) ;

    void createEnseignant(EnseignantDto enseignant) ;

    Optional<EnseignantDto> updateEnseignant(Long id ,EnseignantDto enseignant) throws Exception;
}
