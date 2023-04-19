package com.location.repository;

import com.location.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DepartementRepository  extends JpaRepository<Departement, Long> {


    @Override
    Optional<Departement> findById(Long codeDepartement);

    Boolean existsDepartementByNom(String Nom) ;

   // Optional<Departement> findByDepartementUuid(String departementUuid) ;

}
