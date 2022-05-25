package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.dtos.ContaBancariaRequestDto;
import org.serratec.projeto03.dtos.ContaBancariaResponseDto;
import org.serratec.projeto03.dtos.OperacaoResponseDto;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;

public interface IContaBancariaController {
	
	public ResponseEntity<String> create(ContaBancariaRequestDto conta) throws ItemNotFoundException;
	public ResponseEntity<List<ContaBancariaResponseDto>> getAll() throws ItemNotFoundException;
	public ResponseEntity<ContaBancariaRequestDto>  getOne(Long id) throws ItemNotFoundException;
	public ResponseEntity<List<OperacaoResponseDto>> getOperacoesByContaId(Long id) throws ItemNotFoundException;
	public ResponseEntity<String> update(Long id, ContaBancariaRequestDto cliente) throws ItemNotFoundException;
	public ResponseEntity<String> delete(Long id) throws ItemNotFoundException;
}
