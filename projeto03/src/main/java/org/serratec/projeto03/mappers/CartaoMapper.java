package org.serratec.projeto03.mappers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto03.dtos.CartaoRequestDto;
import org.serratec.projeto03.dtos.CartaoResponseDto;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.models.CartaoModel;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.serratec.projeto03.services.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoMapper {
	
	@Autowired
	ContaBancariaService contaBancariaService;
	
	public CartaoModel fomRequestDtoToModel(CartaoRequestDto dto) throws ItemNotFoundException {
		
		CartaoModel model = new CartaoModel();
		ContaBancariaModel conta = contaBancariaService.getOne(dto.getContaBancariaId());
		
		model.setContaBancaria(conta);
		model.setNumeroCartao(dto.getNumeroCartao());
		
		return model;
	}
	
	public CartaoResponseDto fromModelToResponseDto(CartaoModel model) {
		
		CartaoResponseDto dto = new CartaoResponseDto();
		
		dto.setCartaoId(model.getCartaoId());
		dto.setContaBancariaId(model.getContaBancaria().getId());
		dto.setListaOperacoesIds(model.getListaOperacoes());
		dto.setNumeroCartao(model.getNumeroCartao());
		
		return dto;
	}
	
	public List<CartaoResponseDto> fromModelListToDtoList(List<CartaoModel> cartoesModel){
		
		List<CartaoResponseDto> cartoesDto = new ArrayList<CartaoResponseDto>();
		
		for(CartaoModel cartaoModel : cartoesModel) {
			CartaoResponseDto dto = fromModelToResponseDto(cartaoModel);
			cartoesDto.add(dto);
		}
		
		return cartoesDto;
	}
}
