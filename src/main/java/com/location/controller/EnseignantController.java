package com.location.controller;


import com.location.dto.EnseignantDto;
import com.location.exception.ItemNotFoundException;
import com.location.repository.EnseignantRepository;
import com.location.service.EnseignantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/teacher")
public class EnseignantController {


    private EnseignantRepository enseignantRepository;
    private EnseignantService enseignantService ;

    public EnseignantController( EnseignantRepository enseignantRepository,EnseignantService enseignantService ){
        this.enseignantService= enseignantService ;
        this.enseignantRepository= enseignantRepository ;
    }

    @GetMapping("/{numeroEnseignant}")
    public ResponseEntity<EnseignantDto> getEnseignantId(@PathVariable("numeroEnseignant") Long numeroEnseignant) throws ItemNotFoundException {
        try {
            Optional<EnseignantDto> enseignant = enseignantService.getEnseignantById(numeroEnseignant) ;
            if (enseignant == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(enseignant.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<EnseignantDto> addEnseignant(@RequestBody EnseignantDto enseignantDto){
        enseignantService.createEnseignant(enseignantDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<EnseignantDto>> getAllEnseignant() {
        try {
            List<EnseignantDto> enseignants = new ArrayList<EnseignantDto>();
            enseignants =  enseignantService.listEnseignant();
            if (enseignants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(enseignants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deletEenseignant (@PathVariable(name="id") Long numeroEnseignant){
        enseignantService.deleteEnseignant(numeroEnseignant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnseignant(@PathVariable Long id,@RequestBody EnseignantDto enseignantDto) throws Exception {
        enseignantService.updateEnseignant(id,enseignantDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }
}
