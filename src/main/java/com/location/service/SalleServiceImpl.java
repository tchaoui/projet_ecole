package com.location.service;




import com.location.dto.SalleDto;
import com.location.exception.ItemNotFoundException;
import com.location.mapper.SalleMapper;
import com.location.model.Salle;
import com.location.repository.SalleRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalleServiceImpl implements SalleService{

    SalleMapper salleMapper ;
    SalleRepository salleRepository ;

    public SalleServiceImpl( SalleMapper salleMapper ,   SalleRepository salleRepository) {
        this.salleMapper = salleMapper;
        this.salleRepository = salleRepository;
    }

    public Optional<SalleDto> getSalleById(Long id) throws ItemNotFoundException {
        Salle salle = salleRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("personne","id")) ;
        return Optional.ofNullable(salleMapper.salleTosalleDto(salle));
    }

    public List<SalleDto> listSalle() {
        List<SalleDto> listesSalleDto = new ArrayList<>() ;
        List<Salle> listesSalle = salleRepository.findAll();

        for (Salle s :listesSalle){
            SalleDto salleDto =  salleMapper.salleTosalleDto(s);
           // salleDto.setUuid(s.getUuid());
            listesSalleDto.add(salleDto);
        }

        return listesSalleDto;
    }



    public void deleteSalle(Long id) {

        salleRepository.deleteById(id);
    }

    public void createSalle(SalleDto salleDto) {
        UUID uuid = UUID.randomUUID();
        Salle salle =  salleMapper.salleDtoToSalle(salleDto);
        salle.setUuid(uuid);
        salleRepository.save(salle) ;
    }
    public Optional<SalleDto> updateSalle(Long id,SalleDto salleDto) throws Exception {
        Salle salle =  salleRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("salle","id"));
        if(!salle.getNom().equals(salleDto.getNom())){
            if(salleRepository.existsSalleByNom(salleDto.getNom())){
                throw new Exception("nom");
            }
        }
        salle = salleMapper.salleDtoToSalle(salleDto);
       salle.setSalle_id(id);
        salleRepository.save(salle) ;


        return Optional.ofNullable(salleDto);
    }

}
