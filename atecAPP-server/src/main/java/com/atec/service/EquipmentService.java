package com.atec.service;

import com.atec.dto.EquipmentDTO;
import com.atec.mapper.EquipmentMapper;
import com.atec.model.Equipment;
import com.atec.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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


    public Equipment getEquipmentById (Long id){
        Optional<Equipment> optionalEquipment = repository.findById(id);
        return optionalEquipment.orElseThrow(()-> new EquipmentNotFoundException("Couldn't find any equipment with that id."));
    }

    public Equipment add(EquipmentDTO equipmentDTO){

        Equipment newEquipment =this.mapper.toEquipment(equipmentDTO);
        this.repository.save(newEquipment);

        return newEquipment;
    }


    public void delete(long id){
        repository.deleteById(id);

    }


}
