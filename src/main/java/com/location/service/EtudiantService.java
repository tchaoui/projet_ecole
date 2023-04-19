package com.location.service;

import com.location.dto.EtudiantDto;
import com.location.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    Optional<EtudiantDto> getEtudiantById(Long etudiantUuid) throws ItemNotFoundException;

    List<EtudiantDto> listEtudiant() ;

    void deleteEtudiant(Long id) ;

    void createEtudiant(EtudiantDto etudiant) ;

    Optional<EtudiantDto> updateEtudiant(Long id,EtudiantDto etudiant) throws Exception;
}
