package com.location.service;


import com.location.dto.CoursDto;
import com.location.dto.DepartementDto;
import com.location.exception.ItemNotFoundException;
import com.location.mapper.CoursMapper;
import com.location.mapper.DepartementMapper;
import com.location.model.Cours;
import com.location.model.Departement;
import com.location.repository.CoursRepository;
import com.location.repository.DepartementRepository;
import com.location.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartementServiceImpl implements DepartementService {

    DepartementMapper departementMapper ;
    DepartementRepository departementRepository ;

    public DepartementServiceImpl( DepartementMapper departementMapper, DepartementRepository departementRepository ) {
        this.departementMapper= departementMapper ;
        this.departementRepository = departementRepository;
    }


    @Override
    public Optional<DepartementDto> getDepartementDtoById(Long DepartementUuid) throws ItemNotFoundException {
        Departement departement = departementRepository.findById(DepartementUuid).orElseThrow(() -> new ItemNotFoundException("personne","id")) ;
        return Optional.ofNullable(departementMapper.departementTodepartementDto(departement));
    }

    @Override
    public List<DepartementDto> listDepartementDto() {
        List<DepartementDto> listesDepartementDto = new ArrayList<>() ;
        List<Departement> listesDepartement =departementRepository.findAll();
        for (Departement d :listesDepartement){
            DepartementDto departementDto =  departementMapper.departementTodepartementDto(d);
            listesDepartementDto.add(departementDto);
        }

        return listesDepartementDto;
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public void createDepartement(DepartementDto departementDto) {

        UUID uuid = UUID.randomUUID();
        Departement departement =  departementMapper.departementDtoToDepartement(departementDto);
        // cours.setSalle(salleRepository.findByUuid(coursDto.getSalle().getUuid()));
        departement.setUuid(uuid);
        departementRepository.save(departement) ;
    }

    @Override
    public Optional<DepartementDto> updateDepartement(Long id, DepartementDto departementDto) throws Exception {
        Departement departement =  departementRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("cours","id"));
        if(!departement.getNom().equals(departement.getNom())){
            if(departementRepository.existsDepartementByNom(departement.getNom())){
                throw new Exception("department");
            }
        }
        departement = departementMapper.departementDtoToDepartement(departementDto);
        //cours.setUuid(coursDto.getUuid());
        departement.setCodeDepartement(id);
        departementRepository.save(departement) ;


        return Optional.ofNullable(departementDto);
    }
}
