package com.atec.service;


import com.atec.dto.InterventionDTO;
import com.atec.mapper.InterventionMapper;
import com.atec.model.Intervention;
import com.atec.repository.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InterventionService {

    @Autowired
    private InterventionRepository repository;

    @Autowired
    private InterventionMapper mapper;

    @Transactional(readOnly = true)
    public List<InterventionDTO> getAll(){
        List<Intervention> dbIntervention = repository.findAll();

        return mapper.toInterventionDTOs(dbIntervention);
    }


}
