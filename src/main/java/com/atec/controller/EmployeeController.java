package com.atec.controller;


import com.atec.dto.EmployeeDTO;
import com.atec.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping(value="/all")
	public ResponseEntity<List<EmployeeDTO>> getQuestions(){
		
		List<EmployeeDTO> employees = employeeService.getAll();
		if(employees.isEmpty()){
	       return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
	}
}
