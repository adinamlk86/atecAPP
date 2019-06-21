package com.atec.service;

import java.util.List;

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
	
	
	@Autowired
	private ClientMapper mapper;
	
	
	@Transactional(readOnly = true)
	public List<ClientDTO> getAll(){
		List<Client> dbClients = repository.findAll();
		
		return mapper.toClientDTOs(dbClients);		
	}

}
