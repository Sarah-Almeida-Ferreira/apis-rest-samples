package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.models.ContaBancariaModel;

public interface IContaBancariaController {
	
	public void create();
	public void delete();
	public void update();
	public ContaBancariaModel getOne();
	public List<ContaBancariaModel> getAll();
	
}
