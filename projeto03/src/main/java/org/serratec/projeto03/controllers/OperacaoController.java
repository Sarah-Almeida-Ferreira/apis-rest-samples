package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.interfaces.IOperacaoController;
import org.serratec.projeto03.models.OperacaoModel;
import org.serratec.projeto03.services.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacao/")
public class OperacaoController implements IOperacaoController{
	
	@Autowired
	OperacaoService service;

	@Override
	@PostMapping
	public ResponseEntity<String> create(@RequestBody OperacaoModel operacao) {
		service.create(operacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public OperacaoModel getOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OperacaoModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
