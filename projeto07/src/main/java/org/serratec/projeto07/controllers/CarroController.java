package org.serratec.projeto07.controllers;

import java.util.List;

import org.serratec.projeto07.mappers.CarroMapper;
import org.serratec.projeto07.models.CarroModel;
import org.serratec.projeto07.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroService service;
	
	@Autowired
	CarroMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<CarroModel>> getAll() {
		
		return ResponseEntity.ok(service.getAll());
		
	}
	
}
