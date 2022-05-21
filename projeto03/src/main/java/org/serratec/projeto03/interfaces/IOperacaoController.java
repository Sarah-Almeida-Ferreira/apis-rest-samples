package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.models.OperacaoModel;
import org.springframework.http.ResponseEntity;

public interface IOperacaoController {
	
	public ResponseEntity<String> create(OperacaoModel operacao);
	public OperacaoModel getOne();
	public List<OperacaoModel> getAll();
	
}
