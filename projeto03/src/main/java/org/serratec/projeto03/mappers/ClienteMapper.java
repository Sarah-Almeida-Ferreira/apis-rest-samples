package org.serratec.projeto03.mappers;

import org.serratec.projeto03.dtos.ClienteRequestDto;
import org.serratec.projeto03.dtos.ClienteResponseDto;
import org.serratec.projeto03.interfaces.IClienteRepository;
import org.serratec.projeto03.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	public ClienteModel fromRequestDtotoModel(ClienteRequestDto clienteDto) {
		
		ClienteModel clienteModel = new ClienteModel();
		
		clienteModel.setNome(clienteDto.getNome());
		clienteModel.setCpf(clienteDto.getCpf());
		
		return clienteModel;
	}
	
	public ClienteModel fromResponseDtotoModel(ClienteResponseDto clienteDto) {
		
		ClienteModel clienteModel = new ClienteModel();
		
		clienteModel.setNome(clienteDto.getNome());
		clienteModel.setCpf(clienteDto.getCpf());
		
		return clienteModel;
	}

	public ClienteResponseDto fromModeltoResponseDto(ClienteModel clienteModel) {
		
		ClienteResponseDto clienteDto = new ClienteResponseDto();
		
		clienteDto.setCpf(clienteModel.getCpf());
		clienteDto.setNome(clienteModel.getNome());
		
		return clienteDto;
		
	}

}
