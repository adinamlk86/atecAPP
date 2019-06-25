package com.atec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atec.dto.ClientDTO;
import com.atec.service.ClientService;


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
}
