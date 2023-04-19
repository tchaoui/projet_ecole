package com.location.controller;


import com.location.dto.EtudiantDto;
import com.location.dto.SalleDto;
import com.location.exception.ItemNotFoundException;
import com.location.repository.EtudiantRepository;
import com.location.repository.SalleRepository;
import com.location.service.EtudiantService;
import com.location.service.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salle")
public class SalleController {

    private SalleService salleService ;
    private SalleRepository salleRepository;


    public SalleController( SalleService salleService ,SalleRepository salleRepository ){
        this.salleRepository= salleRepository ;
        this.salleService= salleService ;
    }

    @GetMapping("/{numeroSalle}")
    public ResponseEntity<SalleDto> getSalleId(@PathVariable("numeroSalle") Long numeroSalle) throws ItemNotFoundException {
        try {
            Optional<SalleDto> salle = salleService.getSalleById(numeroSalle) ;
            if (salle == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(salle.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<SalleDto> addSalle(@RequestBody SalleDto salleDto){
        salleService.createSalle(salleDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<SalleDto>> getAllSalle() {
        try {
            List<SalleDto> salles = new ArrayList<SalleDto>();
            salles =  salleService.listSalle();
            if (salles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(salles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
   @DeleteMapping ("/{id}")
    public void deleteSalle (@PathVariable(name="id") Long numeroSalle){
       salleService.deleteSalle(numeroSalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSalle(@PathVariable Long id,@RequestBody SalleDto salleDto) throws Exception {
        salleService.updateSalle(id,salleDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }

}
