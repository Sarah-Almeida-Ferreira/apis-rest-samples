package org.serratec.lojasAmazonas.controllers;

import java.util.List;

import org.serratec.lojasAmazonas.models.ClienteModel;
import org.serratec.lojasAmazonas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@PostMapping("/cadastrar")
	public ClienteModel cadastrarCliente(@RequestBody ClienteModel cliente) {
		return service.cadastrarCliente(cliente.getId(),cliente.getCpf(),cliente.getSenha());
	}
	
	@GetMapping("/cliente/{id}")
	public ClienteModel getCliente(@PathVariable String id) {
		return service.getCliente(id);
	}
	
	@GetMapping("/clientes")
	public List<ClienteModel> listarClientes() {
		return service.listarClientes();
	}

}
