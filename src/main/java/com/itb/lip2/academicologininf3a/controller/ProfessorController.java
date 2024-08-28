package com.itb.lip2.academicologininf3a.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.lip2.academicologininf3a.model.Papel;
import com.itb.lip2.academicologininf3a.service.PapelService;




@RestController
@RequestMapping("/api/v2")
public class PapelController {
	
	@Autowired
	private PapelService papelService;
	
	@GetMapping("/papel")
	public ResponseEntity<List<Papel>> getPapel(){
		return ResponseEntity.ok(papelService.findAll());
	}
	
	@PostMapping("/papel")
	public ResponseEntity<Papel> savePapel(@RequestBody Papel papel){
		
		URI uri = URI.create(ServletUriComponentsBuilder .fromCurrentContextPath().path("/api/v2/papel").toUriString());
		
		return ResponseEntity.ok().body(papelService.save(papel));
		
		
	}
}
