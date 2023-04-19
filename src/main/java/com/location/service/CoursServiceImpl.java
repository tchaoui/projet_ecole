package com.location.service;

import com.location.dto.CoursDto;
import com.location.dto.EnseignantDto;
import com.location.exception.ItemNotFoundException;
import com.location.mapper.CoursMapper;
import com.location.mapper.EnseignantMapper;
import com.location.model.Cours;
import com.location.model.Enseignant;
import com.location.repository.CoursRepository;
import com.location.repository.EnseignantRepository;
import com.location.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoursServiceImpl implements CoursService {

    SalleRepository salleRepository ;
    CoursMapper coursMapper ;
    CoursRepository coursRepository ;

    public CoursServiceImpl( CoursMapper coursMapper ,CoursRepository coursRepository,SalleRepository salleRepository ) {
        this.coursMapper= coursMapper ;
        this.coursRepository = coursRepository;
        this.salleRepository = salleRepository;
    }
    @Override
    public Optional<CoursDto> getCoursById(Long CoursUuid) throws ItemNotFoundException {
        Cours cours = coursRepository.findById(CoursUuid).orElseThrow(() -> new ItemNotFoundException("personne","id")) ;
        return Optional.ofNullable(coursMapper.coursTocourseDTO(cours));
    }

    @Override
    public List<CoursDto> listCours() {
        List<CoursDto> listesCoursDto = new ArrayList<>() ;
        List<Cours> listesCours =coursRepository.findAll();
        for (Cours c :listesCours){
            CoursDto coursDto =  coursMapper.coursTocourseDTO(c);
             listesCoursDto.add(coursDto);
        }

        return listesCoursDto;
    }

    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public void createCours(CoursDto coursDto) {
        UUID uuid = UUID.randomUUID();

        Cours cours =  coursMapper.coursDTOToCours(coursDto);
        // cours.setSalle(salleRepository.findByUuid(coursDto.getSalle().getUuid()));
        cours.setUuid(uuid);
        coursRepository.save(cours) ;
    }

    @Override
    public Optional<CoursDto> updateCours(Long id, CoursDto coursDto) throws Exception {
        Cours cours =  coursRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("cours","id"));
        if(!cours.getLibelleCours().equals(coursDto.getLibelleCours())){
            if(coursRepository.existsCoursByLibelleCours(coursDto.getLibelleCours())){
                throw new Exception("cours");
            }
        }
        cours = coursMapper.coursDTOToCours(coursDto);
        //cours.setUuid(coursDto.getUuid());
        //cours.setId(id);
        coursRepository.save(cours) ;


        return Optional.ofNullable(coursDto);
    }
}
