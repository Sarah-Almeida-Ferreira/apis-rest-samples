package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.dtos.ClienteRequestDto;
import org.serratec.projeto03.dtos.ClienteResponseDto;
import org.serratec.projeto03.exceptions.ItemAlreadyExistsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;

public interface IClienteController {
	
	public ResponseEntity<String> create(ClienteRequestDto cliente) throws ItemAlreadyExistsException;
	public ResponseEntity<List<ClienteResponseDto>> getAll();
	public ResponseEntity<ClienteResponseDto>  getOne(Long id) throws ItemNotFoundException;
	public ResponseEntity<ClienteResponseDto> update(Long id, ClienteRequestDto cliente) throws ItemNotFoundException, ItemAlreadyExistsException;
	public ResponseEntity<String> delete(Long id) throws ItemNotFoundException;
	
}
