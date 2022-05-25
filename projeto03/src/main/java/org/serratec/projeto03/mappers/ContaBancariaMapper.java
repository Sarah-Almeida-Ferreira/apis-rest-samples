package org.serratec.projeto03.mappers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto03.dtos.ContaBancariaRequestDto;
import org.serratec.projeto03.dtos.ContaBancariaResponseDto;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.models.ClienteModel;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.serratec.projeto03.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaBancariaMapper {
	
	@Autowired
	ClienteService clienteService;
	
	public ContaBancariaModel fromRequestDtoToModel(ContaBancariaRequestDto dto) throws ItemNotFoundException {
		
		ContaBancariaModel model = new ContaBancariaModel();
		ClienteModel titular = clienteService.getOne(dto.getTitularId());
		
		model.setSaldo(dto.getSaldo());
		model.setTitular(titular);
		
		return model;
	}
	
	public ContaBancariaRequestDto fromModelToRequestDto(ContaBancariaModel model) {
		
		ContaBancariaRequestDto dto = new ContaBancariaRequestDto();
		
		dto.setSaldo(model.getSaldo());
		dto.setTitularId(model.getTitular().getId());
		
		return dto;
	}
	
	public ContaBancariaResponseDto fromModelToResponseDto(ContaBancariaModel model) throws ItemNotFoundException {
		
		ContaBancariaResponseDto dto = new ContaBancariaResponseDto();
		
		dto.setContaBancariaId(model.getId());
		dto.setSaldo(model.getSaldo());
		dto.setTitularId(model.getTitular().getId());
		
		return dto;
		
	}
	
	public List<ContaBancariaResponseDto> findAllDtos(List<ContaBancariaModel> models) throws ItemNotFoundException{
		
		List<ContaBancariaResponseDto> allDtos = new ArrayList<ContaBancariaResponseDto>();
		
		for (ContaBancariaModel model : models) {
			
			ContaBancariaResponseDto dto = fromModelToResponseDto(model);
			
			allDtos.add(dto);
		}
		
		return allDtos;
		
	}
	
}
