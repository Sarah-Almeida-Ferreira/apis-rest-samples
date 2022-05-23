package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.models.ContaBancariaModel;
import org.springframework.http.ResponseEntity;

public interface IContaBancariaController {
	
	public ResponseEntity<String> create(ContaBancariaModel contaBancaria);
	public ResponseEntity<String> delete(Long id);
	public ResponseEntity<String> update(Long Id, ContaBancariaModel contaBancariaAtualizada);
	public ResponseEntity<ContaBancariaModel> getOne(Long id);
	public ResponseEntity<List<ContaBancariaModel>> getAll();
	
}
