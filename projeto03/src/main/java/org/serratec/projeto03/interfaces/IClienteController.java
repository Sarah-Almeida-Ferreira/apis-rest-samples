package org.serratec.projeto03.interfaces;

import java.util.List;

import org.serratec.projeto03.models.ClienteModel;

public interface IClienteController {
	
	public void create();
	public void update();
	public void delete();
	public ClienteModel getOne();
	public List<ClienteModel> getAll();

}
