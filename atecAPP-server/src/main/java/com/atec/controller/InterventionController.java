package com.atec.controller;


import com.atec.dto.InterventionDTO;
import com.atec.service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/api/intervention")
public class InterventionController {

	@SuppressWarnings({"UnusedDeclaration"})
	@Autowired
	private InterventionService interventionService;

	@GetMapping(value="/all")
	public ResponseEntity<List<InterventionDTO>> getInterventions(){
		
		List<InterventionDTO> interventions = interventionService.getAll();
		if(interventions.isEmpty()){
	       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(interventions, HttpStatus.OK);
	}
}
