package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.dtos.CartaoRequestDto;
import org.serratec.projeto03.dtos.CartaoResponseDto;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.mappers.CartaoMapper;
import org.serratec.projeto03.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
	
	@Autowired
	CartaoService service;
	
	@Autowired
	CartaoMapper mapper;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody CartaoRequestDto cartao) throws ItemNotFoundException {
		
		service.create(mapper.fomRequestDtoToModel(cartao));
		
		return ResponseEntity.ok("Cartão cadastrado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity<List<CartaoResponseDto>> getAll() {
		
		return ResponseEntity.ok(mapper.fromModelListToDtoList(service.getAll()));
				
	}

}
