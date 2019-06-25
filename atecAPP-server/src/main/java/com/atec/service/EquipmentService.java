package com.atec.service;

import com.atec.dto.EquipmentDTO;
import com.atec.mapper.EquipmentMapper;
import com.atec.model.Equipment;
import com.atec.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    @Autowired
    private EquipmentMapper mapper;

    @Transactional(readOnly = true)
    public List<EquipmentDTO> getAll(){
        List<Equipment> dbEquipment = repository.findAll();

        return mapper.toEquipmentDTOs(dbEquipment);
    }


}
