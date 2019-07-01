package com.atec.controller;


import com.atec.dto.EquipmentDTO;
import com.atec.model.Equipment;
import com.atec.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


	@GetMapping("/{id}")
	public Equipment getEquipmentById(@PathVariable(required = true) Long id){
		return equipmentService.getEquipmentById(id);
	}



	@PostMapping
	public void postEquipment(@RequestBody EquipmentDTO equipmentDTO) {
		equipmentService.add(equipmentDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) {
		equipmentService.delete(id);
	}
}
