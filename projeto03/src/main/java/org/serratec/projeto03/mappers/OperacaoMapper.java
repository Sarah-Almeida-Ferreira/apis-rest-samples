package org.serratec.projeto03.mappers;

import org.serratec.projeto03.dtos.OperacaoDto;
import org.serratec.projeto03.models.OperacaoModel;
import org.springframework.beans.factory.annotation.Autowired;

public class OperacaoMapper {
	
	@Autowired
	
	
	public OperacaoModel toEntity(OperacaoDto dto) {
		OperacaoModel model = new OperacaoModel();
		
		model.setTipo(null);
		model.setContaBancaria(null);
		model.setValor(null);
		
		return model;
	}

	public OperacaoDto toDto(OperacaoModel model) {
		OperacaoDto dto = new OperacaoDto();

		return dto;
	}

}
