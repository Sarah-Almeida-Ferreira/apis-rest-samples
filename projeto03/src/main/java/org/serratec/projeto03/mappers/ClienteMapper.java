package org.serratec.projeto03.mappers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto03.dtos.ClienteRequestDto;
import org.serratec.projeto03.dtos.ClienteResponseDto;
import org.serratec.projeto03.interfaces.IClienteRepository;
import org.serratec.projeto03.models.ClienteModel;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	public ClienteModel fromRequestDtotoModel(ClienteRequestDto clienteDto) {
		
		ClienteModel clienteModel = new ClienteModel();
		
		clienteModel.setCpf(clienteDto.getCpf());
		clienteModel.setNome(clienteDto.getNome());
		clienteModel.setContasBancarias(null);
		
		return clienteModel;
	}

	public ClienteResponseDto fromModelToResponseDto(ClienteModel clienteModel) {
		
		ClienteResponseDto clienteDto = new ClienteResponseDto();
		List<ContaBancariaModel> contasBancarias = clienteModel.getContasBancarias();
		List<Long> contasBancariasIds = new ArrayList<Long>();
		
		for(ContaBancariaModel contaBancaria : contasBancarias) {
			contasBancariasIds.add(contaBancaria.getId());
		}
		
		clienteDto.setId(clienteModel.getId());
		clienteDto.setCpf(clienteModel.getCpf());
		clienteDto.setNome(clienteModel.getNome());
		clienteDto.setContasBancariasIds(contasBancariasIds);
		
		return clienteDto;
	}
	

	
}
