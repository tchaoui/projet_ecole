package com.location.repository;

import com.location.model.College;
import com.location.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepositoy extends JpaRepository<College, Long> {
    Optional<College>  findByCodeCollege(Long codeCollege);

    @Override
    Optional<College> findById(Long codeCollege);

    Boolean existsCollegeByNom(String Nom) ;

   // Optional<College> findByCollegeUuid(String collegeUuid) ;
}
