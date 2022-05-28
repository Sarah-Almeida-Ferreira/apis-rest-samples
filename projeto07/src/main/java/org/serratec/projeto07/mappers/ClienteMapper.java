package org.serratec.projeto07.mappers;

import org.serratec.projeto07.dtos.ClienteDto;
import org.serratec.projeto07.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
	
	@Autowired
	CarroMapper carroMapper;
	
	public ClienteModel fromDtoToModel(ClienteDto dto) {
		
		ClienteModel model = new ClienteModel();
		
		model.setCpf(dto.getCpf());
		model.setEmail(dto.getEmail());
		model.setNome(dto.getNome());
		model.setTelefone(dto.getTelefone());
		
		return model;
	}
	
	public ClienteDto fromModelToDto(ClienteModel model) {
		
		ClienteDto dto = new ClienteDto();
		
		dto.setCpf(model.getCpf());
		dto.setEmail(model.getEmail());
		dto.setNome(model.getNome());
		dto.setTelefone(model.getCpf());
		dto.setCarros(carroMapper.fromModelToDto(model.getCarros()));
		
		return dto;
		
	}
	
}
