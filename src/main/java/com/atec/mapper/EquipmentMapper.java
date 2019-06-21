package com.atec.mapper;


import com.atec.dto.EquipmentDTO;

import com.atec.model.Equipment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface EquipmentMapper {

    EquipmentDTO toEquipmentDTO(Equipment equipment);


    List<EquipmentDTO> toEquipmentDTOs(List<Equipment> equipment);


    Equipment toEquipment(EquipmentDTO equipmentDTO);
}
