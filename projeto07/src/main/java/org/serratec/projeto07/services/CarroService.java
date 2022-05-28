package org.serratec.projeto07.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto07.models.CarroModel;
import org.serratec.projeto07.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	CarroRepository repository;

	public CarroModel create(CarroModel carro) {

		return repository.save(carro);

	}

	public void create(List<CarroModel> carros) {

		for (CarroModel carro : carros) {
			
			repository.save(carro);
		}
		
	}

	public CarroModel getOne(Long id) {

		Optional<CarroModel> carro = repository.findById(id);

		if (carro.isEmpty()) {
			return null; // TODO exception
		}

		return carro.get();
	}

	public List<CarroModel> getAll() {

		return repository.findAll();

	}
}
