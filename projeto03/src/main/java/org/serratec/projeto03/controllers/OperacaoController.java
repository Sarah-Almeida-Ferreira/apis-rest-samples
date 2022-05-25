package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.dtos.OperacaoRequestDto;
import org.serratec.projeto03.dtos.OperacaoResponseDto;
import org.serratec.projeto03.exceptions.InsufficientFundsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IOperacaoController;
import org.serratec.projeto03.mappers.OperacaoMapper;
import org.serratec.projeto03.models.OperacaoModel;
import org.serratec.projeto03.services.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacao")
public class OperacaoController implements IOperacaoController {

	@Autowired
	OperacaoService service;
	
	@Autowired
	OperacaoMapper mapper;
	
	@Override
	@PostMapping("/debito")
	public ResponseEntity<String> createDebito(@RequestBody OperacaoRequestDto operacao) throws ItemNotFoundException, InsufficientFundsException {
		
		service.createDebito(mapper.fomRequestDtoToModel(operacao));
		
		return ResponseEntity.ok("Operação efetuada com sucesso!");
	}

	@Override
	@PostMapping("/credito")
	public ResponseEntity<String> createCredito(@RequestBody OperacaoRequestDto operacao) throws ItemNotFoundException {
		
		service.createCredito(mapper.fomRequestDtoToModel(operacao));
		
		return ResponseEntity.ok("Operação efetuada com sucesso!");
	}

	@Override
	@GetMapping
	public ResponseEntity<List<OperacaoResponseDto>> getAll() throws ItemNotFoundException {
		
		List<OperacaoModel> operacoesModel = service.getAll();
		
		return ResponseEntity.ok(mapper.fromModelListToDtoList(operacoesModel));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<OperacaoResponseDto> getOne(@PathVariable Long id) throws ItemNotFoundException {
		
		OperacaoResponseDto operacao = mapper.fromModelToResponseDto(service.getOne(id));
		
		return ResponseEntity.ok(operacao);
	}	
	
}
