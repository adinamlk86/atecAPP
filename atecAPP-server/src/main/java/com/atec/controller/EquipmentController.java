package com.atec.controller;


import com.atec.dto.EquipmentDTO;
import com.atec.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/api/equipment")
public class EquipmentController {

	@SuppressWarnings({"UnusedDeclaration"})
	@Autowired
	private EquipmentService equipmentService;

	@GetMapping(value="/all")
	public ResponseEntity<List<EquipmentDTO>> getEquipments(){
		
		List<EquipmentDTO> equipmentDTOList = equipmentService.getAll();
		if(equipmentDTOList.isEmpty()){
	       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(equipmentDTOList, HttpStatus.OK);
	}
}
