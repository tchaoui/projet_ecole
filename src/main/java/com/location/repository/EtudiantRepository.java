package com.location.repository;

import com.location.model.Etudiant;
import com.location.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    @Override
    Optional<Etudiant> findById(Long id);

    Boolean findByNom(String Nom) ;

    Boolean findByMail(String Mail) ;

    boolean existsEtudiantByMail(String mail);


    //  Optional<Etudiant> findByPersonneUuid(String etudiantUuid) ;
}
