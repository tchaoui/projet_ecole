package com.location.repository;

import com.location.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {

    @Override
    Optional<Enseignant> findById(Long id);

    Optional<Enseignant> findByMail(String Mail);

    Boolean getByNom(String Nom) ;

    Boolean getByMail(String Mail) ;

    Optional<Enseignant> findByUuid(UUID uuid);

    boolean existsEnseignantByMail(String mail);

    // Optional<Enseignant> findByEnseignantUuid(String enseignantUuid) ;
}
