package com.atec.mapper;


import com.atec.dto.EquipmentDTO;
import com.atec.model.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface EquipmentMapper {

    @Mapping(source = "client.id", target ="clientId")
    EquipmentDTO toEquipmentDTO(Equipment equipment);


    List<EquipmentDTO> toEquipmentDTOs(List<Equipment> equipment);

    @Mapping(source = "clientId", target ="client")
    Equipment toEquipment(EquipmentDTO equipmentDTO);

    default Equipment fromId(long id){
        Equipment equipment = new Equipment();
        equipment.setId(id);
        return equipment;
    }

}
