package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.dtos.ContaBancariaRequestDto;
import org.serratec.projeto03.dtos.ContaBancariaResponseDto;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IContaBancariaController;
import org.serratec.projeto03.mappers.ContaBancariaMapper;
import org.serratec.projeto03.mappers.OperacaoMapper;
import org.serratec.projeto03.services.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ContaBancaria")
public class ContaBancariaController implements IContaBancariaController {
	
	@Autowired
	ContaBancariaMapper mapper;
	
	@Autowired
	OperacaoMapper operacaoMapper;
	
	@Autowired
	ContaBancariaService service;	
	
	@Override
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ContaBancariaRequestDto conta) throws ItemNotFoundException {

		service.create(mapper.fromRequestDtoToModel(conta));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	@GetMapping
	public ResponseEntity<List<ContaBancariaResponseDto>> getAll() throws ItemNotFoundException {
		
		List<ContaBancariaResponseDto> allContas = mapper.findAllDtos(service.getAll());
		
		return ResponseEntity.ok(allContas);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<ContaBancariaRequestDto> getOne(@PathVariable Long id) throws ItemNotFoundException {
		
		ContaBancariaRequestDto contaBancaria = mapper.fromModelToRequestDto(service.getOne(id));
		
		return ResponseEntity.ok(contaBancaria);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ContaBancariaRequestDto contaBancariaAtualizada)
			throws ItemNotFoundException {
		
		service.update(id, mapper.fromRequestDtoToModel(contaBancariaAtualizada));
		
		return ResponseEntity.ok("Conta atualizada com sucesso");
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws ItemNotFoundException {
	
		service.delete(id);
		
		return ResponseEntity.ok("Conta excluída com sucesso");
	}
	
}
