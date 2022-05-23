package org.serratec.projeto03.mappers;

import org.serratec.projeto03.dtos.OperacaoDto;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.serratec.projeto03.models.OperacaoModel;
import org.serratec.projeto03.services.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperacaoMapper {
	
	@Autowired
	ContaBancariaService service;
	
	public OperacaoModel toModel(OperacaoDto operacaoDto) {
		
		OperacaoModel operacaoModel = new OperacaoModel();
		ContaBancariaModel contaBancaria = service.getOne(operacaoDto.getContaBancariaId());
		
		operacaoModel.setTipo(operacaoDto.getTipoOperacao());
		operacaoModel.setContaBancaria(contaBancaria);
		operacaoModel.setValor(operacaoDto.getValorOperacao());
		
		return operacaoModel;
	}

	public OperacaoDto toDto(OperacaoModel model) {
		
		OperacaoDto dto = new OperacaoDto();
		
		dto.setContaBancariaId(model.getContaBancaria().getId());
		dto.setTipoOperacao(model.getTipo());
		dto.setValorOperacao(model.getValor());
		
		return dto;
	}

}
