package org.serratec.projeto03.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IContaBancariaRepository;
import org.serratec.projeto03.mappers.ClienteMapper;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {
	
	@Autowired
	IContaBancariaRepository contaBancariaRepository;
	ClienteService service;
	ClienteMapper clienteMapper;
	
	public void create(ContaBancariaModel contaBancaria) throws ItemNotFoundException {

		ContaBancariaModel contaBancariaCriada = new ContaBancariaModel();
		
		contaBancariaCriada.setSaldo(contaBancaria.getSaldo());
		contaBancariaCriada.setTitular(service.getOne(contaBancaria.getTitular().getId()));
		
		contaBancariaRepository.save(contaBancariaCriada);
	}
	
	public boolean delete(Long Id) {
		
		ContaBancariaModel contaBancaria = getOne(Id);
		
		if(contaBancaria == null) {
			return false;
		}
		contaBancariaRepository.delete(contaBancaria);	
		return true;
	}
	
	public void update(Long Id, ContaBancariaModel contaBancariaAtualizada) {
		
	}
	
	public ContaBancariaModel getOne(Long Id) {
		Optional<ContaBancariaModel>contaBancariaAchada = contaBancariaRepository.findById(Id);
		
		if (contaBancariaAchada.isEmpty()){
			return null;
		}
		
		return contaBancariaAchada.get();
		
	}
	
	public List<ContaBancariaModel> getAll(){
		
		return contaBancariaRepository.findAll();
		
	}
}
