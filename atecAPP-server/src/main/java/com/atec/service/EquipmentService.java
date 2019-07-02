package com.atec.service;

import com.atec.dto.EquipmentDTO;
import com.atec.mapper.EquipmentMapper;
import com.atec.model.Client;
import com.atec.model.Equipment;
import com.atec.repository.ClientRepository;
import com.atec.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentService {

    private ClientRepository clientRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentMapper mapper;

    @Transactional(readOnly = true)
    public List<EquipmentDTO> getAll(){
        List<Equipment> dbEquipment = equipmentRepository.findAll();

        return mapper.toEquipmentDTOs(dbEquipment);
    }


    public Equipment getEquipmentById (Long id){
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(id);
        return optionalEquipment.orElseThrow(()-> new EquipmentNotFoundException("Couldn't find any equipment with that id."));
    }

    public Equipment add(EquipmentDTO equipmentDTO){

        Equipment newEquipment =this.mapper.toEquipment(equipmentDTO);
        this.equipmentRepository.save(newEquipment);

        return newEquipment;
    }


    public void delete(long id){
        equipmentRepository.deleteById(id);

    }

    public List<EquipmentDTO> getEquipmentByClient(Long clientId) throws NullPointerException{
        List<Equipment> equipmentList = new ArrayList<>();

        Client client = null;
        try {
            client = this.clientRepository.findById(clientId).orElseThrow(() -> {
                 return new NullPointerException();});
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(client!=null) {
            equipmentList = this.equipmentRepository.findAllByClientId(client.getId());
        }
            List<EquipmentDTO> equipmentDTOList = this.mapper.toEquipmentDTOs(equipmentList);

        return equipmentDTOList;

    }

}
