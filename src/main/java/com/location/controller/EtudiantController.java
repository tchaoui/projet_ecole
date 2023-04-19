package com.location.controller;


import com.location.dto.EnseignantDto;
import com.location.dto.EtudiantDto;
import com.location.exception.ItemNotFoundException;
import com.location.repository.EtudiantRepository;
import com.location.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/student")
public class EtudiantController {

    private EtudiantService etudiantService ;
    private EtudiantRepository etudiantRepository;


    public EtudiantController( EtudiantService etudiantService ,EtudiantRepository etudiantRepository ){
        this.etudiantRepository= etudiantRepository ;
        this.etudiantService= etudiantService ;
    }

    @GetMapping("/{numeroEtudiant}")
    public ResponseEntity<EtudiantDto> getEnseignantId(@PathVariable("numeroEtudiant") Long numeroEtudiant) throws ItemNotFoundException {
        try {
            Optional<EtudiantDto> etudiant = etudiantService.getEtudiantById(numeroEtudiant) ;
            if (etudiant == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<EtudiantDto> addEtudiant(@RequestBody EtudiantDto etudiantDto){
        etudiantService.createEtudiant(etudiantDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<EtudiantDto>> getAllEtudiant() {
        try {
            List<EtudiantDto> etudiants = new ArrayList<EtudiantDto>();
            etudiants =  etudiantService.listEtudiant();
            if (etudiants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etudiants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant (@PathVariable(name="id") Long numeroEtudiant){
        etudiantService.deleteEtudiant(numeroEtudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEtudiant(@PathVariable Long id,@RequestBody EtudiantDto etudiantDto) throws Exception {
        etudiantService.updateEtudiant(id,etudiantDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }
}
