package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.dtos.ClienteRequestDto;
import org.serratec.projeto03.dtos.ClienteResponseDto;
import org.serratec.projeto03.exceptions.CpfAlreadyExistsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IClienteController;
import org.serratec.projeto03.mappers.ClienteMapper;
import org.serratec.projeto03.models.ClienteModel;
import org.serratec.projeto03.services.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController implements IClienteController{
	
	@Autowired
	ClienteService service;
	
	@Autowired
	ClienteMapper clienteMapper;
	
	@Override
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ClienteRequestDto requestDto) throws ItemNotFoundException, CpfAlreadyExistsException {
		ClienteModel model = clienteMapper.fromRequestDtotoModel(requestDto);
		service.create(model);
		
		return new ResponseEntity<> (HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponseDto> getOne(@PathVariable Long id) throws ItemNotFoundException {
		
		ClienteModel cliente = service.getOne(id);
		
		return new ResponseEntity<ClienteResponseDto>(clienteMapper.fromModeltoResponseDto(cliente), HttpStatus.OK);
	}
	
	@Override
	@GetMapping
	public ResponseEntity<List<ClienteModel>> getAll() {
		
		List<ClienteModel> clientes = service.getAll();
		
		if(clientes == null ) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<ClienteModel> update(@PathVariable Long id, @RequestBody ClienteRequestDto cliente) 
			throws ItemNotFoundException {
		
		ClienteModel clienteAtualizado = service.update(id, clienteMapper.fromRequestDtotoModel(cliente));
		
		return new ResponseEntity<ClienteModel>(clienteAtualizado, HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws ItemNotFoundException {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}



}
