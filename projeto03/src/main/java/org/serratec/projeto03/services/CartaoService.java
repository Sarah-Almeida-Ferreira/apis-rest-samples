package org.serratec.projeto03.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.serratec.projeto03.interfaces.ICartaoRepository;
import org.serratec.projeto03.models.CartaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {
	
	@Autowired
	ICartaoRepository cartaoRepository;
	
	public void create(CartaoModel cartao) {
		
		cartaoRepository.save(cartao);
		
	}
	
	public CartaoModel getOne(Long id) throws ItemNotFoundException {
		
		Optional<CartaoModel> cartao = cartaoRepository.findById(id);
		
		if (cartao.isEmpty()) {
			throw new ItemNotFoundException("Nenhum cartão encontrado com id " + id);
		}
		
		return cartao.get();
		
	}
	
	public List<CartaoModel> getAll() {
		
		return cartaoRepository.findAll();

	}
}
