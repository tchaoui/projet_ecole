package com.location.controller;


import com.location.dto.CoursDto;
import com.location.dto.EtudiantDto;
import com.location.exception.ItemNotFoundException;
import com.location.repository.CoursRepository;
import com.location.repository.EtudiantRepository;
import com.location.service.CoursService;
import com.location.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cours")
public class CoursController {


    private CoursService coursService ;
    private CoursRepository coursRepository;


    public CoursController( CoursService coursService ,CoursRepository coursRepository ){
        this.coursService= coursService ;
        this.coursRepository= coursRepository ;
    }

    @GetMapping("/{numeroCours}")
    public ResponseEntity<CoursDto> getCoursId(@PathVariable("numeroCours") Long numeroCours) throws ItemNotFoundException {
        try {
            Optional<CoursDto> etudiant = coursService.getCoursById(numeroCours) ;
            if (etudiant == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<CoursDto> addCours(@RequestBody CoursDto coursDto){
        coursService.createCours(coursDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<CoursDto>> getAllEtudiant() {
        try {
            List<CoursDto> Cours = new ArrayList<CoursDto>();
            Cours =  coursService.listCours();
            if (Cours.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Cours, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant (@PathVariable(name="id") Long numeroEtudiant){
        coursService.deleteCours(numeroEtudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCours(@PathVariable Long id,@RequestBody CoursDto coursDto) throws Exception {
        coursService.updateCours(id,coursDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }
}
