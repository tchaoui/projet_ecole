package com.location.repository;

import com.location.model.Cours;
import com.location.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoursRepository extends JpaRepository<Cours, Long> {

   // Optional<Cours> findByNumeroCours(Long numeroCours);

    @Override
    Optional<Cours> findById(Long numeroCours);

    Boolean existsCoursByLibelleCours(String libelleCours) ;


    Optional<Cours> findByUuid(String coursUuid) ;
}
