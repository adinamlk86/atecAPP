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
@RequestMapping(value="/api/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	//@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping(value="/all")
	public ResponseEntity<List<ClientDTO>> getQuestions(){
		
		List<ClientDTO> clients = clientService.getAll();
		if(clients.isEmpty()){
	       return new ResponseEntity<List<ClientDTO>>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<List<ClientDTO>>(clients, HttpStatus.OK);
	}
}
