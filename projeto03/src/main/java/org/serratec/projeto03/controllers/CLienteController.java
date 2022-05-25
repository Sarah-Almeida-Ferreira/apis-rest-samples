package org.serratec.projeto03.controllers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto03.dtos.ClienteRequestDto;
import org.serratec.projeto03.dtos.ClienteResponseDto;
import org.serratec.projeto03.exceptions.ItemAlreadyExistsException;
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
public class ClienteController implements IClienteController {
	
	@Autowired
	ClienteService service;
	
	@Autowired
	ClienteMapper mapper;

	@Override
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ClienteRequestDto cliente) throws ItemAlreadyExistsException {
		
		ClienteModel clienteCriado = mapper.fromRequestDtoToModel(cliente);
		
		service.create(clienteCriado);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@Override
	@GetMapping
	public ResponseEntity<List<ClienteResponseDto>> getAll() {
		
		List<ClienteModel> clientesModels = service.getAll();
		List<ClienteResponseDto> clientesDtos = new ArrayList<ClienteResponseDto>();
		
		for(ClienteModel clienteModel : clientesModels) {
			clientesDtos.add(mapper.fromModelToResponseDto(clienteModel));
		}
		
		return ResponseEntity.ok(clientesDtos);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponseDto> getOne(@PathVariable Long id) throws ItemNotFoundException {
		
		ClienteModel cliente = service.getOne(id);
				
		return ResponseEntity.ok(mapper.fromModelToResponseDto(cliente));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponseDto> update(@PathVariable Long id, @RequestBody ClienteRequestDto clienteDto) throws ItemNotFoundException, ItemAlreadyExistsException {
		
		ClienteModel cliente = mapper.fromRequestDtoToModel(clienteDto);
		
		cliente = service.update(id, cliente);
		
		return ResponseEntity.ok(mapper.fromModelToResponseDto(cliente));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws ItemNotFoundException {
		service.delete(id);
		return ResponseEntity.ok("Cliente deletado com sucesso");
	}


}
