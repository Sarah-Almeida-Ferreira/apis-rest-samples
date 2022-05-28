package org.serratec.projeto07.mappers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto07.dtos.CarroDtoComIdCliente;
import org.serratec.projeto07.dtos.CarroDtoSemIdCliente;
import org.serratec.projeto07.models.CarroModel;
import org.serratec.projeto07.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

	@Autowired
	ClienteService clienteService;
	
	public CarroModel fromDtoToModel(CarroDtoSemIdCliente dto, Long idCliente) {

		CarroModel model = new CarroModel();

		model.setAno(dto.getAno());
		model.setMarca(dto.getMarca());
		model.setModelo(dto.getModelo());
		model.setDono(clienteService.getOneById(idCliente));

		return model;
	}
	
	public CarroModel fromDtoToModel(CarroDtoComIdCliente dto) {

		CarroModel model = new CarroModel();

		model.setAno(dto.getAno());
		model.setMarca(dto.getMarca());
		model.setModelo(dto.getModelo());
		model.setDono(clienteService.getOneById(dto.getDonoId()));

		return model;
	}
	
	public CarroDtoSemIdCliente fromModelToDto(CarroModel model) {
		
		CarroDtoSemIdCliente dto = new CarroDtoSemIdCliente();
		
		dto.setAno(model.getAno());
		dto.setMarca(model.getMarca());
		dto.setModelo(model.getModelo());
		
		return dto;
		
	}
	
	public CarroDtoComIdCliente fromModelToDtoComIdCliente(CarroModel model) {
		
		CarroDtoComIdCliente dto = new CarroDtoComIdCliente();
		
		dto.setAno(model.getAno());
		dto.setMarca(model.getMarca());
		dto.setModelo(model.getModelo());
		dto.setDonoId(model.getDono().getId());
		
		return dto;
		
	}
	
	public List<CarroModel> fromDtoToModel(List<CarroDtoSemIdCliente> dtos, Long clienteId) {
		
		List<CarroModel> models = new ArrayList<CarroModel>();
		
		for (CarroDtoSemIdCliente dto : dtos) {
			CarroModel model = fromDtoToModel(dto, clienteId);
			
			models.add(model);
		}
		
		return models;
	}
	
	public List<CarroDtoSemIdCliente> fromModelToDto(List<CarroModel> models) {
		
		List<CarroDtoSemIdCliente> dtos = new ArrayList<CarroDtoSemIdCliente>();
		
		for (CarroModel model : models) {
			CarroDtoSemIdCliente dto = fromModelToDto(model);
			
			dtos.add(dto);
		}
		
		return dtos;
	}
}
