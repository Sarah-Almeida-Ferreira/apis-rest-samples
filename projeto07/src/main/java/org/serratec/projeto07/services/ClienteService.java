package org.serratec.projeto07.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto07.models.ClienteModel;
import org.serratec.projeto07.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public ClienteModel create(ClienteModel cliente) {	
		
		return repository.save(cliente);		
		
	}
	
	public ClienteModel getOneById(Long Id) {
		
		Optional<ClienteModel> cliente = repository.findById(Id);
		
		if(cliente.isEmpty()) {
			return null; //TODO exception item not found
		}
		
		return cliente.get();
	}
	
	public List<ClienteModel> getAll() {

		return repository.findAll();
	}
	
}
