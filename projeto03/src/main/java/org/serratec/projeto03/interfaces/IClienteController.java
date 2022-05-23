package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.dtos.ClienteRequestDto;
import org.serratec.projeto03.dtos.ClienteResponseDto;
import org.serratec.projeto03.exceptions.CpfAlreadyExistsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.models.ClienteModel;
import org.springframework.http.ResponseEntity;

public interface IClienteController {
	
	public ResponseEntity<String> create(ClienteRequestDto requestDto) throws ItemNotFoundException, CpfAlreadyExistsException;
	public ResponseEntity<ClienteModel> update(Long id, ClienteRequestDto cliente) throws ItemNotFoundException;
	public ResponseEntity<String> delete(Long id) throws ItemNotFoundException;
	public ResponseEntity<ClienteResponseDto>  getOne(Long id) throws ItemNotFoundException;
	public ResponseEntity<List<ClienteModel>> getAll();

}
