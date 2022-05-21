package org.serratec.projeto03.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.dtos.OperacaoDto;
import org.serratec.projeto03.interfaces.IOperacaoRepository;
import org.serratec.projeto03.models.OperacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService {
	
	@Autowired
	IOperacaoRepository operacaoRepository;
	
	public OperacaoModel create(OperacaoModel operacao) {
//		
//		if(operacao.getContaBancaria().getSaldo() < operacao.getValor()) {
//			
//		}
		
		return operacaoRepository.save(operacao);		
	}
	
	public OperacaoModel getOne(Long id) {
		
		Optional<OperacaoModel> operacao = operacaoRepository.findById(id);

		if (operacao.isEmpty()) {
			return null;
		}

		return operacao.get();
	
	}
	
	public List<OperacaoModel> getAll(){
		
		return operacaoRepository.findAll();

	}

}
