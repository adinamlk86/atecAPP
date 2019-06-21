package com.atec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.atec.dto.ClientDTO;
import com.atec.model.Client;

@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper {

	ClientDTO toClientDTO(Client client);

    List<ClientDTO> toClientDTOs(List<Client> clients);

    Client toClient(ClientDTO clientDTO);
}
