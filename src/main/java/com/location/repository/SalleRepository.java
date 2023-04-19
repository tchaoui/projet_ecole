package com.location.repository;

import com.location.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SalleRepository extends JpaRepository<Salle,Long> {

    @Override
    Optional<Salle> findById(Long id);
    Salle findByUuid(UUID id);

    Boolean findByNom(String Nom) ;


    boolean existsSalleByNom(String Nom);
}
