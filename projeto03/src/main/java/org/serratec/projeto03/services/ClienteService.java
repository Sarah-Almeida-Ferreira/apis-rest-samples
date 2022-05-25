package org.serratec.projeto03.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IClienteRepository;
import org.serratec.projeto03.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	public void create(ClienteModel cliente) {
		
		clienteRepository.save(cliente);
		
	}

	public List<ClienteModel> getAll() {
		
		return clienteRepository.findAll();
	}

	public ClienteModel getOne(Long id) throws ItemNotFoundException {
		
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		
		if(cliente.isEmpty()) {
			throw new ItemNotFoundException("Não foi possível encontrar cliente com o Id informado.");
		}
		
		return cliente.get();
	}

	public ClienteModel update(Long id, ClienteModel cliente) throws ItemNotFoundException {
		
		ClienteModel clienteAtualizado = getOne(id);
		
		if(cliente.getCpf() != null) {
			
			clienteAtualizado.setCpf(cliente.getCpf());			

		}
		
		if (cliente.getNome() != null) {
			
			clienteAtualizado.setNome(cliente.getNome());

		}
		
		return clienteRepository.save(clienteAtualizado);
	}

	public void delete(Long id) throws ItemNotFoundException {
		
		clienteRepository.delete(getOne(id));
		
	}
	
}
