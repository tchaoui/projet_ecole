package com.location.service;


import com.location.dto.CollegeDto;
import com.location.exception.ItemNotFoundException;
import com.location.mapper.CollegeMapper;
import com.location.model.College;
import com.location.repository.CollegeRepositoy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CollegeServiceImpl  implements CollegeService{
    CollegeMapper collegeMapper ;
    CollegeRepositoy collegeRepositoy ;

    public CollegeServiceImpl( CollegeMapper collegeMapper ,CollegeRepositoy collegeRepositoy) {
        this.collegeMapper= collegeMapper ;
        this.collegeRepositoy = collegeRepositoy;
    }


    @Override
    public Optional<CollegeDto> getCollegeById(Long id) throws ItemNotFoundException {
        College college = collegeRepositoy.findById(id).orElseThrow(() -> new ItemNotFoundException("college","id")) ;
        return Optional.ofNullable(collegeMapper.collegeTocollegeDto(college));
    }

    @Override
    public List<CollegeDto> listColleges() {
        List<CollegeDto> listesCollegeDto = new ArrayList<>() ;
        List<College> listesCollege = collegeRepositoy.findAll();

        for (College c :listesCollege){
            CollegeDto collegeDto =  collegeMapper.collegeTocollegeDto(c);
            listesCollegeDto.add(collegeDto);
        }

        return listesCollegeDto;
    }

    @Override
    public void deleteCollege(Long id) {
        collegeRepositoy.deleteById(id);
    }

    @Override
    public void createCollege(CollegeDto collegeDto) {
        UUID uuid = UUID.randomUUID();
        College college =  collegeMapper.collegeDtoToCollege(collegeDto);
        college.setUuid(uuid);
        collegeRepositoy.save(college) ;


    }

    @Override
    public Optional<CollegeDto> updateCollege(Long id,CollegeDto collegeDto) throws Exception {
        College college =  collegeRepositoy.findById(id).orElseThrow(() -> new ItemNotFoundException("enseignant","id"));
        if(!college.getNom().equals(collegeDto.getNom())){
            if(collegeRepositoy.existsCollegeByNom(collegeDto.getNom())){
                throw new Exception("email");
            }
        }
        college = collegeMapper.collegeDtoToCollege(collegeDto);
        //ensaignantentity.setUuid(enseignant.getUuid());
        //college.setCodeCollege(id);
        collegeRepositoy.save(college) ;


        return Optional.ofNullable(collegeDto);
    }
}
