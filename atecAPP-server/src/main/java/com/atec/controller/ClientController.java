package com.atec.controller;

import com.atec.dto.ClientDTO;
import com.atec.mapper.ClientMapper;
import com.atec.model.Client;
import com.atec.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/client")
public class ClientController {

	@SuppressWarnings({"UnusedDeclaration"})
	@Autowired
	private ClientService clientService;

	@GetMapping(value="/all")
	public ResponseEntity<List<ClientDTO>> getClients(){
		
		List<ClientDTO> clients = clientService.getAll();
		if(clients.isEmpty()){
	       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Client getClientById(@PathVariable(required = true) Long id){
		return clientService.getClientById(id);
	}

	@PostMapping
	public void postClient(@RequestBody ClientDTO clientDTO) {
		clientService.add(clientDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) {
		clientService.delete(id);
	}
}
