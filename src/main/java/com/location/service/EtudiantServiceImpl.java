package com.location.service;


import com.location.dto.EtudiantDto;
import com.location.exception.ItemNotFoundException;
import com.location.mapper.EtudiantMapper;
import com.location.model.Etudiant;
import com.location.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EtudiantServiceImpl implements EtudiantService {

    EtudiantMapper etudiantMapper ;
    EtudiantRepository etudiantRepository ;

    public EtudiantServiceImpl( EtudiantMapper etudiantMapper ,  EtudiantRepository etudiantRepository) {
        this.etudiantMapper = etudiantMapper;
        this.etudiantRepository = etudiantRepository;
    }


    public Optional<EtudiantDto> getEtudiantById(Long id) throws ItemNotFoundException {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("personne","id")) ;
        return Optional.ofNullable(etudiantMapper.etudiantToetudiantDTO(etudiant));
    }


    public List<EtudiantDto> listEtudiant() {
        List<EtudiantDto> listesEtudiantDto = new ArrayList<>() ;
        List<Etudiant>listesEtudiant=etudiantRepository.findAll();

        for (Etudiant e :listesEtudiant){
            EtudiantDto etudiantDto =  etudiantMapper.etudiantToetudiantDTO(e);
           // etudiantDto.setUuid(e.getUuid());
            listesEtudiantDto.add(etudiantDto);
        }

        return listesEtudiantDto;
    }

    public void deleteEtudiant(Long id) {

        etudiantRepository.deleteById(id);
    }

    public void createEtudiant(EtudiantDto etudiantDto) {
        UUID uuid = UUID.randomUUID();
        Etudiant etudiant =  etudiantMapper.etudiantDTOToEtudiant(etudiantDto);
        etudiant.setUuid(uuid);
        etudiantRepository.save(etudiant) ;
    }




    public Optional<EtudiantDto> updateEtudiant(Long id,EtudiantDto etudiantDto) throws Exception {
        Etudiant etudiant =  etudiantRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("enseignant","id"));
        if(!etudiant.getMail().equals(etudiantDto.getMail())){
            if(etudiantRepository.existsEtudiantByMail(etudiantDto.getMail())){
                throw new Exception("email");
            }
        }
        etudiant = etudiantMapper.etudiantDTOToEtudiant(etudiantDto);
        //etudiant.setId(id);
        etudiantRepository.save(etudiant) ;

        return Optional.ofNullable(etudiantDto);
    }





}
