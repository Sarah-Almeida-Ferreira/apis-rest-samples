package org.serratec.projeto03.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.enums.TipoOperacao;
import org.serratec.projeto03.exceptions.InsufficientFundsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.IOperacaoRepository;
import org.serratec.projeto03.models.ContaBancariaModel;
import org.serratec.projeto03.models.OperacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService {
	
	@Autowired
	IOperacaoRepository repository;
	
	@Autowired
	ContaBancariaService contaBancariaService;

	public void createDebito(OperacaoModel operacao) throws InsufficientFundsException, ItemNotFoundException {
		
		ContaBancariaModel conta = operacao.getContaBancaria();
		Double valorOperacao = operacao.getValorOperacao();

		operacao.setTipoOperacao(TipoOperacao.DEBITO);
		operacao.setDataOperacao(LocalDate.now());
		
		verificarSaldoConta(conta, valorOperacao);
		
		conta.setSaldo(conta.getSaldo() - valorOperacao);
		
		contaBancariaService.update(conta.getId(), conta);
		
		repository.save(operacao);
		
	}
	
	public void createCredito(OperacaoModel operacao) throws ItemNotFoundException {
		
		ContaBancariaModel conta = operacao.getContaBancaria();
		Double valorOperacao = operacao.getValorOperacao();
		
		operacao.setTipoOperacao(TipoOperacao.CREDITO);
		operacao.setDataOperacao(LocalDate.now());
		
		conta.setSaldo(conta.getSaldo() + valorOperacao);
		
		contaBancariaService.update(conta.getId(), conta);
		
		repository.save(operacao);
		
	}
	
	public void verificarSaldoConta(ContaBancariaModel conta, Double valor) throws InsufficientFundsException {
		
		if(conta.getSaldo() < valor) {
			throw new InsufficientFundsException("Não há saldo suficiente para esta operação!"); 
		}
	}

	public List<OperacaoModel> getAll() {
		
		return repository.findAll();
	}

	public OperacaoModel getOne(Long id) throws ItemNotFoundException {
		
		Optional<OperacaoModel> operacao = repository.findById(id);
		
		if (operacao.isEmpty()) {
			throw new ItemNotFoundException("Nenhuma operação encontrada com id " + id);
		}
		
		return operacao.get();
	}
	
}
