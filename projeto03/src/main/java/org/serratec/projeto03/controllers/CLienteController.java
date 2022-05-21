package org.serratec.projeto03.controllers;

import java.util.List;

import org.serratec.projeto03.interfaces.IClienteController;
import org.serratec.projeto03.models.ClienteModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class CLienteController implements IClienteController{

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteModel getOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
