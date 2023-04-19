package com.location.controller;

import com.location.dto.CollegeDto;
import com.location.exception.ItemNotFoundException;
import com.location.repository.CollegeRepositoy;
import com.location.service.CollegeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/college")
public class CollegeController {

    private CollegeRepositoy collegeRepositoy;
    private CollegeService collegeService ;

    public CollegeController( CollegeRepositoy collegeRepositoy,CollegeService collegeService){
        this.collegeRepositoy= collegeRepositoy ;
        this.collegeService= collegeService ;
    }

    @GetMapping("/{numeroDepartement}")
    public ResponseEntity<CollegeDto> getCollegeById(@PathVariable("numeroCollege") Long numeroCollege) throws ItemNotFoundException {
        try {
            Optional<CollegeDto> College = collegeService.getCollegeById(numeroCollege) ;
            if (College == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(College.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/")
    public ResponseEntity<CollegeDto> addCollege(@RequestBody CollegeDto collegeDto){
        collegeService.createCollege(collegeDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<CollegeDto>> getAllCollege() {
        try {
            List<CollegeDto> colleges = new ArrayList<CollegeDto>();
            colleges =  collegeService.listColleges();
            if (colleges.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(colleges, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deletCollege (@PathVariable(name="id") Long numeroCollege){
        collegeService.deleteCollege(numeroCollege);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCollege(@PathVariable Long id,@RequestBody CollegeDto collegeDto) throws Exception {
        collegeService.updateCollege(id,collegeDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
    }
}
