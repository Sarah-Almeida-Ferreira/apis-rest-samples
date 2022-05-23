package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.interfaces.IContaBancariaController;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.serratec.projeto03.services.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta-bancaria")
public class ContaBancariaController implements IContaBancariaController {

	@Autowired
	ContaBancariaService service;
	
	@Override
	@PostMapping
	public ResponseEntity<String> create(@RequestBody ContaBancariaModel contaBancaria) {
		
//		service.create(contaBancaria);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		
		if (!service.delete(id)) {
			return new ResponseEntity<>("Nenhuma conta bancária com id "+ id + " encontrada para deletar!",
				HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);	
	}

	@Override
	public ResponseEntity<String> update(Long Id, ContaBancariaModel contaBancariaAtualizada) {
		
		return null;
	}

	@Override
	public ResponseEntity<ContaBancariaModel> getOne(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ContaBancariaModel>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
