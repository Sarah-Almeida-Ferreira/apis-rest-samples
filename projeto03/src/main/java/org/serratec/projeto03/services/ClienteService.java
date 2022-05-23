package org.serratec.projeto03.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.dtos.ClienteResponseDto;
import org.serratec.projeto03.exceptions.CpfAlreadyExistsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IClienteRepository;
import org.serratec.projeto03.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	public void create(ClienteModel cliente) throws ItemNotFoundException, CpfAlreadyExistsException{

//		validarCpfJaCadastrado(cliente.getCpf());
		
		ClienteModel clienteCriado = new ClienteModel();
		
		clienteCriado.setNome(cliente.getNome());
		clienteCriado.setCpf(cliente.getCpf());
		
		clienteRepository.save(clienteCriado);
	
	}
	
	public ClienteModel update(Long id, ClienteModel cliente) throws ItemNotFoundException {
		
		if (cliente.getCpf() == null) {
			
			throw new ItemNotFoundException("Nenhum cliente com id "+ id +" encontrado!");
		}

		return clienteRepository.save(cliente);
		
	}
	
	public boolean delete(Long id) throws ItemNotFoundException {
		
		ClienteModel cliente = getOne(id);
		
		clienteRepository.delete(cliente);
		
		return true;
	}
	
	public ClienteModel getOne(Long id) throws ItemNotFoundException {
		
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		
		if (cliente.isEmpty()) {
			 throw new ItemNotFoundException("Nenhum cliente com id "+id+" encontrado!");
		}
		
		return cliente.get();
		
	}
	
//	public ClienteModel findOneByCpf(String cpf) throws ItemNotFoundException {
//	    Optional<ClienteModel> cliente = clienteRepository.findByCpf(cpf); 
//	    return cliente.orElseThrow(() -> new ItemNotFoundException("Cliente não encontrado com CPF: " + cpf));
//	}
	
//	public void validarCpfJaCadastrado(String cpf) throws ItemNotFoundException, CpfAlreadyExistsException {
//		
//		try {
//			findOneByCpf(cpf);
//		} catch (ItemNotFoundException e) {
//			return;
//		}
//		
//		throw new CpfAlreadyExistsException("Já existe cadastro com esse cpf.");
//		
//	}
	
	public List<ClienteModel> getAll(){
		
		return clienteRepository.findAll();
		
	}
}
