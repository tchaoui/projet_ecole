package com.location.controller;


import com.location.dto.DepartementDto;
import com.location.dto.EnseignantDto;
import com.location.exception.ItemNotFoundException;
import com.location.repository.DepartementRepository;
import com.location.repository.EnseignantRepository;
import com.location.service.DepartementService;
import com.location.service.EnseignantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departement")
public class departementController {

    private DepartementRepository departementRepository;
    private DepartementService departementService ;

    public departementController( DepartementRepository departementRepository,DepartementService departementService ){
        this.departementRepository= departementRepository ;
        this.departementService= departementService ;
    }

    @GetMapping("/{numeroDepartement}")
    public ResponseEntity<DepartementDto> getDepartementId(@PathVariable("numeroDepartement") Long numeroDepartement) throws ItemNotFoundException {
        try {
            Optional<DepartementDto> departement = departementService.getDepartementDtoById(numeroDepartement) ;
            if (departement == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(departement.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/")
    public ResponseEntity<DepartementDto> addEnseignant(@RequestBody DepartementDto departementDto){
        departementService.createDepartement(departementDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartementDto>> getAllDepartement() {
        try {
            List<DepartementDto> departements = new ArrayList<DepartementDto>();
            departements =  departementService.listDepartementDto();
            if (departements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(departements, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deletDepartement (@PathVariable(name="id") Long numeroDepartement){
        departementService.deleteDepartement(numeroDepartement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartement(@PathVariable Long id,@RequestBody DepartementDto departementDto) throws Exception {
        departementService.updateDepartement(id,departementDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }
}
