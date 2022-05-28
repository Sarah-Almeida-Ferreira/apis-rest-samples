package org.serratec.projeto07.controllers;

import org.serratec.projeto07.dtos.ClienteDto;
import org.serratec.projeto07.mappers.CarroMapper;
import org.serratec.projeto07.mappers.ClienteMapper;
import org.serratec.projeto07.models.ClienteModel;
import org.serratec.projeto07.services.CarroService;
import org.serratec.projeto07.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	CarroService carroService;
	
	@Autowired
	ClienteMapper clienteMapper;
	
	@Autowired
	CarroMapper carroMapper;

	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ClienteDto cliente) {
		
		ClienteModel model = clienteService.create(clienteMapper.fromDtoToModel(cliente));
		
		carroService.create(carroMapper.fromDtoToModel(cliente.getCarros(), model.getId()));
		
		return ResponseEntity.ok("Cliente cadastrado com sucesso!");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> getOneById(@PathVariable Long id) {
		
		return ResponseEntity.ok(clienteMapper.fromModelToDto(clienteService.getOneById(id)));
	}
}
