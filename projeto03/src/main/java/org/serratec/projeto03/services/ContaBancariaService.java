package org.serratec.projeto03.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IContaBancariaRepository;
import org.serratec.projeto03.models.CartaoModel;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {
	
	@Autowired
	IContaBancariaRepository contaBancariaRepository;

	@Autowired
	ClienteService clienteService;
	
	public ContaBancariaModel create(ContaBancariaModel conta) {
		
		return contaBancariaRepository.save(conta);
		
	}

	public List<ContaBancariaModel> getAll() {
		
		return contaBancariaRepository.findAll();
	}

	public ContaBancariaModel getOne(Long id) throws ItemNotFoundException {
		
		Optional<ContaBancariaModel> contaBancaria = contaBancariaRepository.findById(id);
		
		if(contaBancaria.isEmpty()) {
			throw new ItemNotFoundException("Não foi possível encontrar conta com Id " + id);
		}
		
		return contaBancaria.get();
	}

	public ContaBancariaModel update(Long id, ContaBancariaModel contaBancaria) throws ItemNotFoundException {

		ContaBancariaModel contaAtualizada = getOne(id);
		
		if (contaBancaria.getSaldo() != null) {

			contaAtualizada.setSaldo(contaBancaria.getSaldo());

		}
		
		if (contaBancaria.getTitular() != null) {

			contaAtualizada.setTitular(contaBancaria.getTitular());
			
		}
		
		return contaBancariaRepository.save(contaAtualizada);
	}

	public void delete(Long id) throws ItemNotFoundException {
		
		ContaBancariaModel conta = getOne(id);
		
		contaBancariaRepository.delete(conta);
		
	}

	public List<CartaoModel> getCartoesByContaId(Long id) throws ItemNotFoundException {
		
		List<CartaoModel> cartoes = getOne(id).getCartoes();
			
		return cartoes;
		
	}

}
