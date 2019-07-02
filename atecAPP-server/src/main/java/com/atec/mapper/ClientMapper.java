package com.atec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.atec.dto.ClientDTO;
import com.atec.model.Client;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper {

    // noOfEquipment:number    List<Equipment> equipmentList
   // @Mapping(expression = "java(equipmentList.size())",target = "noOfEquipment")
    ClientDTO toClientDTO(Client client);

    List<ClientDTO> toClientDTOs(List<Client> clients);

    Client toClient(ClientDTO clientDTO);

     default Client fromId(long id){
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
