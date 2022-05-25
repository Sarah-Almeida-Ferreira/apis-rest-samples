package org.serratec.projeto03.services;

import java.util.List;

import org.serratec.projeto03.interfaces.IContaBancariaRepository;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {
	
	@Autowired
	IContaBancariaRepository contaBancariaRepository;

	public ContaBancariaModel create(ContaBancariaModel conta) {
		
		return contaBancariaRepository.save(conta);
		
	}

	public List<ContaBancariaModel> getAll() {
		
		return contaBancariaRepository.findAll();
	}

}
