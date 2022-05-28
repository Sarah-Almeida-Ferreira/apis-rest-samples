package org.serratec.projeto03.mappers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto03.dtos.OperacaoRequestDto;
import org.serratec.projeto03.dtos.OperacaoResponseDto;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.models.CartaoModel;
import org.serratec.projeto03.models.OperacaoModel;
import org.serratec.projeto03.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperacaoMapper {
	
	@Autowired
	CartaoService cartaoService;
	
	public OperacaoModel fomRequestDtoToModel(OperacaoRequestDto dto) throws ItemNotFoundException {
		
		OperacaoModel model = new OperacaoModel();
		CartaoModel cartao = cartaoService.getOne(dto.getCartaoId());
		
		model.setCartao(cartao);
		model.setValorOperacao(dto.getValorOperacao());
		
		return model;
	}
	
	public OperacaoResponseDto fromModelToResponseDto(OperacaoModel model) {
		
		OperacaoResponseDto dto = new OperacaoResponseDto();
		
		dto.setIdOperacao(model.getIdOperacao());
		dto.setContaBancariaId(model.getCartao().getContaBancaria().getId());
		dto.setTipoOperacao(model.getTipoOperacao());
		dto.setValorOperacao(model.getValorOperacao());
		dto.setDataOperacao(model.getDataOperacao());
		
		return dto;
	}
	
	public List<OperacaoResponseDto> fromModelListToDtoList(List<OperacaoModel> operacoesModel){
		
		List<OperacaoResponseDto> operacoesDto = new ArrayList<OperacaoResponseDto>();
		
		for(OperacaoModel operacaomodel : operacoesModel) {
			OperacaoResponseDto dto = fromModelToResponseDto(operacaomodel);
			operacoesDto.add(dto);
		}
		
		return operacoesDto;
	}
	
	
}
