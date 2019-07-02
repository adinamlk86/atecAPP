package com.atec.service;

import java.util.List;
import java.util.Optional;

import com.atec.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atec.dto.ClientDTO;
import com.atec.mapper.ClientMapper;
import com.atec.model.Client;
import com.atec.repository.ClientRepository;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientRepository repository;


	//@Qualifier("clientMapper")
	@Autowired
	private ClientMapper mapper;
	
	
	@Transactional(readOnly = true)
	public List<ClientDTO> getAll(){
		List<Client> dbClients = repository.findAll();
		
		return mapper.toClientDTOs(dbClients);		
	}

	public Client getClientById (Long id){
		Optional<Client> optionalClient = repository.findById(id);
		return optionalClient.orElseThrow(()-> new ClientNotFoundException("Couldn't find a client with that id."));
	}

	public Client add(ClientDTO clientDTO){

		Client newClient =this.mapper.toClient(clientDTO);
		this.repository.save(newClient);

		return newClient;
	}

	public void delete(long id){
		repository.deleteById(id);

	}

}
