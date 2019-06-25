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
@RequestMapping(value="/api/employee")
public class EmployeeController {

	@SuppressWarnings({"UnusedDeclaration"})
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value="/all")
	public ResponseEntity<List<EmployeeDTO>> getEmployees(){
		
		List<EmployeeDTO> employees = employeeService.getAll();
		if(employees.isEmpty()){
	       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
