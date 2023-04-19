package com.location.service;

import com.location.dto.EnseignantDto;
import com.location.exception.ItemNotFoundException;
import com.location.mapper.EnseignantMapper;
import com.location.model.Enseignant;
import com.location.repository.EnseignantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnseignantServiceImpl implements EnseignantService{

    EnseignantMapper enseignantMapper ;
    EnseignantRepository enseignantRepository ;

    public EnseignantServiceImpl( EnseignantMapper enseignantMapper ,EnseignantRepository enseignantRepository) {
        this.enseignantMapper= enseignantMapper ;
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public Optional<EnseignantDto> getEnseignantById(Long id) throws ItemNotFoundException {
        Enseignant enseignant = enseignantRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("personne","id")) ;
        return Optional.ofNullable(enseignantMapper.enseignantToenseignantDTO(enseignant));
    }


    @Override
    public List<EnseignantDto> listEnseignant() {
        List<EnseignantDto> listesEnseignantDto = new ArrayList<>() ;
        List<Enseignant>listesEnseignant=enseignantRepository.findAll();

        for (Enseignant e :listesEnseignant){
            EnseignantDto enseignantDto =  enseignantMapper.enseignantToenseignantDTO(e);
           // enseignantDto.setUuid(e.getUuid());
            listesEnseignantDto.add(enseignantDto);
        }

        return listesEnseignantDto;
    }

    @Override
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    @Override
    public void createEnseignant(EnseignantDto enseignantDto) {
        UUID uuid = UUID.randomUUID();
       // enseignantDto.setUuid(uuid);
        Enseignant enseignant =  enseignantMapper.enseignantDTOToEnseignant(enseignantDto);
        enseignant.setUuid(uuid);
        enseignantRepository.save(enseignant) ;
    }
    /*@Override
    public Optional<EnseignantDto> updateEnseignant(EnseignantDto enseignant) throws Exception {
        enseignantRepository .findByMail(enseignantMapper.enseignantDTOToEnseignant(enseignant).getMail())// returns Optional<User>
                .ifPresent(enseignant1 -> {
                    enseignant1 = enseignantMapper.enseignantDTOToEnseignant(enseignant);
                    enseignant1.setUuid(enseignant.getUuid());
                    enseignantRepository.save(enseignant1);
                });
        return Optional.ofNullable(enseignant);
    }*/

    @Override
    public Optional<EnseignantDto> updateEnseignant(Long id,EnseignantDto enseignant) throws Exception {
        Enseignant ensaignantentity =  enseignantRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("enseignant","id"));
        if(!ensaignantentity.getMail().equals(enseignant.getMail())){
            if(enseignantRepository.existsEnseignantByMail(enseignant.getMail())){
                throw new Exception("email");
            }
        }
        ensaignantentity = enseignantMapper.enseignantDTOToEnseignant(enseignant);
        ensaignantentity.setId(id);
        enseignantRepository.save(ensaignantentity) ;


        return Optional.ofNullable(enseignant);
    }


}
