package com.atec.controller;


import com.atec.dto.NoticeDTO;
import com.atec.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/api/notice")
public class NoticeController {

	@SuppressWarnings({"UnusedDeclaration"})
	@Autowired
	private NoticeService noticeService;

	@GetMapping(value="/all")
	public ResponseEntity<List<NoticeDTO>> geNotices(){
		
		List<NoticeDTO> notices = noticeService.getAll();
		if(notices.isEmpty()){
	       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(notices, HttpStatus.OK);
	}
}
