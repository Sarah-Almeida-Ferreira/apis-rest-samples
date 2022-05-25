package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.dtos.OperacaoRequestDto;
import org.serratec.projeto03.dtos.OperacaoResponseDto;
import org.serratec.projeto03.exceptions.InsufficientFundsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;

public interface IOperacaoController {
	
	public ResponseEntity<String> createDebito(OperacaoRequestDto operacao) throws ItemNotFoundException, InsufficientFundsException;
	public ResponseEntity<String> createCredito(OperacaoRequestDto operacao) throws ItemNotFoundException;
	public ResponseEntity<List<OperacaoResponseDto>> getAll() throws ItemNotFoundException;
	public ResponseEntity<OperacaoResponseDto>  getOne(Long id) throws ItemNotFoundException;
	
}
